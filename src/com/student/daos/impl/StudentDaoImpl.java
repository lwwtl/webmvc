package com.student.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.student.beans.Student;
import com.student.daos.StudentDao;
import com.student.utils.DBUtil;

public class StudentDaoImpl implements StudentDao{

	//增增增增增增增增增增增增增增增增增增增增增增增增
	@Override
	public boolean insertStudent(Student student) {
		// TODO Auto-generated method stub
		boolean flag=false;
		DBUtil dbUtil=new DBUtil();
		Connection conn=dbUtil.getConn();
		PreparedStatement pstmt=null;
		try {
			String sql="insert into t_student(student_name,student_score,student_class) values(?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, student.getStudent_name());
			pstmt.setInt(2, student.getStudent_score());
			pstmt.setString(3, student.getStudent_class());
			int num=pstmt.executeUpdate();
			if(num==1)
			{
				flag=true;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
	}
	//查查查查查查查查查查查查查查查查查查查查查查查查查查查
	@Override
	public ArrayList<Student> searchStudentByName(String student_name_para) {
		// TODO Auto-generated method stub
		ArrayList<Student>stulist=new ArrayList<Student>();
		DBUtil dbutil=new DBUtil();
		Connection conn=dbutil.getConn();
		PreparedStatement pstmt=null;
		String sql="select * from t_student where student_name=?";
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, student_name_para);
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				Student student=new Student();
				int student_id=rs.getInt("student_id");
				String student_name=rs.getString("student_name");
				int student_score=rs.getInt("student_score");
				String student_class=rs.getString("student_class");
				student.setStudent_id(student_id);
				student.setStudent_name(student_name);
				student.setStudent_score(student_score);
				student.setStudent_class(student_class);
				stulist.add(student);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return stulist;
	}
	//删删删删删删删删删删删删删删删删删删删删删删删删删删删删删删删删删删删删删删
	@Override
	public boolean deleteStudentById(int student_id) {
		// TODO Auto-generated method stub
		boolean flag=false;
		DBUtil dbUtil=new DBUtil();
		Connection conn=dbUtil.getConn();
		PreparedStatement pstmt=null;
		try {
			String sql="delete from t_student where student_id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, student_id);
			int num=pstmt.executeUpdate();
			if(num==1)
			{
				flag=true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}
	//改改改改改改改改改改改改改改改改改改改改改改改改改改改改改改改改改改
	@Override
	public boolean modifyStudentById(Student student) {
		// TODO Auto-generated method stub
		boolean flag=false;
		DBUtil dbUtil=new DBUtil();
		Connection conn=dbUtil.getConn();
		PreparedStatement pstmt=null;
		try {
			String sql="update t_student set student_name=?,student_score=?,student_class=? where student_id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, student.getStudent_name());
			pstmt.setInt(2, student.getStudent_score());
			pstmt.setString(3, student.getStudent_class());
			pstmt.setInt(4, student.getStudent_id());
			
			int num=pstmt.executeUpdate();
			if(num==1)
			{
				flag=true;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
		
	}

	@Override
	public Student searchStudentById(int student_id) {
		// TODO Auto-generated method stub
		Student student=new Student();
		DBUtil dbutil=new DBUtil();
		Connection conn=dbutil.getConn();
		PreparedStatement pstmt=null;
		String sql="select * from t_student where student_id=?";
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, student_id);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				int student_id_1=rs.getInt("student_id");
				String student_name=rs.getString("student_name");
				int student_score=rs.getInt("student_score");
				String student_class=rs.getString("student_class");
				student.setStudent_id(student_id_1);
				student.setStudent_name(student_name);
				student.setStudent_score(student_score);
				student.setStudent_class(student_class);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return student;
	}
	
//	public static void main(String[] args) {
//		Student student=new Student();	
////		student.setStudent_name("饶立锥");
////		student.setStudent_score(101);
////		student.setStudent_class("数学");
//	
//		StudentDaoImpl studentDaoImpl=new StudentDaoImpl();
////		studentDaoImpl.insertStudent(student);
//	
//		ArrayList<Student> sList=studentDaoImpl.searchStudentByName("唐诗涵");
//		System.out.println(sList);
//	}

}
