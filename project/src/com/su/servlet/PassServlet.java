package com.su.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PassServlet
 */
@WebServlet("/pass")
public class PassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p="qwertyuiopasdfghjklzxcvbnm0123456789QWERTYUIOPASDFGHJKLZXCVBNM";
		char[] ch=p.toCharArray();
		Random r=new Random();
		StringBuffer s=new StringBuffer();
		for(int i=0;i<4;i++) {
			s.append(ch[r.nextInt(62)]);
		}
		HttpSession session=request.getSession();
		session.setAttribute("pass", s.toString());
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().println(s.toString());
	}

}
