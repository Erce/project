package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signUp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Sign Up</title>\n");
      out.write("        <link href=\"signUp.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"menu\">\n");
      out.write("            <ul class=\"menu-ul\">\n");
      out.write("                <li class=\"menu-li\"><a href=\"index.html\"><div class=\"menu-item\"><h class=\"menu-item-h\">MAIN PAGE</h></div></a></li>\n");
      out.write("                <li class=\"menu-li\"><a href=\"login.jsp\"><div class=\"menu-item\"><h class=\"menu-item-h\">LOGIN</h></div></a></li>\n");
      out.write("                <li class=\"menu-li\"><a href=\"search.jsp\"><div class=\"menu-item\"><h class=\"menu-item-h\">SEARCH</h></div></a></li>\n");
      out.write("                <li class=\"menu-li\"><a href=\"signup.html\"><div class=\"menu-item\"><h class=\"menu-item-h\">SIGN UP</h></div></a></li>\n");
      out.write("                <li class=\"menu-li\"><a href=\"about.html\"><div class=\"menu-item\"><h class=\"menu-item-h\">ABOUT</h></div></a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"mainPage\">\n");
      out.write("            <div class=\"form\">\n");
      out.write("                <form method=\"post\" action=\"signUp\">\n");
      out.write("                    <div class=\"inside-form\">\n");
      out.write("                        First Name: <input type=\"text\" name=\"firstName\"><br>\n");
      out.write("                        Last Name: <input type=\"text\" name=\"lastName\"><br>\n");
      out.write("                        E-mail: <input type=\"text\" name=\"email\"><br>\n");
      out.write("                        Date of Birth: <br>\n");
      out.write("                        Day: <select name=\"day\"><option value=\"\"></option>");

                        int i=1;
                        for(;i<=30;i++) { out.print("<option value='"+i+"'>"+i+"</option>");}
                        
      out.write("</select>\n");
      out.write("                        Month: <select name=\"month\"><option value=\"\"></option></select>\n");
      out.write("                        Year: <select name=\"year\"><option value=\"\"></option></select><br>\n");
      out.write("                        Password: <input type=\"password\" name=\"password\"><br>\n");
      out.write("                        Password Check: <input type=\"password\" name=\"password\"><br>\n");
      out.write("                        Gender: <select name=\"gender\"><option></option></select><br>\n");
      out.write("                        <input type=\"submit\" id=\"submit\">\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
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
