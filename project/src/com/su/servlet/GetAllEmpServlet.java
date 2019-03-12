package com.su.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su.service.EmpService;
import com.su.util.PageInfo;
import com.su.vo.Emp;

/**
 * Servlet implementation class GetAllEmpServlet
 */
@WebServlet("/files/getAllEmp")
public class GetAllEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageInfo pageInfo=new PageInfo(request);
		String empName=request.getParameter("empName");
		String job=request.getParameter("job");
		String empType=request.getParameter("empType");
		Map<String,Object> map=new HashMap<String,Object>();
		if(empName!=null && !empName.equals("")) {
			map.put("empName", empName);
		}
		request.setAttribute("empName", empName);
//		if(job!=null && !job.equals("")) {
//			map.put("job", job);
//		}
//		if(empType!=null && !empType.equals("")) {
//			map.put("empType", empType);
//		}
		if(job==null) {
			map.put("job", "");
			request.setAttribute("job", "0");
		}else if ("0".equals(job)) {
			map.put("job", "");
			request.setAttribute("job", "0");
		}else {
			map.put("job", job);
			request.setAttribute("job", job);
			
		}
		
		if(empType==null) {
			map.put("empType", "");
			request.setAttribute("empType", "0");
		}else if ("0".equals(empType)) {
			map.put("empType", "");
			request.setAttribute("empType", "0");
		}else {
			map.put("empType", empType);
			request.setAttribute("empType", empType);
			
		}
		
		Integer page=(pageInfo.getCurrentPage()-1)*pageInfo.getPageSize();
		map.put("page", page);
		map.put("pageSize", pageInfo.getPageSize());
		EmpService service=new EmpService();
		List<Emp> list=service.getAllEmp(map);
		pageInfo.setList(list);
		if(list!=null) {
			
			pageInfo.setRecordSize(list.size());
		}
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("list", list);
		request.getRequestDispatcher("empList.jsp").forward(request, response);
		
	}

}
