/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.mail.internet.HeaderTokenizer;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jboss.weld.servlet.SessionHolder;

/**
 *
 * @author ulakbim
 */
public class search extends HttpServlet {

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
            out.println("<title>Servlet search</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet search at " + request.getContextPath() + "</h1>");
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
        
        String names = request.getParameter("search");
        char[] arr = names.toCharArray();
        int i = 0;
        int flag =0;
        String firstName ="";
        String lastName ="";
        
        while( i != arr.length) {
            if(arr[i] == ' ') {
               flag=1; 
               i++;
            }
            if(flag == 0) {                          
                firstName += arr[i];
            }
            else {
                lastName += arr[i];
            }

            i++;
        }
        //out.println("entered email: " + email);
        //out.println("entered password: " + password);
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            
            Statement stmt = conn.createStatement();
            
            int id=0;
            String email="";
            
            String sql;
            sql = "select * from profilepage where firstName='" + firstName + "' and lastName='" + lastName + "'";
            ResultSet rs = stmt.executeQuery(sql);
            //rs.next();
            //out.println("<font color='red'><b>asdfasdfasdfa</b></font>");
            List<profileClass> profile = new ArrayList<>();
            while(rs.next()) {
                profileClass prof = new profileClass();

                email = rs.getString("email");
                id = rs.getInt("id");
                
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
                //request.setAttribute("id", id);
                //RequestDispatcher rd = request.getRequestDispatcher("commentServlet");
                //rd.forward(request, response);
            }
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("id", id);
            request.setAttribute("email", email);
            //HttpSession session = request.getSession(true);
            //Object user_id = session.getAttribute("user_id");
            //String user_id_string = user_id.toString();
            request.setAttribute("user_id", id);
            request.getRequestDispatcher("/profile.jsp").forward(request, response);
            
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            out.println("catch search");
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
