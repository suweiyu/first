package com.su.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su.service.SendMessageService;
import com.su.vo.Emp;
import com.su.vo.SendMessage;

/**
 * Servlet implementation class SendMessageDetailServlet
 */
@WebServlet("/files/sendMessageDetail")
public class SendMessageDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sendId=request.getParameter("sendId");
		Emp emp=(Emp) request.getSession().getAttribute("user");
		SendMessageService service=new SendMessageService();
		SendMessage send=service.sendMessgeDetail(Integer.valueOf(sendId), emp.getEmpId());
		request.setAttribute("detail", send);
		request.getRequestDispatcher("sendMessageDetail.jsp").forward(request, response);
	}

}
