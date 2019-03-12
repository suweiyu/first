package com.su.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su.service.EmpService;
import com.su.vo.Emp;

/**
 * Servlet implementation class UpdateEmpServlet
 */
@WebServlet("/files/updateEmp")
public class UpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("empId");
		Integer empId=Integer.valueOf(id);
		EmpService service=new EmpService();
		Emp emp=service.getEmpById(empId);
		request.setAttribute("emp", emp);
		request.setAttribute("job", emp.getJob());
		request.setAttribute("empType", emp.getEmpType());
		request.getRequestDispatcher("updateEmp.jsp").forward(request, response);
	}

}
