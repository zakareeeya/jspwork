<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ include file="config.jsp" %>
<%
Object user_id = session.getAttribute("user_id");
if (user_id != null) {
	response.sendRedirect("login.jsp");
}
Connection connect = null;
Statement statement = null;
String error_text = null;
if ("POST".equalsIgnoreCase(request.getMethod())) {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connect =  DriverManager.getConnection("jdbc:mysql://" + mysql_host + "/" + mysql_db + "" +"?user=" + mysql_username + "&password=" + mysql_password);
		statement = connect.createStatement();
		if (!statement.executeQuery("SELECT * FROM `users` WHERE `username` = '" + request.getParameter("username") + "';").next()) {
			if (request.getParameter("password").equals(request.getParameter("confirm_password"))) {
				statement.execute("INSERT INTO `users` (`id`, `username`, `password`, `email`, `name`) VALUES (NULL, '" + request.getParameter("username") + "', '" + request.getParameter("password") + "', '" + request.getParameter("email") + "', '" + request.getParameter("name") + "');");
				response.sendRedirect("login.jsp?registered=" + request.getParameter("username"));
			} else {
				error_text = "รหัสผ่านทั้งสองช่องไม่ตรงกัน";
			}
		} else {
			error_text = "มีชื่อผู้ใช้นี้อยู่ในระบบอยู่แล้ว";
		}
	}  catch (Exception e) {
		error_text = e.getMessage();
	}
	try {
		if (statement != null){
			statement.close();
			connect.close();
		}
	} catch (SQLException e) {
	}
}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="css/register.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js" charset="utf-8"></script>
  </head>
  <body>
      <form action="register.jsp" method="post" class="login-form">
        <h1>register</h1>

        <div class="txtb">
          <input type="text" name="username" placeholder="ชื่อผู้ใช้" id="username" value="<% if (request.getParameter("username") != null) { out.print(request.getParameter("username")); } %>" required autofocus>
        </div>
        <div class="txtb">
          <input type="email" name="email" placeholder="อีเมลล์" id="email" value="<% if (request.getParameter("email") != null) { out.print(request.getParameter("email")); } %>" required>
        </div>
        <div class="txtb">
          <input type="text" name="name" placeholder="ชื่อ-นามสกุล" id="name" value="<% if (request.getParameter("name") != null) { out.print(request.getParameter("name")); } %>" required>
        </div>
        <div class="txtb">
          <input type="password" name="password" placeholder="รหัสผ่าน"  id="password" required>
        </div>
        <div class="txtb">
          <input type="password" name="confirm_password" placeholder="ยืนยันรหัสผ่าน" id="confirm_password" required>
        </div>
        

        <input type="submit" class="logbtn" value="Sign Up">

        <div class="bottom-text">
          มีบัญชีอยู่แล้ว? <a href="login.jsp">ลงชื่อเข้าใช้</a>
        </div>
      </form>
  </body>
</html>
