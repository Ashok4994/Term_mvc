<%-- 
    Document   : update_profile
    Created on : Apr 30, 2017, 4:38:37 PM
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
        <!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <!-- Custom CSS -->

        <link rel="stylesheet" href="css/style.css">

        <!-- Home page CSS -->
        <link rel="stylesheet" href="css/admin.css">

        <!-- People page styles CSS -->
        <link rel="stylesheet" href="css/people.css">
        <!-- Latest compiled and minified CSS -->
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

    </head>
    <body>
   <jsp:include page="header.jsp" />
        <% ArrayList<Employee> emp_details = (ArrayList<Employee>) session.getAttribute("emp_details");
            int i = 0;%>
        <div class="container">

            <div class="row">
                <div class="col-sm-10">
                    <div class="panel panel-success">
                        <div class="panel-heading">Update Profile</div>
                        <div class="panel-body">
                            <div class="wrapper">

                                <div class="single-menu-area">

                                    <link href="http://fontawesome.io/assets/font-awesome/css/font-awesome.css" rel="stylesheet" media="screen">

                                    <div class="container">
                                        <div class="row">
                                            <div class="col-md-10 ">
                                                <form class='form-horizontal' method='POST' action="UserUpdate">
                                                    <fieldset>
                                                        <!-- First Name-->
                                                        <div class="form-group">
                                                            <label class="col-md-4 control-label" for="name">First Name</label>
                                                            <div class="col-md-4">
                                                                <div class="input-group">
                                                                    <input id="name" name="fname" placeholder="" class="form-control" value="<%=emp_details.get(i).getFirstname()%>" type="text">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <!-- Last Name -->
                                                        <div class="form-group">
                                                            <label class="col-md-4 control-label" for="name">Last Name</label>
                                                            <div class="col-md-4">
                                                                <div class="input-group">
                                                                    <input id="name" name="lname" placeholder="" class="form-control" value="<%=emp_details.get(i).getLastname()%>" type="text">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <!-- Address -->
                                                        <div class="form-group">
                                                            <label class="col-md-4 control-label" for="name">Address</label>
                                                            <div class="col-md-4">
                                                                <div class="input-group">
                                                                    <input id="name" name="address" placeholder="" class="form-control" value="<%=emp_details.get(i).getAddress()%>" type="text">
                                                                </div>
                                                            </div>
                                                        </div>


                                                        <!-- Phone -->
                                                        <div class="form-group">
                                                            <label class="col-md-4 control-label" for="mobile_number">Mobile Number</label>
                                                            <div class="col-md-4">
                                                                <div class="input-group">
                                                                    <input id="mobile_number" name="mobile_number" placeholder="" class="form-control input-md" value="<%= emp_details.get(i).getPhone()%>" type="text">
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <!-- Email input-->
                                                        <div class="form-group">
                                                            <label class="col-md-4 control-label" for="email_id">Email ID</label>
                                                            <div class="col-md-4">
                                                                <div class="input-group">
                                                                    <input id="email-id" name="email_id" placeholder="" class="form-control input-md" value="<%=emp_details.get(i).getEmail()%>" type="text">
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <!-- Role input-->
                                                        <div class="form-group">
                                                            <label class="col-md-4 control-label" for="role">Role</label>
                                                            <div class="col-md-4">
                                                                <div class="input-group">
                                                                    <input id="role" name="role" placeholder="" class="form-control input-md" value="<%=emp_details.get(i).getRole()%>" type="text" readonly="true">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <!-- Status-->
                                                        <div class="form-group">
                                                            <label class="col-md-4 control-label" for="role">Status</label>
                                                            <div class="col-md-4">
                                                                <div class="input-group">
                                                                    <input id="role" name="status" placeholder="" class="form-control input-md" value="<%=emp_details.get(i).getStatus()%>" type="text" readonly="true"> 
                                                                </div>
                                                            </div>
                                                        </div>

                                                        <!-- Manager id-->
                                                        <div class="form-group">
                                                            <label class="col-md-4 control-label" for="role">Manager ID</label>
                                                            <div class="col-md-4">
                                                                <div class="input-group">
                                                                    <input id="role" name="mid" placeholder="" class="form-control input-md" value="<%=emp_details.get(i).getManagerId()%>" type="text" readonly="true">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <!-- Level id-->
                                                        <div class="form-group">
                                                            <label class="col-md-4 control-label" for="role">Level Id</label>
                                                            <div class="col-md-4">
                                                                <div class="input-group">
                                                                    <input id="levelid" name="levelid" placeholder="" class="form-control input-md" value="<%=emp_details.get(i).getLevelId()%>" type="text" readonly="true">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <!-- Team id-->
                                                        <div class="form-group">
                                                            <label class="col-md-4 control-label" for="role">Team Id</label>
                                                            <div class="col-md-4">
                                                                <div class="input-group">
                                                                    <input id="teamid" name="teamid" placeholder="" class="form-control input-md" value="<%=emp_details.get(i).getTeamId()%>" type="text" readonly="true">
                                                                </div>
                                                            </div>
                                                        </div>



                                                        <!-- Submit-->
                                                        <div class="form-group">
                                                            <label class="col-md-4 control-label"></label>
                                                            <div class="col-md-4">
                                                                <input type="submit" name="login" class="btn btn-success" value="Submit">
                                                                <input type="button" name="login" class="btn btn-danger" value="Clear">
                                                                <!--<a href="#" class="btn btn-success" data-original-title="" title=""><span class="glyphicon glyphicon-thumbs-up"></span> Submit</a>-->
                                                                <!--<a href="#" class="btn btn-danger" value="" data-original-title="" title=""><span class="glyphicon glyphicon-remove-sign"></span> Clear</a>-->

                                                            </div>
                                                        </div>

                                                    </fieldset>
                                                </form>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
