package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
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

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\" dir=\"ltr\">\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title></title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/register.css\">\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js\" charset=\"utf-8\"></script>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("      <form action=\"register.jsp\" method=\"post\" class=\"login-form\">\n");
      out.write("        <h1>register</h1>\n");
      out.write("\n");
      out.write("        <div class=\"txtb\">\n");
      out.write("          <input type=\"text\" name=\"username\" placeholder=\"ชื่อผู้ใช้\" id=\"username\" value=\"");
 if (request.getParameter("username") != null) { out.print(request.getParameter("username")); } 
      out.write("\" required autofocus>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"txtb\">\n");
      out.write("          <input type=\"email\" name=\"email\" placeholder=\"อีเมลล์\" id=\"email\" value=\"");
 if (request.getParameter("email") != null) { out.print(request.getParameter("email")); } 
      out.write("\" required>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"txtb\">\n");
      out.write("          <input type=\"text\" name=\"name\" placeholder=\"ชื่อ-นามสกุล\" id=\"name\" value=\"");
 if (request.getParameter("name") != null) { out.print(request.getParameter("name")); } 
      out.write("\" required>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"txtb\">\n");
      out.write("          <input type=\"password\" name=\"password\" placeholder=\"รหัสผ่าน\"  id=\"password\" required>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"txtb\">\n");
      out.write("          <input type=\"password\" name=\"confirm_password\" placeholder=\"ยืนยันรหัสผ่าน\" id=\"confirm_password\" required>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("\n");
      out.write("        <input type=\"submit\" class=\"logbtn\" value=\"Sign Up\">\n");
      out.write("\n");
      out.write("        <div class=\"bottom-text\">\n");
      out.write("          มีบัญชีอยู่แล้ว? <a href=\"login.jsp\">ลงชื่อเข้าใช้</a>\n");
      out.write("        </div>\n");
      out.write("      </form>\n");
      out.write("  </body>\n");
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
