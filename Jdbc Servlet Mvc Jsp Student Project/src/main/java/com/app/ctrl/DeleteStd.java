package com.app.ctrl;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dto.Student;
import com.app.model.StdModel;

@WebServlet("/DeleteStd")
public class DeleteStd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int i = new StdModel().stdDelete(id);
		ArrayList<Student> s = new StdModel().getAllStudent();
		if (i != 0) {
			RequestDispatcher rd = request.getRequestDispatcher("studentDetails.jsp");
			request.setAttribute("STD", s);
			request.setAttribute("msg", "Student Data Deleted Successfully");
			rd.forward(request, response);
		} else {
			System.out.println("Student Data Not Deleted");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
