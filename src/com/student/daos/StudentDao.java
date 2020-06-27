package com.student.daos;

import java.util.ArrayList;

import com.student.beans.Student;

public interface StudentDao {
	
	public boolean insertStudent(Student student);	
	public ArrayList<Student>searchStudentByName(String student_name);
	public Student searchStudentById(int student_id);

	public boolean deleteStudentById(int student_id);
	public boolean modifyStudentById(Student student);
}
