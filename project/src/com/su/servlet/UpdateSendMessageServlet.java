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

import com.su.service.SendMessageService;
import com.su.util.PageInfo;
import com.su.vo.Emp;
import com.su.vo.SendMessage;

/**
 * Servlet implementation class UpdateSendMessageServlet
 */
@WebServlet("/files/updateSendMessage")
public class UpdateSendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] sendIds=request.getParameterValues("sendId");
		Emp emp=(Emp)request.getSession().getAttribute("user");
		SendMessageService service=new SendMessageService();
		Integer[] sendId=new Integer[sendIds.length];
		for(int i=0;i<sendId.length;i++) {
			sendId[i]=Integer.valueOf(sendIds[i]);
		}
		PageInfo pageInfo=new PageInfo(request);
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("empId", emp.getEmpId());
		Integer page=(pageInfo.getCurrentPage()-1)*pageInfo.getPageSize();
		System.out.println(page);
		map.put("page", page);
		map.put("pageSize",pageInfo.getPageSize());
		List<SendMessage> list=service.updateSendMessageState(sendId,map);
		pageInfo.setList(list);
		if(list!=null) {
			pageInfo.setRecordSize(list.size());
		}
		request.setAttribute("pageInfo", pageInfo);
			request.setAttribute("list", list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("send.jsp").forward(request, response);
		
				
	}

}
