<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ include file="config.jsp" %>
<%

Object user_id = session.getAttribute("user_id");
if (user_id != null) {
	response.sendRedirect("home.jsp");
}

String username = null;
if (request.getParameter("registered") != null) {
	username = request.getParameter("registered");
}
if (request.getParameter("username") != null) {
	username = request.getParameter("username");
}

Connection connect = null;
Statement statement = null;

String error_text = null;

if ("POST".equalsIgnoreCase(request.getMethod())) {
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connect =  DriverManager.getConnection("jdbc:mysql://" + mysql_host + "/" + mysql_db + "" +"?user=" + mysql_username + "&password=" + mysql_password);
		statement = connect.createStatement();
		ResultSet result = statement.executeQuery("SELECT * FROM `users` WHERE `username` = '" + request.getParameter("username") + "' AND `password` = '" + request.getParameter("password") + "';");
		if (result.next()) {
			session.setAttribute("user_id", result.getString("id"));
			if (request.getParameter("remember_me") != null) {
				session.setMaxInactiveInterval(86400);
			} else {
				session.setMaxInactiveInterval(900);
			}
			response.sendRedirect("home.jsp");
		} else {
			error_text = "ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง";
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
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>เข้าสู่ระบบ</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
  <link rel="stylesheet" href="css/login.css">
</head>
<body>

<form action="login.jsp" method="POST">

<div class="wrapper">
  <div class="title">
    เข้าสู่ระบบ
  </div>
  <div class="social_media">
    <div class="item">
      <i class="fab fa-facebook-f"></i>
    </div>
    <div class="item">
      <i class="fab fa-twitter"></i>
    </div>
    <div class="item">
      <i class="fab fa-google-plus-g"></i>
    </div>
  </div>
  <div class="form">
    <div class="input_field">
      <input type="text" placeholder="Username" class="input" name="username" id="username" value="<% if (username != null) { out.print(username); } %>" required <% if (request.getParameter("registered") == null) { out.print("autofocus"); } %>>
      <i class="fas fa-user"></i>
    </div>
    <div class="input_field">
      <input type="password" placeholder="Password" class="input" name="password" id="password" required <% if (request.getParameter("registered") != null) { out.print("autofocus"); } %>>
      <i class="fas fa-lock"></i>
    </div>
    <input type="submit" class="logbtn" value="Sign In">
        <div class="bottom-text">
          มีบัญชีอยู่แล้ว? <a href="register.jsp">ลงชื่อเข้าใช้</a>
        </div>
    </form>
  </div>
</div>
</body>
</html>
