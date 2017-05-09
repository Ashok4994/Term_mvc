<%-- 
    Document   : header.jsp
    Created on : May 5, 2017, 12:05:12 AM
    Author     : ashok
--%>

<%@page import="com.model.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
              crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet"
              href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
              integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
              crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
        <!-- Normalize CSS -->
        <link rel="stylesheet" href="css/normalize.css">

        <!-- Main CSS -->
        <link rel="stylesheet" href="css/main.css">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <!-- Animate CSS -->
        <link rel="stylesheet" href="css/animate.min.css">

        <!-- Font-awesome CSS-->
        <link rel="stylesheet" href="css/font-awesome.min.css">

        <!-- Switch Style CSS -->
        <link rel="stylesheet" href="css/switch-style.css">

        <!-- Page1 CSS -->
        <link rel="stylesheet" href="css/page1.css">

        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/style.css">

        <!-- Home page CSS -->
        <link rel="stylesheet" href="css/admin.css">

        <!-- People page styles CSS -->
        <link rel="stylesheet" href="css/people.css">

    </head>
    <body>
        <link
            href="http://fontawesome.io/assets/font-awesome/css/font-awesome.css"
            rel="stylesheet" media="screen">

        <% ArrayList<Employee> emp_details = (ArrayList<Employee>) session.getAttribute("emp_details");
            int i = 0;%>
        <div class="row">
            <div class="col-sm-12">

                <nav  class="navbar navbar-inverse" role="navigation" >
                    <div class="container-fluid">
                        <!-- Brand and toggle get grouped for better mobile display -->

                        <ul class="nav navbar-nav navbar-left">
                            <li><a href="user_home.jsp"><span class="glyphicon glyphicon-sunglasses" aria-hidden="true"></span></a> </li>
                            <li><a href="#">Hello <%=emp_details.get(i).getFirstname()%></a></li>
                            <li><a href="#">Hierarchy: <%=emp_details.get(i).getHierarchy()%></a></li>
                        </ul>


                        <ul class="nav navbar-nav navbar-right">
                            <li><ul class="dropdown">

                                </ul></li>
                            <li><a href="#">Profile</a></li>
                            <li><a href="<%=request.getContextPath()%>/Logout">Logout</a></li>
                        </ul>
                        </ul>


                    </div><!-- /.container-fluid -->
                </nav>
            </div>
        </div>
    </body>
</html>
