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
 * Servlet implementation class UpdateReceiveMessageServlet
 */
@WebServlet("/files/updateReceiveMessage")
public class UpdateReceiveMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] receiveIds=request.getParameterValues("receiveId");
		ReceiveMessageService service=new ReceiveMessageService();
		Emp emp=(Emp) request.getSession().getAttribute("user");
		Integer[] receiveId=new Integer[receiveIds.length];
		for(int i=0;i<receiveId.length;i++) {
			receiveId[i]=Integer.valueOf(receiveIds[i]);
		}
		PageInfo pageInfo=new PageInfo(request);
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("empId", emp.getEmpId());
		Integer page=(pageInfo.getCurrentPage()-1)*pageInfo.getPageSize();
		System.out.println(page);
		map.put("page", page);
		map.put("pageSize",pageInfo.getPageSize());
		List<Map<String,Object>>list=service.delete(receiveId, map);
		pageInfo.setList(list);
		if(list!=null) {
			pageInfo.setRecordSize(list.size());
		}
		request.setAttribute("pageInfo", pageInfo);
			request.setAttribute("list", list);
			request.getRequestDispatcher("receive.jsp").forward(request, response);
		
		
	}

}
