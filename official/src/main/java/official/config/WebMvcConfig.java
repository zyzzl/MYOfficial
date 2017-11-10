package official.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import official.web.interceptor.LoginInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      String[] excludePathPatterns = {"/toRegister", "/register", "/toLogin", "/login", "/codesms", "/toResetPwd", "/resetPwd"};
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns(excludePathPatterns);
        super.addInterceptors(registry);
    }
}
