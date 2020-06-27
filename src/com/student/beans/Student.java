package com.student.beans;

public class Student {
	private int Student_id;
	private String Student_name;
	private int Student_score;
	private String Student_class;
	public int getStudent_id() {
		return Student_id;
	}
	public void setStudent_id(int student_id) {
		Student_id = student_id;
	}
	public String getStudent_name() {
		return Student_name;
	}
	public void setStudent_name(String student_name) {
		Student_name = student_name;
	}
	public int getStudent_score() {
		return Student_score;
	}
	public void setStudent_score(int student_score) {
		Student_score = student_score;
	}
	public String getStudent_class() {
		return Student_class;
	}
	public void setStudent_class(String student_class) {
		Student_class = student_class;
	}
	@Override
	public String toString() {
		return "Student [Student_id=" + Student_id + ", Student_name=" + Student_name + ", Student_score="
				+ Student_score + ", Student_class=" + Student_class + "]";
	}
	
}
