<%-- 
    Document   : profile
    Created on : Jun 29, 2015, 3:10:40 PM
    Author     : ulakbim
--%>
<%@page import="com.sun.xml.rpc.spi.model.Model"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.example.comments" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="newjavascript.js"></script>
        <link href="style.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%
            Object firstName = request.getAttribute("firstName");
            Object lastName = request.getAttribute("lastName");
            Object id = request.getAttribute("id");
            Object imgurl = request.getAttribute("imgurl");
            /*profileClass profile = new profileClass();
             String firstName = request.getParameter("firstName");
             String lastName = request.getParameter("lastName");
             String id_string = request.getParameter("id");
             int id = Integer.parseInt(id_string);
             profile.setFirstName(firstName);
             profile.setLastName(lastName);
             profile.setId(id);*/
            //session.setAttribute("user_id", id);
        %>
        <script>
            $(document).ready(function() {                        
                $('#submit').click(function(event) {  
                    var username=$('#user').val();
                 $.get('ActionServlet',{user:username},function(responseText) { 
                        $('#welcometext').text(responseText);         
                    });
                });
            });
        </script>
        <section class="contents-section">
            <div class="navbar">
                <div class="menu">
                    <ul class="menu-ul">
                        <li class="menu-li"><a href="index.html"><div class="menu-item"><h class="menu-item-h">MAIN PAGE</h></div></a></li>
                        <li class="menu-li"><a href="search.jsp"><div class="menu-item"><h class="menu-item-h">SEARCH</h></div></a></li>
                        <li class="menu-li"><a href="signup.jsp"><div class="menu-item"><h class="menu-item-h">SIGN UP</h></div></a></li>
                        <li class="menu-li"><a href="about.html"><div class="menu-item"><h class="menu-item-h">ABOUT</h></div></a></li>
                    </ul>
                </div>
                <div class="search">
                    <div class="search-bar">
                        <script>
                        </script>
                        <form action="search" method="post">                           
                            <input type="text" placeholder="Search" name="search" id="search">                      
                            <input type="submit" name="Submit" id="submit" onclick="submit()">
                        </form>
                    </div>
                </div>
            </div>
        </section>
        <div class="mainPage">
            <div class="contents">
                <div class="content-profile">
                    <div class="content-profile-style">
                        <div class="image">
                            <div class="image-1">
                                <% out.print("<img class='profile-image' src='" + imgurl + "'>"); %>
                            </div>
                        </div>
                        <div class="names"> 
                            <div class="names-inside">
                                <%
                                    out.print("<h class='names-inside-h'>Name:" + firstName + "</h>");
                                    out.print("<br><br><br><h clasS='names-inside-h'>Surname:" + lastName + "</h>");
                                    out.print("<br><br>" + id);
                                    /*out.print(profile.firstName);
                                     out.print(profile.lastName);
                                     out.print(profile.id);*/
                                %>
                            </div>
                        </div>
                        <div class="comment">
                            <div class="comment-inside">
                                <!--<textarea class="comment-input" type="text" placeholder="Your comment...">
                                -->
                                <%
                                    try {
                                        Object i_obj = request.getAttribute("count");
                                        //comments comm = new comments();
                                        List commArr = (List) request.getAttribute("comm");
                                        request.setAttribute("user_id", id);
                                        
                                        int i = i_obj.hashCode();
                                        List arr=null;
                                        for (int j = 0; j < i; j++) {
                                            comments c = (comments) commArr.get(j);
                                            
                                            out.print("<form action='commentReply' method='POST'>"
                                                    + "<div class='comment-string' name='div' tag='"+ c.getId() +"' >" + c.getComment() + "</div>"
                                                    + "<textarea wrap='hard' class='ownprofile-comment-textarea' name='comment' placeholder='Your reply...'></textarea>"
                                                    + "<input class='submit' type='submit' value='Reply'>"
                                                    + "</form>");
                                        }
                                        
                                        
                                    } catch (Exception e) {
                                        out.print(e);
                                    }
                                %>
                            </div>
                        </div>
                    </div>
                    <div class="second-row">
                        <div class="second-row-left"></div>
                        <div class="second-row-middle"></div>
                        <div class="second-row-right"></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

