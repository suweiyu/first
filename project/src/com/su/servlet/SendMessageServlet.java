package com.su.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.su.service.SendMessageService;
import com.su.vo.Emp;
import com.su.vo.SendMessage;

/**
 * Servlet implementation class SendMessage
 */
@WebServlet("/files/sendMessage")
public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String messageTitle=request.getParameter("messageTitle");
		String messageContent=request.getParameter("messageContent");
		String priority=request.getParameter("priority");
		String[] empids=request.getParameterValues("empId");
		Integer[] ids=new Integer[empids.length];
		for(int i=0;i<ids.length;i++) {
			ids[i]=Integer.valueOf(empids[i]);
		}
		Emp emp=(Emp)request.getSession().getAttribute("user");
		SendMessageService s=new SendMessageService();
		SendMessage send=new SendMessage();
		send.setMessageTitle(messageTitle);
		send.setMessageContent(messageContent);
		send.setEmpId(emp.getEmpId());
		send.setPriority(Integer.valueOf(priority));
		s.sendMessage(send, ids);
		response.sendRedirect("getSendMessage");
		
		
		
	}

}
