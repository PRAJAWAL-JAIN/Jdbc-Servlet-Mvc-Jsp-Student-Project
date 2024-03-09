package com.app.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.model.StdModel;

@WebServlet("/LoginStudent")
public class LoginStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		StdModel sm = new StdModel();
		int i = sm.loginStd(userName, password);
		if (i != 0) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(10000);
			session.setAttribute("user", userName);
			session.setAttribute("msg", "Welcome To Admin Home");
			response.sendRedirect("adminHome.jsp");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("stdLogin.jsp");
			request.setAttribute("msg", "Incorrect UserName Or Password");
			rd.forward(request, response);
		}
	}

}
