/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ulakbim
 */
public class commentInsertReply extends HttpServlet {

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
            out.println("<title>Servlet commentInsert</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet commentInsert   at " + request.getContextPath() + "</h1>");
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
        
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://127.0.0.1:3306/profile";
        
        String USER= "root";
        String PASS= "";
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            java.sql.Statement stmt = conn.createStatement();
            
            //int profile_id = (int)request.getAttribute("id");
            String user_id =request.getParameter("user_id");
            String writer_id = request.getParameter("writer_id");
            String comment = request.getParameter("comment");
            String comment_reply_id_string = request.getParameter("comment_reply_id");
            int comment_reply_id = Integer.parseInt(comment_reply_id_string);            
            String profile_id_string = request.getParameter("profile_id");                    
            int profile_id = Integer.parseInt(profile_id_string);
            
            String insertSQL = "insert into comments"
                       + "(id,user_id,writer_id, comment, comment_reply_id, comment_time, profile_id) values"
                       + "(?,?,?,?,?,?,?)";
                            
            PreparedStatement ps = conn.prepareStatement(insertSQL);
              
            java.util.Date myDate = new java.util.Date("10/10/2009");
            java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());

                    
            ps.setInt(1, 0);
            ps.setString(2, user_id);
            ps.setString(3, writer_id);
            ps.setString(4, comment);
            ps.setInt(5, comment_reply_id);
            ps.setDate(6,sqlDate);
            ps.setInt(7, profile_id); 
               
            int i = ps.executeUpdate();
                if(i == 1){
                  out.println("<br>Record has been inserted");
                }
                else{
                  out.println("failed to insert the data");
                }  
                
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            out.println("catch comments insert");
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
        processRequest(request, response);
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
