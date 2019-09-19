package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/config.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");


String mysql_host = "localhost";
String mysql_username = "root";
String mysql_password = "";
String mysql_db = "jsp_final";


      out.write('\n');
      out.write('\n');


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


      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"UTF-8\">\n");
      out.write("\t<title>เข้าสู่ระบบ</title>\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.8.1/css/all.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/login.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<form action=\"login.jsp\" method=\"POST\">\n");
      out.write("\n");
      out.write("<div class=\"wrapper\">\n");
      out.write("  <div class=\"title\">\n");
      out.write("    เข้าสู่ระบบ\n");
      out.write("  </div>\n");
      out.write("  <div class=\"social_media\">\n");
      out.write("    <div class=\"item\">\n");
      out.write("      <i class=\"fab fa-facebook-f\"></i>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"item\">\n");
      out.write("      <i class=\"fab fa-twitter\"></i>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"item\">\n");
      out.write("      <i class=\"fab fa-google-plus-g\"></i>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <div class=\"form\">\n");
      out.write("    <div class=\"input_field\">\n");
      out.write("      <input type=\"text\" placeholder=\"Username\" class=\"input\" name=\"username\" id=\"username\" value=\"");
 if (username != null) { out.print(username); } 
      out.write("\" required ");
 if (request.getParameter("registered") == null) { out.print("autofocus"); } 
      out.write(">\n");
      out.write("      <i class=\"fas fa-user\"></i>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"input_field\">\n");
      out.write("      <input type=\"password\" placeholder=\"Password\" class=\"input\" name=\"password\" id=\"password\" required ");
 if (request.getParameter("registered") != null) { out.print("autofocus"); } 
      out.write(">\n");
      out.write("      <i class=\"fas fa-lock\"></i>\n");
      out.write("    </div>\n");
      out.write("    <input type=\"submit\" class=\"logbtn\" value=\"Sign In\">\n");
      out.write("        <div class=\"bottom-text\">\n");
      out.write("          มีบัญชีอยู่แล้ว? <a href=\"register.jsp\">ลงชื่อเข้าใช้</a>\n");
      out.write("        </div>\n");
      out.write("    </form>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
