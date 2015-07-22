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
        <script src="http://code.jquery.com/jquery.js"></script>
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

            $(document).on('click', '.submit', function () {
                var reply_id = $(this).attr('id');
                var reply = $('#reply'+reply_id).val();//isim alanına yazılan veriyi bir değişkene aldık
                //var id = $(this).attr('reply_id');
                $.ajax({// ajax işlemi başlar
                    type: 'POST', // veri gönderme tipimiz. get olabilirdi json olabilirdi. ama biz post kullanıyoruz
                    url: 'commentInsertReply', // post edilecek adres
                    data: {'reply': reply, 'reply_id': reply_id}, //post edilecek veriler
                    success: function (reply) {// işlem başarılıysa
                        $("<div class='comment-string' style='float: right;' id='myDiv'>" + reply + "</div><br>").appendTo('#reply-div-'+reply_id);
                        $(".ownprofile-comment-textarea").val('');
                    }
                });
            });
            
            $(document).ready(function() {
                $('.comment-string').click(function() {
                    var id = $(this).attr('id');
                //$('.comment-div').css("height","100px");
                    $("#reply-div-"+id).fadeToggle( "slow", "linear" );
                //$('.text-area').hide();
                });
            });
           
            /*        
            $('.outer-div-'+ $('#reply_id').val()).click(function() {
                $('.comment-div').css("height","");
                $('#myDiv-'+ $('#reply_id').val()).show();
                $('.text-area').show();
                }
            });*/

        </script>
        <section class="contents-section">
            <div class="navbar" id="asdqwe">
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
                                        int k = 1;
                                        int i = i_obj.hashCode();
                                        List arr = null;
                                        for (int j = 0; j < i; j++) {
                                            comments c = (comments) commArr.get(j);
                                            comments r;

                                            out.print("<div class='comment-div'>"
                                                    + "<div id='outer-div-"+c.getId()+"'>"
                                                    + "<input type='hidden' name='reply_id' id='reply_id' value='" + c.getId() + "'>"
                                                    + "<div class='comment-string' value='" + c.getId() + "' id='"
                                                    + c.getId() + "'>" + c.getComment() + "</div>");

                                            k = replyArr.size();
                                            r = null;
                                            out.print("<div class='reply-div' id='reply-div-"+c.getId()+"'>");
                                            for (int l = 0; l < k; l++) {
                                                r = (comments) replyArr.get(l);
                                                if (r.getWriter_id() == c.getId()) {
                                                    out.print("<div class='comment-string' style='float: right;' id='myDiv'>" + r.getComment() + "</div><br>");
                                                }
                                            }
                                            out.print("</div>");
                                            out.print("</div>" 
                                                    + "<div class='asd'>"
                                                    + "<textarea wrap='hard' class='ownprofile-comment-textarea' name='reply' id='reply"+c.getId()+"' placeholder='Your reply...'></textarea>"
                                                    + "<input class='submit' type='submit' id='"+c.getId()+"' value='Reply'>"
                                                    + "</div>"
                                                    + "</div>");
                                        }

                                    } catch (Exception e) {
                                        out.print(e);
                                    }
                                %>
                            </div>
                        </div>
                    </div>
                    <div class="second-row">
                        <div class="second-row-left" id="second-row-left"></div>
                        <div class="second-row-middle"></div>
                        <div class="second-row-right"></div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

