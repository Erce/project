<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Sign Up</title>
        <link href="signUp.css" rel="stylesheet" type="text/css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="menu">
            <ul class="menu-ul">
                <li class="menu-li"><a href="index.html"><div class="menu-item"><h class="menu-item-h">MAIN PAGE</h></div></a></li>
                <li class="menu-li"><a href="login.jsp"><div class="menu-item"><h class="menu-item-h">LOGIN</h></div></a></li>
                <li class="menu-li"><a href="search.jsp"><div class="menu-item"><h class="menu-item-h">SEARCH</h></div></a></li>
                <li class="menu-li"><a href="signup.jsp"><div class="menu-item"><h class="menu-item-h">SIGN UP</h></div></a></li>
                <li class="menu-li"><a href="about.html"><div class="menu-item"><h class="menu-item-h">ABOUT</h></div></a></li>
            </ul>
        </div>
        <div class="mainPage">
            <div class="contents">
                <div class="contents-form">
                    <form method="post" action="signUp">
                        <div class="inside-form">
                            <div class="form"><h class="form-h">First Name: </h><input type="text" name="firstName"></div>
                            <div class="form"><h class="form-h">Last Name: </h><input type="text" name="lastName"></div>
                            <div class="form"><h class="form-h">E-mail: </h><input type="text" name="email"></div>
                            <div class="form" style="float:left; margin-left:21px; margin-right: 0px;"><h class="form-h">Date of Birth: </h></div>
                            <div class="form-date"><select name="day"><option class="option-day" value="">Day</option><%
                            int i=1;
                            for(;i<=30;i++) { out.print("<option class='option-day' value='"+i+"'>"+i+"</option>");}
                            %></select></div>
                            <div class="form-date"><select name="month"><option class="option-month" value="">Month</option><%
                            i=1;for(;i<=12;i++) { out.print("<option class='option-month' value='"+i+"'>"+i+"</option>");}
                            %></select></div>
                            <div class="form-date"><select name="year"><option class="option-year" value="">Year</option><%
                            i=2000;for(;1920<=i;i--) { out.print("<option class='option-year' value='"+i+"'>"+i+"</option>");}
                            %></select></div><br>
                            <div class="form" style="float:left; margin-top: -5px; margin-left: 55px; display: table-cell;">
                                <h class="form-h">Gender: </h>
                                <select name="gender">
                                    <option class="gender" value="M">M</option>
                                    <option class="gender" value="F">F</option>
                                </select>
                            </div>
                            <div class="form"><h class="form-h">Password: </h><input type="password" name="password"></div>
                            <div class="form"><h class="form-h">Password Check: </h><input type="password" name="password"></div>
                            <div class="form"><input type="submit" id="submit"></div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
