<%-- 
    Document   : ate_assign
    Created on : May 6, 2017, 11:41:29 PM
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
    </head>
    <body>


        <% ArrayList<Employee> oteam_emps = (ArrayList<Employee>) request.getAttribute("other_team_emp_list"); %>
       

        <div class="container">
            <div class="panel panel-success">
                <div class="panel-heading">ATE</div>
                <div class="panel-body">
                    <table class='table table-striped'>
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>Another Team Employees</th>
                                <th>Directories</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>

                            <tr>
                        <td>  
                             <form method="POST" action="ApproveBonus">
                            <select id="disabledSelect" class="form-control" name="dir">

                                    <%for (int i = 0; i < oteam_emps.size(); i++) {%>
                                    <option><%=oteam_emps.get(i).getUserId()%></option>
                                    
                                               <% }%>
                              
                            </select>
                        </td> 
                        <td> </td>

                        <td>
                            <button type="submit" class="btn btn-success">Update</button>
                        </td>
                        </form> 
                        </tr>
                        <%}%>                                      
                         

                        </body>
                        </html>
