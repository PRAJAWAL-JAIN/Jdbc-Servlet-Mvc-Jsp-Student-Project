package com.app.dto;

public class Student {
	private int id;
	private String name;
	private String course;
	private String city;
	private String mobile;

	public Student() {

	}

	public Student(int id, String name, String course, String city, String mobile) {
		this.id = id;
		this.name = name;
		this.course = course;
		this.city = city;
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
