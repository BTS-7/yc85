package com.yc.thread.d0730;

public class CookieServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		Cookie cookie = new Cookie("name","wusong");
		response.addCookie(cookie);
		response.getWriter().append("cookie");	
	}
	
	

}
