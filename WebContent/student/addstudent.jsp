<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>添加学生</title>
		<link rel="stylesheet" type="text/css" href="../css/student/addstudent.css"/>
		
	</head>
	<body>
		<div id="all">
			<header></header>
			<nav></nav>
			<section>
				<form action="../studentservlet?para=add" method="post">
					学生姓名：<input type="text" name="student_name"/><br />
					学生成绩：<input type="text" name="student_score"/><br />
					考试科目：<input type="text" name="student_class"/><br />
					<input class="btnstyle" type="submit" value="提交"/>
					<input class="btnstyle" type="reset" value="修改"/>

				</form>
			</section>
			<footer></footer>
		</div>
	</body>
</html>
