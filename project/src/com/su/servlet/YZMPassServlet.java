package com.su.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class YZMPassServlet
 */
@WebServlet("/yzmpass")
public class YZMPassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String yzm=request.getParameter("yzm");
		String pass=(String) request.getSession().getAttribute("pass");
		String t=null;
		if(pass.equals(yzm)) {
			t="yes";
		}else {
			t="no";
		}
		//System.out.println(t);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(t);
		//System.out.println(json);
		response.setContentType("text/json;charset=UTF-8");
		
		response.getWriter().println(json);
	}

}
