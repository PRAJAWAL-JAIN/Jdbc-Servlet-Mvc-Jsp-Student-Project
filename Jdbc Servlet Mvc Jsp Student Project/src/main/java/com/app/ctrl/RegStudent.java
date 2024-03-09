package com.app.ctrl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dto.Student;
import com.app.model.StdModel;

@WebServlet("/RegStudent")
public class RegStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String course = request.getParameter("course");
		String city = request.getParameter("city");
		String mobile = request.getParameter("mobile");

		StdModel sm = new StdModel();
		Student s = new Student(id, name, course, city, mobile);
		int i = sm.regData(s);
		if (i != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("stdRegister.jsp");
			request.setAttribute("msg", "Data Inserted");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("stdRegister.jsp");
			request.setAttribute("msg", "Data Not Inserted");
			rd.forward(request, response);
		}
	}

}
