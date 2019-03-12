package com.su.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.su.service.EmpService;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/files/emp")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpService service=new EmpService();
		List<Map<String,Object>> list=service.getAllName();
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(list);
		response.setContentType("text/json;charset=UTF-8");
		response.getWriter().println(json);
	}

}
