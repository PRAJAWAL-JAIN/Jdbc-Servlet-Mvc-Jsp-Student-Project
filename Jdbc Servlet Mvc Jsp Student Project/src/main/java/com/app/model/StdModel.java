package com.app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.app.dto.Student;

public class StdModel {
	public static Connection start() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vickey", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}

	public int loginStd(String userName, String password) {
		int i = 0;
		Connection con = null;
		try {
			con = start();
			PreparedStatement pst = con.prepareStatement("select * from login where userName=? and password=?");
			pst.setString(1, userName);
			pst.setString(2, password);

			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				i = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int regData(Student s) {
		int i = 0;
		Connection con = null;
		try {
			con = start();
			PreparedStatement pst = con.prepareStatement("insert into student2 values(?,?,?,?,?)");
			pst.setInt(1, s.getId());
			pst.setString(2, s.getName());
			pst.setString(3, s.getCourse());
			pst.setString(4, s.getCity());
			pst.setString(5, s.getMobile());

			i = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int stdDelete(int id) {
		int i = 0;
		Connection con = null;
		try {
			con = start();
			PreparedStatement pst = con.prepareStatement("delete from student2 where id=?");
			pst.setInt(1, id);

			i = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public ArrayList<Student> getAllStudent() {
		ArrayList<Student> list = new ArrayList<Student>();
		Connection con = null;
		try {
			con = start();
			PreparedStatement pst = con.prepareStatement("select * from student2");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Student st = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("course"),
						rs.getString("city"), rs.getString("mobile"));
				list.add(st);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Student getStudentDetail(int id) {
		Student s = null;
		Connection con = null;
		try {
			con = start();
			PreparedStatement pst = con.prepareStatement("select * from student2 where id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				s = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("course"), rs.getString("city"),
						rs.getString("mobile"));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public int updateStudent(Student bean) {
		int i = 0;
		Connection con = null;
		try {
			con = start();
			PreparedStatement pst = con
					.prepareStatement("update student2 set name=?,course=?,city=?,mobile=? where id=?");
			pst.setString(1, bean.getName());
			pst.setString(2, bean.getCourse());
			pst.setString(3, bean.getCity());
			pst.setString(4, bean.getMobile());
			pst.setInt(5, bean.getId());

			i = pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public ArrayList<Student> getAllDetails() {
		ArrayList<Student> list = new ArrayList<Student>();
		Connection con = null;
		try {
			con = start();
			PreparedStatement pst = con.prepareStatement("select * from student2");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Student s = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("course"),
						rs.getString("city"), rs.getString("mobile"));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
