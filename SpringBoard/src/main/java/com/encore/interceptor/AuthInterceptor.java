package com.encore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	private void saveDest(HttpServletRequest req) {
		String uri = req.getRequestURI();
		String query = req.getQueryString();
		System.out.println("uri>>>" + uri + ", query>>>" + query);
		// 192.168.0.96/sample/delete?id=1234

		if (query == null)
			query = "";
		else
			query = "?" + query;

		req.getSession().setAttribute("dest", uri + query);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("========< 전처리 >==========");

		// 로그인 사용자 인증!! (만약, 로그인 하였다면 login키:success데이터)
		HttpSession session = request.getSession();
		Object login = session.getAttribute("login");

		if (login == null || !login.equals("success")) {
			saveDest(request);// 진행하려고 했던 URL을 세션에 저장!!
			response.sendRedirect("/sample/login");
			return false;
		}

		return true;
		// return true; -----> 매핑URL실행O (계속진행)
		// return false; -----> 매핑URL실행X (실행정지)
	}// 1.실행

	// 2.실행 ==> 매핑 URL (수정,삭제)

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("========< 후처리 >==========");
	}// 3.실행

}
