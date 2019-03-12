package com.su.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.su.service.ReceiveMessageService;
import com.su.vo.Emp;

/**
 * Servlet implementation class GetReceiveMessageDetailServlet
 */
@WebServlet("/files/getReceiveMessageDetail")
public class GetReceiveMessageDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String receiveId=request.getParameter("receiveId");
		ReceiveMessageService service=new ReceiveMessageService();
		Map<String,Object> map=service.getReceiveMessageDetail(Integer.valueOf(receiveId));
		request.setAttribute("map", map);
		request.getRequestDispatcher("receiveMessageDetail.jsp").forward(request, response);
	}

}
