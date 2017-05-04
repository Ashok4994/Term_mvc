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
        <style>  </style>

    </head>
    <body>
        <br>
        <br>
        <% ArrayList<Employee> emp_details = (ArrayList<Employee>) session.getAttribute("emp_details");
            int i = 0;%>

        <div class="container">
            <div class="row">
                <div class="col-sm-4">
                    <div class="panel panel-success">
                        <div class="panel-heading">Profile</div>
                        <div class="panel-body">
                            <table class="table table-striped ">
                                <tr><td>First Name:</td><td> <%=emp_details.get(i).getFirstname()%></td></tr>
                                <tr><td style="width:12%">Last Name</td><td><%=emp_details.get(i).getLastname()%></td></tr>
                                <tr><td>Address</td><td><%=emp_details.get(i).getAddress()%></td></tr>
                                <tr><td>Mobile Number</td><td><%= emp_details.get(i).getPhone()%></td></tr>
                                <tr><td>Email ID</td><td><%=emp_details.get(i).getEmail()%></td></tr>
                                <tr><td>Role</td><td><%=emp_details.get(i).getRole()%></td></tr>
                                <tr><td>Status</td><td><%=emp_details.get(i).getStatus()%></td></tr>
                                <tr><td>Manager ID</td><td><%=emp_details.get(i).getManagerId()%></td></tr>
                                <tr><td>Team ID </td><td><%=emp_details.get(i).getTeamId()%></td></tr>
                                <tr><td>Level ID</td><td><%=emp_details.get(i).getLevelId()%></td></tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
