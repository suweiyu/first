package com.su.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su.service.EmpService;

/**
 * Servlet implementation class AllJobServlet
 */
@WebServlet("/files/allJob")
public class AllJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpService service=new EmpService();
		List<String> list=service.getAllJob();
		StringBuffer s=new StringBuffer();
		String job=request.getParameter("job");
		for(String t:list) {
			if(t.equals(job)) {
				s.append("<option value='").append(t).append("' selected>").append(t).append("</option>");
			}else {
				s.append("<option value='").append(t).append("'>").append(t).append("</option>");
			}							
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().println(s.toString());
	}

}
