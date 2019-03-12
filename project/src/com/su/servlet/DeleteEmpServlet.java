package com.su.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su.service.EmpService;

/**
 * Servlet implementation class DeleteEmpServlet
 */
@WebServlet("/files/empDelete")
public class DeleteEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] empIds=request.getParameterValues("empId");
		Integer[] empId=new Integer[empIds.length];
		for(int i=0;i<empId.length;i++) {
			empId[i]=Integer.valueOf(empIds[i]);
		}
		EmpService service=new EmpService();
		service.deleteEmp(empId);
		response.sendRedirect("getAllEmp");
	}

}
