package official;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class OfficialApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfficialApplication.class, args);
	}

	/**增加上传文件最大数
	 * @return
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement(){
		MultipartConfigFactory config = new MultipartConfigFactory();
		config.setMaxFileSize("80MB");
		config.setMaxRequestSize("100MB");
		return config.createMultipartConfig();
	}

}


