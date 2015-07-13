/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.security.provider.MD5;
import sun.security.x509.AlgorithmId;

/**
 *
 * @author ulakbim
 */
public class signUp extends HttpServlet {

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
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet signUp</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet signUp at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        byte [] bytesofMessage = password.getBytes("UTF-8");
        //MessageDigest md = MessageDigest.getInstance("MD5");
        //byte [] theDigest = md.digest(bytesofMessage);
        String month = request.getParameter("month");
        String day = request.getParameter("day");
        String year = request.getParameter("year");
        String gender = request.getParameter("gender");
        
        String JDBC_DRIVER="com.mysql.jdbc.Driver";
        String DB_URL="jdbc:mysql://127.0.0.1:3306/profile";
        
        String USER="root";
        String PASS="";
        
        response.setContentType("text/html");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            Statement stmt = conn.createStatement();
            
            String sql;
            sql = "select email from profilepage where email='" + email + "'";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            
            if( !rs.next() ) {
              // out.println("adfasdfasdfasdfa");
               /*out.println("  firstName: " + firstName
                         + "  lastName: " + lastName
                         + "  email: " + email
                         + "  day: " + day
                         + "  month: " + month
                         + "  year: " + year
                         + "  password: " + password
                         + "  gender: " + gender);
            */
                String insertSQL = "insert into profilepage"
                       + "(born,email,imgurl,firstName,lastName,id,password,gender,comment_id) values"
                       + "(?,?,?,?,?,?,?,?,?)";
               
                
                PreparedStatement ps = conn.prepareStatement(insertSQL);
                
                
                ps.setDate(1, new Date(123412346l));
                ps.setString(2, email);
                ps.setString(3, "");
                ps.setString(4, firstName);
                ps.setString(5, lastName);
                //ps.setInt(6, );
                ps.setString(7, password);
                ps.setString(8, "M");
                //ps.setInt(9, 9);
               
                int i = ps.executeUpdate();
                if(i == 1){
                  out.println("<br>Record has been inserted");
                }
                else{
                  out.println("failed to insert the data");
                 }   
                
            }
            else { 
                out.println("e-mail is defined in the system");
            }            
        } catch (ClassNotFoundException | SQLException ex) {
            //System.out.println("asdasdasdasdasdasdaxczxczxczixşcaisşdiaşsdaisşciasşdücaisşd");
            out.println("Catch signUp get get get get");
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
        PrintWriter out = response.getWriter();
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        byte [] bytesofMessage = password.getBytes("UTF-8");
        //MessageDigest md = MessageDigest.getInstance("MD5");
        //byte [] theDigest = md.digest(bytesofMessage);
        String month = request.getParameter("month");
        String day = request.getParameter("day");
        String year = request.getParameter("year");
        String gender = request.getParameter("gender");
        
        String JDBC_DRIVER="com.mysql.jdbc.Driver";
        String DB_URL="jdbc:mysql://127.0.0.1:3306/profile";
        
        String USER="root";
        String PASS="";
        
        response.setContentType("text/html");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            Statement stmt = conn.createStatement();
            
            String sql;
            sql = "select email from profilepage where email='" + email + "'";
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            
            if( !rs.next() ) {
              // out.println("adfasdfasdfasdfa");
               /*out.println("  firstName: " + firstName
                         + "  lastName: " + lastName
                         + "  email: " + email
                         + "  day: " + day
                         + "  month: " + month
                         + "  year: " + year
                         + "  password: " + password
                         + "  gender: " + gender);
            */
               String insertSQL = "insert into profilepage"
                       + "(born,email,imgurl,firstName,lastName,id,password,gender,comment_id) values"
                       + "(?,?,?,?,?,?,?,?,?)";
               
                
                PreparedStatement ps = conn.prepareStatement(insertSQL);
                
                
                ps.setDate(1, new Date(123412346l));
                ps.setString(2, email);
                ps.setString(3, "");
                ps.setString(4, firstName);
                ps.setString(5, lastName);
                ps.setInt(6, 0);
                ps.setString(7, password);
                ps.setString(8, gender);
                ps.setInt(9, 9);
               
                int i = ps.executeUpdate();
                if(i == 1){
                    RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
                    rd.forward(request, response);
                }
                else{
                  out.println("failed to insert the data");
                 }   
                
            }
            else { 
                RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
                rd.forward(request, response);
                out.println("e-mail is defined in the system");
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            //System.out.println("asdasdasdasdasdasdaxczxczxczixşcaisşdiaşsdaisşciasşdücaisşd");
            out.println("Catch signUp post");
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
