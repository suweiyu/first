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

import com.su.service.ReceiveMessageService;
import com.su.util.PageInfo;
import com.su.vo.Emp;

/**
 * Servlet implementation class GetReceiveMessageServlet
 */
@WebServlet("/files/getReceiveMessage")
public class GetReceiveMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Emp emp=(Emp) request.getSession().getAttribute("user");
		String empName=request.getParameter("empName");
		request.setAttribute("empName", empName);
		PageInfo pageInfo=new PageInfo(request);
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("empId", emp.getEmpId());
		if(empName!=null && !"".equals(empName)) {
			map.put("empName", empName);
		}
		Integer page=(pageInfo.getCurrentPage()-1)*pageInfo.getPageSize();
		System.out.println(page);
		map.put("page", page);
		map.put("pageSize",pageInfo.getPageSize());
		ReceiveMessageService service=new ReceiveMessageService();
		List<Map<String,Object>> list=service.getReceiveMessage(map);
		pageInfo.setList(list);
		if(list!=null) {
			pageInfo.setRecordSize(list.size());
		}
		System.out.println(pageInfo);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("list", list);
		request.getRequestDispatcher("receive.jsp").forward(request, response);
		
	}

}
