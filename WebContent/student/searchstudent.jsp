<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="com.student.beans.Student"%>


<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>查询学生</title>
		<%
			String scheme=request.getScheme();
			String serverName=request.getServerName();
			int port=request.getServerPort();
			String url=request.getRequestURI();
			String basepash=scheme+"://"+serverName+":"+port+"/"+"Student2020/";
		%>
		<link rel="stylesheet" type="text/css" href="<%=basepash%>css/student/addstudent.css"/>
		<link rel="stylesheet" type="text/css" href="<%=basepash%>css/student/searchstudent.css"/>
		<%ArrayList<Student> stulist=(ArrayList<Student>)request.getAttribute("stulist");%>
	</head>
	<body>
		<div id="all">
			<header></header>
			<nav></nav>
			<section>
			<!-- 用绝对路径解决查询完之后的url地址变换 -->
				<form action="http://localhost:8080/Student2020/studentservlet?para=search" method="post">
					<input type="text" name="student_name"/>
					<input type="submit" value="提交"/>
				</form>
				<table class="tb_style">
					<tr>
						<th>学生学号</th>
						<th>学生姓名</th>
						<th>学生分数</th>
						<th>考试科目</th>
						<th>编辑</th>
					</tr>
			
					<%
					//System.out.println("stulist==="+stulist);
					if(stulist!=null){
					for(int i=0;i<stulist.size();i++)
					{
						Student student=(Student)stulist.get(i);
						int student_id=student.getStudent_id();
						String student_name=student.getStudent_name();
						int student_score=student.getStudent_score();
						String student_class=student.getStudent_class();

					%>
					<tr>
					<td><%=student_id %></td>
					<td><%=student_name %></td>
					<td><%=student_score %></td>
					<td><%=student_class%></td>
					<td>
					<a href="studentservlet?para=delete&student_id=<%=student_id%>">删除</a>/
					<a href="studentservlet?para=modify1&student_id=<%=student_id%>">修改</a>
					</td>
					</tr>
					<%
					}
					}
					%>
				</table>
			</section>
			<footer></footer>
		</div>
	</body>
</html>
