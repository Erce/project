<%-- 
    Document   : login
    Created on : Jun 26, 2015, 2:30:37 PM
    Author     : ulakbim
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="login.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <script type="text/javascript">
            function makeItPassword()
            {
               document.getElementById("form").innerHTML = "<input id=\"password\" name=\"password\" type=\"password\" value=""/>";
               document.getElementById("password").focus();
            }
         </script>
    </head>
    <body style="height: 800px;">
        <div class="navbar">
            <div class="menu">
                <ul class="menu-ul">
                    <li class="menu-li"><a href="login.jsp"><div class="menu-item"><h class="menu-item-h">MAIN PAGE</h></div></a></li>
                    <li class="menu-li"><a href="signup.jsp"><div class="menu-item"><h class="menu-item-h">SIGN UP</h></div></a></li>
                    <li class="menu-li"><a href="about.jsp"><div class="menu-item"><h class="menu-item-h">ABOUT</h></div></a></li>
                </ul>
            </div>
            <div class="search">
                <div class="search-bar">
                    <input type="text" placeholder="Search" name="search" id="search">
                    <!--<input type="submit" name="Submit" value="Search" id="submit" onclick="submit()">-->
                </div>
            </div>
        </div>
        <div class="mainPage" style="height: 800px; margin-bottom: 0px;">
            <div class="contents">
                <div class="content-form">
                    <div class="content-form-style">
                        <div class="inside-form" style="padding-top: 70px;">
                            <div class="left">
                                <div class="form" style="margin-bottom: 26px;">
                                    <a href="" id="facebook">
                                        <div class="inside-a-facebook">
                                            <p class="inside-a-p">Facebook</p>
                                        </div>
                                    </a>
                                </div>
                                <div class="form" style="margin-bottom: 26px;">
                                    <a href="" id="twitter">
                                        <div class="inside-a-twitter">
                                            <p class="inside-a-p">Twitter</p>
                                        </div>
                                    </a>
                                </div>
                                <div class="form" style="margin-bottom: 26px;">
                                    <a href="" id="google-plus">
                                        <div class="inside-a-google-plus">
                                            <p class="inside-a-p">Google Plus</p>
                                        </div>
                                    </a>
                                </div>
                            </div>
                            <div class="right">
                                <form method="post" action="login">
                                    <div class="form" style="margin-top: 0px;"><div class="about"><h style="color: rgb(255,205,7); font-size: 150%;">Erce Can</h></div></div>
                                    <div class="form" style="margin-top: 10px;"><div class="about"><h style="color: rgb(255,205,7); font-size: 150%;">Balcıoğlu</h></div></div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
