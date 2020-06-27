package com.student.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.student.beans.Student;
import com.student.daos.StudentDao;
import com.student.daos.impl.StudentDaoImpl;

public class StudentServlets extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Post请求是以二进制流的形式发送到服务器，服务器收到数据后，默认以iso-8859-1进行编码。
		//需要在post请求参数前设置字符集
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("UTF-8");
		String para=req.getParameter("para");
		if(para.equals("add"))
		{
			addStudent(req, resp);
		}else if(para.equals("search")) {
			searchStudent(req, resp);
		}else if(para.equals("delete")) {
			deleteStudentById(req,resp);
		}else if(para.equals("modify1")) {
			searchStudentById(req,resp);
		}else if(para.equals("modify2")) {
			modifyStudent(req,resp);
		}
	
	}
private void searchStudentById(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		// TODO Auto-generated method stub
	//根据页面的student_id查询出student
	String student_id_str=req.getParameter("student_id");
	int student_id=Integer.parseInt(student_id_str);
	StudentDao studentDao=new StudentDaoImpl();
	Student student=studentDao.searchStudentById(student_id);
	
	try {
		req.setAttribute("student", student);
		req.getRequestDispatcher("/student/modifystudent.jsp").forward(req, resp);
		
				
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
private void modifyStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String student_id_str=req.getParameter("student_id");
	int student_id=Integer.parseInt(student_id_str);
	String student_name=req.getParameter("student_name");
	String student_score_str=req.getParameter("student_score");
	int student_score=Integer.parseInt(student_score_str);
	String student_class=req.getParameter("student_class");
	
	Student student=new Student();
	student.setStudent_id(student_id);
	student.setStudent_name(student_name);
	student.setStudent_score(student_score);
	student.setStudent_class(student_class);
	
	StudentDao studentDao=new StudentDaoImpl();
	
	boolean flag=studentDao.modifyStudentById(student);
	PrintWriter out=resp.getWriter();
	if(flag)
	{
		out.println("<script type=\'text/javascript\'>alert('modify success');window.location.href='http://localhost:8080/Student2020/student/searchstudent.jsp';</script>");
	}
	else {
		out.println("<script type=\'text/javascript\'>alert('modify failure');window.history.back(-1);</script>");

	}
	}
private void deleteStudentById(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		// TODO Auto-generated method stub
		String student_id_str=req.getParameter("student_id");
		int student_id=Integer.parseInt(student_id_str);
		StudentDao studentDao=new StudentDaoImpl();
		
		boolean flag=studentDao.deleteStudentById(student_id);
		PrintWriter out=resp.getWriter();
		if(flag)
		{
			out.println("<script type=\'text/javascript\'>alert('delete success');window.location.href='http://localhost:8080/Student2020/student/searchstudent.jsp';</script>");
		}
		else {
			out.println("<script type=\'text/javascript\'>alert('delete failure');window.history.back(-1);</script>");

		}
	}
public void addStudent(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
	
	
	String student_name=req.getParameter("student_name");
	String student_score_str=req.getParameter("student_score");
	int student_score=Integer.parseInt(student_score_str);
	String student_class=req.getParameter("student_class");
	Student student=new Student();

	student.setStudent_name(student_name);
	student.setStudent_score(student_score);
	student.setStudent_class(student_class);
	
	StudentDao studentDao=new StudentDaoImpl();
	
	boolean flag=studentDao.insertStudent(student);
	PrintWriter out=resp.getWriter();
	if(flag)
	{
		out.println("<script type=\'text/javascript\'>alert('success');window.history.back(-1);</script>");
	}
	else {
		out.println("<script type=\'text/javascript\'>alert('failure');window.history.back(-1);</script>");

	}
}
	
	
public void searchStudent(HttpServletRequest request, HttpServletResponse response) {
	
	String student_name=request.getParameter("student_name");
	//System.out.println("stulist="+student_name);
	StudentDao studentDao=new StudentDaoImpl();
	ArrayList<Student>stulist=studentDao.searchStudentByName(student_name);
	//System.out.println("stulist="+stulist);
	try {
		request.setAttribute("stulist", stulist);
		request.getRequestDispatcher("/student/searchstudent.jsp").forward(request, response);
		
				
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}