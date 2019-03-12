package com.su.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su.service.EmpService;
import com.su.vo.Emp;

/**
 * Servlet implementation class AddEmpServlet
 */
@WebServlet("/files/addEmp")
public class AddEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empNo=request.getParameter("empNo");
		String password=request.getParameter("password");
		String empName=request.getParameter("empName");
		String sex=request.getParameter("sex");
		String birth1=request.getParameter("birth");
		String idCard=request.getParameter("idCard");
		String email=request.getParameter("email");
		String tel=request.getParameter("tel");
		String address=request.getParameter("address");
		String empType=request.getParameter("empType");
		String bankName=request.getParameter("bankName");
		String bankNo=request.getParameter("bankNo");
		String sal=request.getParameter("sal");
		String comm=request.getParameter("comm");
		String subsidy=request.getParameter("subsidy");
		String hiredate1=request.getParameter("hiredate");
		String descript=request.getParameter("descript");
		String job=request.getParameter("job");
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date birth=null;
		try {
			if(birth1!=null) {
				java.util.Date utilDate=format.parse(birth1);
				 birth=new java.sql.Date(utilDate.getTime());
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Emp emp=new Emp();
		emp.setEmpNo(empNo);
		emp.setPassword(password);
		emp.setEmpName(empName);
		emp.setSex(sex);
		emp.setBirth(birth);
		emp.setIdCard(idCard);
		emp.setEmail(email);
		emp.setTel(tel);
		emp.setAddress(address);
		emp.setEmpType(empType);
		emp.setBankName(bankName);
		emp.setBankNo(bankNo);
		if(sal!=null && !sal.equals("")) {
			emp.setSal(Integer.valueOf(sal));
		}
		if(comm!=null && !comm.equals("")) {
			emp.setComm(Integer.valueOf(comm));
			
		}
		if(subsidy!=null && !subsidy.equals("")) {
			emp.setSubsidy(Integer.valueOf(subsidy));
		}
		java.sql.Date hiredate=null;
		try {
			if(hiredate1!=null) {
				java.util.Date utilHireDate=format.parse(hiredate1);
				hiredate=new java.sql.Date(utilHireDate.getTime());
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		emp.setHiredate(hiredate);
		emp.setDescript(descript);
		emp.setJob(job);
		EmpService service=new EmpService();
		service.addEmp(emp);
		response.sendRedirect("getAllEmp");
		
		
	
		
	}

}
