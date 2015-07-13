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
        <!--<link href="../style.css" rel="stylesheet" type="text/css">-->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <div class="mainPage" style="">
            <div class="menu" style="margin-left: 130px; width: 100%; align:center;">
                <ul class="menu-ul" style="align:center; width:100%; display: inline-block;">
                    <li style="display: table-cell;"><div style="margin-left: 100px;"><a href="index.html">MAIN PAGE</a></div></li>
                    <li style="display: table-cell;"><div style="margin-left: 100px;"><a href="login.jsp">LOGIN</a></div></li>
                    <li style="display: table-cell;"><div style="margin-left: 100px;"><a href="search.jsp">SEARCH</a></div></li>
                    <li style="display: table-cell;"><div style="margin-left: 100px;"><a href="signup.html">SIGN UP</a></div></li>
                    <li style="display: table-cell;"><div style="margin-left: 100px;"><a href="about.html">ABOUT</a></div></li>
                </ul>
            </div>
            <div class="search-box" style="width: 300px;">
                <form method="get" action="search">
                    <input style="width: 250px;" type="text" name="names">
                    <input type="submit" name="submit">
                </form>
            </div>
            <div class="contents" style="width: 100%; background-color: black;">
                <div class="content-profile" style="margin-left: 35px; width: 300px; background-color: red; float:right;">
                    <div class="content-profile-style" style="width: 200px; padding:10px; float: right; display: table-row-group;">
                        <div class="names" style="width:150px; float: right; padding: 10px; align:right;"> 
                                
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

