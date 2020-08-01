package com.yc.thread.d0729;

import java.io.PrintWriter;

public class HelloServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		
		String name = request.getParameter("name");
		
		PrintWriter out = response.getWriter();
		// 输出到页面
		out.print("<h1>hello "+name+"</h1>");
		
		System.out.println("hello world!");
	}
	
}
