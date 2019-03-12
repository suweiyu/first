package com.su.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.su.service.EmpService;
import com.su.vo.Emp;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empNo=request.getParameter("empNo");
		String password=request.getParameter("password");
		if(empNo!=null &&!"".equals(empNo)&& password!=null&&!"".equals(empNo)) {
			EmpService service=new EmpService();
			Emp user=service.getUser(empNo, password);
			if(user!=null) {
				HttpSession session=request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("index.html");
			}
			else {
				response.sendRedirect("login.jsp");
			}
		}else {
			response.sendRedirect("login.jsp");
		}
	}

}
