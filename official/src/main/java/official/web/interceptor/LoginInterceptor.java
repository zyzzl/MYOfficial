package official.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * http请求进入controller之前
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		/*System.out.println("preHandle");
		Cookie c = new Cookie("jsessionid", "123456");
		c.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(c);
		HttpSession session = request.getSession();
		session.setAttribute("user", "hehhe");
		if (session.getAttribute("user") == null || "".equals(session.getAttribute("user"))) {
			response.sendRedirect("toLogin");
			return false;
		}*/
		return true;
	}

	/**
	 * controller处理完成之后
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");

	}

	/**
	 * http请求返回页面之后
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion");

	}

}
