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
            Object id = request.getAttribute("user_id");
            Object imgurl = request.getAttribute("imgurl");
            Object user_id = request.getAttribute("user_id");
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
            
            function reply(reply_string,reply_id) {
                var xmlhttp;

                $.get('/commentInsertReply', function(reply_string) { // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                        $('#myDiv').text(reply_string);         // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
                }
                
                
                /*if (window.XMLHttpRequest)
                {// code for IE7+, Firefox, Chrome, Opera, Safari
                    xmlhttp=new XMLHttpRequest();
                }
                else
                {// code for IE6, IE5
                    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                }
                    xmlhttp.onreadystatechange=function() {
                        if (xmlhttp.readyState===4 && xmlhttp.status===200)
                        {
                            document.getElementById("myDiv").innerHTML=xmlhttp.responseText;  
                        }
                //xmlhttp.open("post","commentInsertReply",true);
                //xmlhttp.send();
                var mypostrequest=new ajaxRequest();
                var parameters="reply="+reply_string+"&reply_id="+reply_id;
                mypostrequest.open("POST", "/commentInsertReply", true);
                mypostrequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                mypostrequest.send(parameters);
                
                xmlhttp.open("GET","/project/commentInsertReply?reply="+reply_string+"&reply_id="+reply_id,true);
                xmlhttp.send();*/
            };
           
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
                            <input type="submit" name="Submit" value="Search" id="submit" onclick="submit()">
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
                                        List replyArr = (List) request.getAttribute("replyArr");
                                           
                                        //session.setAttribute("user_id_ownprofile", id);
                                        //request.setAttribute("user_id", id);
                                        int k=1;
                                        int i = i_obj.hashCode();
                                        List arr=null;
                                        for (int j = 0; j < i; j++) {
                                            comments c = (comments) commArr.get(j);
                                            comments r;
                                            
                                            out.print("<form action=''>"
                                                    + "<input type='hidden' name='reply_id' value='" + c.getId() + "'>"
                                                    + "<div class='comment-string' value='"+ c.getId() +"' id='"
                                                    + c.getId() + "')'>" + c.getComment() + "</div>");
                                            
                                            k = replyArr.size();
                                            r=null;
                                            for(int l=0; l<k; l++) {
                                                r = (comments) replyArr.get(l);                                            
                                                if(r.getWriter_id()==c.getId()) {
                                                    out.print("<div class='comment-string' style='float: right;' id='myDiv'>" + r.getComment() + "</div><br>");
                                                }
                                            }
                                                    
                                            out.print("<textarea wrap='hard' class='ownprofile-comment-textarea' name='reply' placeholder='Your reply...'></textarea>"
                                                    + "<input class='submit' type='submit' value='Reply' onsubmit='reply("+r.getComment()+","+c.getId()+")'>"
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

