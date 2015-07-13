<%-- 
    Document   : profile
    Created on : Jun 29, 2015, 3:10:40 PM
    Author     : ulakbim
--%>

<%@page import="java.io.PrintWriter"%>
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
        %>
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
                        <input type="text" placeholder="Search" name="search" id="search">
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
                                <% out.print("<img class='profile-image' src='"+ imgurl+"'>"); %>
                            </div>
                        </div>
                        <div class="names"> 
                            <div class="names-inside">
                            <% 
                                out.print("<h class='names-inside-h'>Name:" + firstName + "</h>");
                                out.print("<br><br><br><h clasS='names-inside-h'>Surname:" +lastName + "</h>");
                                out.print("<br><br>" + id);
                                /*out.print(profile.firstName);
                                out.print(profile.lastName);
                                out.print(profile.id);*/
                                session.setAttribute("user_id", id);
                                request.setAttribute("profilejsp_id", id);
                            %>
                            </div>
                        </div>
                        <div class="comment">
                            <div class="comment-inside">
                                <form class="comment" action="commentInsert" method="post">
                                <!--<textarea class="comment-input" type="text" placeholder="Your comment...">
                                --> 
                                    <textarea wrap="hard" name="comment" class="comment-textarea" placeholder="Your comment..."></textarea>
                                    <input class="submit" type="submit" value="Comment">
                                </form>
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

