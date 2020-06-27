<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="com.student.beans.*" %>>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>修改信息</title>
		<%
			String scheme=request.getScheme();
			String serverName=request.getServerName();
			int port=request.getServerPort();
			String url=request.getRequestURI();
			String basepash=scheme+"://"+serverName+":"+port+"/"+"Student2020/";
		%>
		<link rel="stylesheet" type="text/css" href="<%=basepash%>css/student/addstudent.css"/>
	
		<%
		Student student=(Student)request.getAttribute("student");
		int student_id=student.getStudent_id();
		String student_name=student.getStudent_name();
		int student_score=student.getStudent_score();
		String student_class=student.getStudent_class();
		%>
	</head>
	<body>
		<div id="all">
			<header></header>
			<nav></nav>
			<section>
				<form action="<%=basepash%>studentservlet?para=modify2" method="post">
					学生学号：<input type="text" name="student_id" value="<%=student_id%>" readonly="true"/><br />
					学生姓名：<input type="text" name="student_name" value="<%=student_name%>"/><br />
					学生成绩：<input type="text" name="student_score" value="<%=student_score%>"/><br />
					考试科目：<input type="text" name="student_class" value="<%=student_class%>"/><br />
					<input class="btnstyle" type="submit" value="修改"/>
					<input class="btnstyle" type="reset" value="重填"/>

				</form>
			</section>
			<footer></footer>
		</div>
	</body>
</html>
