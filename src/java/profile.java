

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.example.comments;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.basic.BasicBorders;

/**
 *
 * @author ulakbim
 */
public class profile extends HttpServlet {

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
            out.println("<title>Servlet profile</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet profile at " + request.getContextPath() + "</h1>");
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
            
            String email = (String)request.getAttribute("email");
            String sql = "select * from profilepage where email='" + email + "'";
            ResultSet rs = stmt.executeQuery(sql);
            
            //String ad = rs.getString("first");
            //String soyad = rs.getString("soyad");
            int flag=0;
            boolean a;
            int user_id=0;
            if( a= rs.next() ) {
                flag = 1;
            }
            List<profileClass> profile = new ArrayList<>();
            while(a) {
                profileClass prof = new profileClass();
                
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                int id = rs.getInt("id");
                String imgurl = rs.getString("imgurl");
                
                
                //**********
                request.setAttribute("firstName", firstName);
                request.setAttribute("lastName", lastName);
                request.setAttribute("id", id);
                //request.getRequestDispatcher("/profile.jsp").forward(request, response);
                
                //**********
                /*int id = rs.getInt("id");
                int user_id = rs.getInt("firstName");
                int writer_id  = rs.getInt("lastName");*/
                //String comment = rs.getString("comment");
                //int comment_reply_id = rs.getInt("comment_reply_id");
                
                prof.setEmail(email);
                prof.setFirstName(firstName);
                prof.setLastName(lastName);
                prof.setId(id);
                profile.add(prof);
                /*
                comm.setId(id);
                //comm.setUser_id(user_id);
                comm.setWriter_id(writer_id);
                //comm.setComment(comment);
                //comm.setComment_reply_id(comment_reply_id);
                comments.add(comm);*/
                
                // sending request to comments by id 
                request.setAttribute("imgurl", imgurl);
                user_id = id;
                a = rs.next();
            }
            if(flag==1) {
                Result res = Result.SUCCESS.setContent(profile);
                Gson gs = new Gson();
                out.print(gs.toJson(res));
            }
            
            //HttpSession session = request.getSession(true);
            String sql1;
            
            if(request.getAttribute("user_id") != null) {
                user_id = (int) request.getAttribute("user_id");
                sql1 = "select * from comments where user_id=" + user_id;
                String sql2 = "select * from profilepage where id=" + user_id;
                ResultSet rs1 = stmt.executeQuery(sql2);
                rs1.next();
                String firstName = rs1.getString("firstName");
                String lastName = rs1.getString("lastName");
                String imgurl = rs1.getString("imgurl");
                request.setAttribute("firstName", firstName);
                request.setAttribute("lastName", lastName);
                request.setAttribute("imgurl", imgurl);
                rs = stmt.executeQuery(sql1);
            }
            else {
                sql = "select * from comments where user_id=" + user_id;
                rs = stmt.executeQuery(sql);
            }

            int count = 0;
            //String ad = rs.getString("first");
            //String soyad = rs.getString("soyad");
            
            List<comments> commArr = new ArrayList<>();
            List<comments> replyArr = new ArrayList<>();
            while(rs.next()) {
                comments comm = new comments();
                int writer_id = rs.getInt("writer_id");
                String comment = rs.getString("comment");
                int comment_reply_id = rs.getInt("comment_reply_id");
                int comm_id = rs.getInt("id");
                comm.setId(comm_id);
                comm.setUser_id(user_id);
                comm.setWriter_id(writer_id);
                comm.setComment(comment);
                comm.setComment_reply_id(comment_reply_id);
                if( comment_reply_id == 0 ) {
                    commArr.add(comm);
                }
                else if( comment_reply_id == 1 ) {
                    replyArr.add(comm);
                }
                count++;
            }

            request.setAttribute("comm", commArr);
            request.setAttribute("replyArr", replyArr);
            request.setAttribute("count", 8);
            
            request.setAttribute("user_id", user_id);
            RequestDispatcher rd = request.getRequestDispatcher("ownprofile.jsp");
            rd.forward(request, response);
            
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            out.println(e);
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
        doGet(request, response);
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
