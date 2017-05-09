<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/style.css">

        <!-- Home page CSS -->
        <link rel="stylesheet" href="css/admin.css">
    </head>
    <body>
        <br>
        <br>
        <br>
        <div class="container" >
            <div class="row">
                <div class="col-sm-12">

                    <nav  class="navbar navbar-inverse" role="navigation" >
                        <div class="container-fluid">
                            <!-- Brand and toggle get grouped for better mobile display -->

                            <ul class="nav navbar-nav navbar-left">
                                <li><a href="#">Hello Administrator</a></li>
                            </ul>


                            <ul class="nav navbar-nav navbar-right">
                                <li><ul class="dropdown">

                                    </ul></li>

                                <li><a href="<%=request.getContextPath()%>/Logout">Logout</a></li>
                            </ul>
                            </ul>
                        </div><!-- /.container-fluid -->
                    </nav>
                </div>
            </div>
        </div>
        <div class="wrapper">

            <!-- Include shopping cart -->


            <div class="single-menu-area">
                <div class="container">

                    <div class="container col-md-10">
                        <div class="header-text">
                            <span class="glyphicon glyphicon-user col-md-1" aria-hidden="true"></span>
                            <div class="title-div">Hello Administrator</div>
                        </div>
                        <div class="well">
                            <a href="<%=request.getContextPath()%>/AdminEmployees">List of Registered Employees</a><br> <hr>
                          
                            <!--<a href="admin_user_update.jsp">Change Users Roles and Managers</a><br>  <hr>-->
                            <a href="<%=request.getContextPath()%>/AdminController">Change Users Roles and Managers</a> <br><hr>
                          
                            <a href="<%=request.getContextPath()%>/AdminPayroll">Run Payroll</a><br>  

                        </div>

                        <!-- include messages.jsp -->

                    </div>
                </div>
            </div>
        </div>
        <

    </body>
</html>