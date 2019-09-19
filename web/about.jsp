<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ include file="config.jsp" %>
<%

Object user_id = session.getAttribute("user_id");
if (user_id == null) {
	response.sendRedirect("login.jsp");
}

Connection connect = null;
Statement statement = null;

try {
	Class.forName("com.mysql.jdbc.Driver");
	connect =  DriverManager.getConnection("jdbc:mysql://" + mysql_host + "/" + mysql_db + "" +"?user=" + mysql_username + "&password=" + mysql_password);
	statement = connect.createStatement();
	ResultSet user_data = statement.executeQuery("SELECT * FROM `users` WHERE `id` = '" + user_id.toString() + "';");
	if (!user_data.next()) {
		session.removeAttribute("user_id");
		response.sendRedirect("login.jsp");
	}
}  catch (Exception e) {
	out.println(e.getMessage());
	e.printStackTrace();
}
try {
	if (statement != null){
		statement.close();
		connect.close();
	}
} catch (SQLException e) {
}

%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>ผู้จัดทำ</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/offcanvas.css" rel="stylesheet">
  <link href="css/style.css" rel="stylesheet">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css">
  <link rel="stylesheet" href="css/about.css">
	<script defer src="js/all.js"></script>
</head>
<body class="bg-light">
	<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand mb-0 h1" href="#">JSP Final</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item">
						<a class="nav-link" href="home.jsp"><i class="fas fa-home"></i>&nbsp; หน้าหลัก</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="data.jsp"><i class="fas fa-list"></i>&nbsp; รายชื่อผู้ใช้</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="map.jsp"><i class="fas fa-map-marked-alt"></i>&nbsp; แผนที่</a>
					</li>
					<li class="nav-item active">
						<a class="nav-link" href="#"><i class="fas fa-id-card"></i>&nbsp; ผู้จัดทำ</a>
					</li>
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item">
						<a class="nav-link" href="logout.jsp"><i class="fas fa-sign-out-alt"></i>&nbsp; ออกจากระบบ</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="team-section">
    <div class="inner-width">
      <h1>จัดทำโดย</h1>
      <div class="pers">


        <div class="pe">
          <img src="img/1.jpg" alt="">
		  <div class="p-des">ผู้พัฒนาระบบ</div>
          <p> Zakareeya Saemesae <br>รหัสนักศึกษา 6139010011 </p>
          <div class="p-sm">
            <a href="https://www.facebook.com/profile.php?id=100004302799458"><i class="fab fa-facebook-f"></i></a>
            <a href="#"><i class="fab fa-twitter"></i></a>
            <a href="#"><i class="fab fa-instagram"></i></a>
          </div>
        </div>

        <div class="pe">
          <img src="img/2.jpg" alt="">
		  <div class="p-des">ผู้ออกแบบ</div>
          <p> Ameen Sahoh <br>รหัสนักศึกษา 6139010005 </p>
          <div class="p-sm">
            <a href="https://www.facebook.com/amin.sahoh.5"><i class="fab fa-facebook-f"></i></a>
            <a href="#"><i class="fab fa-twitter"></i></a>
            <a href="#"><i class="fab fa-instagram"></i></a>
          </div>
        </div>

        <div class="pe">
          <img src="img/3.jpg" alt="">
		   <div class="p-des">อาจารย์ที่ปรึกษา</div>
          <p> teera BinKasem <br> หัวหน้าแผนก เทคโนโลยีสารสนเทศ</p>
          <div class="p-sm">
            <a href="https://www.facebook.com/BillKasem"><i class="fab fa-facebook-f"></i></a>
            <a href="#"><i class="fab fa-twitter"></i></a>
            <a href="#"><i class="fab fa-instagram"></i></a>
          </div>
        </div>

      </div>

    </div>
  </div>
	<p class="mt-4 small text-muted text-center">&copy; 2019 LikeZky</p>
	<script defer src="js/jquery-3.4.1.min.js"></script>
	<script defer src="js/bootstrap.min.js"></script>
</body>

</html>
