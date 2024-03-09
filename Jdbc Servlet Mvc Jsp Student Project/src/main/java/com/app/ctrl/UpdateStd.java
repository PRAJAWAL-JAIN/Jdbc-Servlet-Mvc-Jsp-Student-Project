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

@WebServlet("/UpdateStd")
public class UpdateStd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Student std = new StdModel().getStudentDetail(id);

		RequestDispatcher rd = request.getRequestDispatcher("stdUpdate.jsp");
		request.setAttribute("STD", std);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String course = request.getParameter("course");
		String city = request.getParameter("city");
		String mobile = request.getParameter("mobile");
		
		Student bean=new Student(id,name,course,city,mobile);
		int i=new StdModel().updateStudent(bean);
		if(i!=0) {
			ArrayList<Student>s=new StdModel().getAllDetails();
			RequestDispatcher rd=request.getRequestDispatcher("studentDetails.jsp");
			request.setAttribute("STD", s);
			request.setAttribute("msg","Student Detail Updated Successfully");
			rd.forward(request, response);
		}
	}

}
