

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ulakbim
 */
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        String JDBC_DRIVER="com.mysql.jdbc.Driver";
        String DB_URL="jdbc:mysql://127.0.0.1:3306/profile";
        
        String USER="root";
        String PASS="";
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("email");
        
        String password = request.getParameter("password");
            
        //out.println("entered email: " + email);
        //out.println("entered password: " + password);
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            Statement stmt = conn.createStatement();
            
            String sql;
            sql = "select email,password from profilepage where email='" + email + "'";
            ResultSet rs = stmt.executeQuery(sql);
            //rs.next();
            //out.println("<font color='red'><b>asdfasdfasdfa</b></font>");
            while(rs.next()) {
                out.println(rs.getString("email"));
                if( rs.getString("password").equals(password))
                {
                    out.println("<font color='red'><b>password is correct</b></font>");
                    request.setAttribute("email", email);
                    RequestDispatcher rd = request.getRequestDispatcher("profile");
                    rd.forward(request, response);
                }
                else if (rs.getString("email").isEmpty()) {
                    out.println("E-mail is not registered.");
                    RequestDispatcher rd = request.getRequestDispatcher("login");
                    rd.include(request, response);
                }
                else {
                    out.println("<font color='red'><b>You have entered incorrect password</b></font>");
                    RequestDispatcher rd = request.getRequestDispatcher(("login"));
                    rd.include(request, response);
                } 
            }
        } catch (SQLException se) {
            out.println("<font color='red'><b>catch1 login</b></font>");
            se.printStackTrace();
        
        } catch ( Exception e ) {
            out.println("<font color='red'><b>catch2 login</b></font>");
            e.printStackTrace();
        } finally {
            
            out.println("<font color='red'><b>finally login</b></font>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        String JDBC_DRIVER="com.mysql.jdbc.Driver";
        String DB_URL="jdbc:mysql://127.0.0.1:3306/profile";
        
        String USER="root";
        String PASS="";
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
            
        //out.println("entered email: " + email);
        //out.println("entered password: " + password);
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            Statement stmt = conn.createStatement();
            
            String sql;
            sql = "select email,password from profilepage where email='" + email + "'";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            //out.println("<font color='red'><b>asdfasdfasdfa</b></font>");
            out.println(rs.getString("email"));
            if( rs.getString("password").equals(password))
            {
                out.println("<font color='red'><b>password is correct</b></font>");
                request.setAttribute("email", email);
                RequestDispatcher rd = request.getRequestDispatcher("profile");
                rd.forward(request, response);
            }
            else if (rs.getString("email").isEmpty()) {
                out.println("E-mail is not registered.");
                RequestDispatcher rd = request.getRequestDispatcher("login");
                rd.include(request, response);
            }
            else {
                out.println("<font color='red'><b>You have entered incorrect password</b></font>");
                RequestDispatcher rd = request.getRequestDispatcher(("login"));
                rd.include(request, response);
            } 
        } catch (SQLException se) {
            out.println("<font color='red'><b>catch1</b></font>");
            se.printStackTrace();
        
        } catch ( Exception e ) {
            out.println("<font color='red'><b>catch2</b></font>");
            e.printStackTrace();
        } finally {
            out.println("<font color='red'><b>finally</b></font>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
