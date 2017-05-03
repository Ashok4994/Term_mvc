<%-- 
    Document   : employees
    Created on : May 1, 2017, 2:42:23 PM
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
        <% ArrayList<Employee> emp_details = (ArrayList<Employee>) session.getAttribute("emp_list");%>
        <div class="container">

            <div id="user-list" class="row">
                <div class="widget widget-gray"> <!-- TYPE PANEL -->
                    <div class="widget-head"> <!-- HEAD PANEL -->
                        <h4 class="heading"><i class="fa fa-briefcase"></i>Registered Users</h4>
                    </div><!-- /HEAD PANEL -->

                    <div class="widget-body" id="widget-body2"> <!-- CONTENT PANEL -->
                        <legend>Registered Users</legend>



                        <table class='table table-bordered'>"
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>FirstName</th>
                                    <th>LastName</th>
                                    <th>Address</th>
                                    <th>Phone</th>
                                    <th>Email-ID</th>
                                    <th>Userid</th>
                                    <th>Role</th>
                                    <th>Status</th>
                                    <th>ManagerID</th>
                                    <th>LevelID</th>
                                    <th>TeamID</th>

                                </tr>
                            </thead>
                            <tbody>


                                <%for (int i = 0; i < emp_details.size(); i++) {%>
                                <tr> <th  scope='row'><%out.print(i + 1);%></th>
                                    <td><%=emp_details.get(i).getFirstname()%></td>
                                    <td><%=emp_details.get(i).getLastname()%></td>
                                    <td><%=emp_details.get(i).getAddress()%></td>
                                    <td><%=emp_details.get(i).getPhone()%></td>
                                    <td><%=emp_details.get(i).getEmail()%></td>
                                    <td><%=emp_details.get(i).getUserId()%></td>
                                    <td><%=emp_details.get(i).getRole()%></td>
                                    <td><%=emp_details.get(i).getStatus()%></td>
                                    <td><%=emp_details.get(i).getManagerId()%></td>
                                    <td><%=emp_details.get(i).getLevelId() %></td>
                                    <td><%=emp_details.get(i).getTeamId()%></td>
                                   
                                </tr> <%}%>
                        </table>

                    </div><!-- /CONTENT PANEL -->

                    <div class="widget-footer"><!-- FOOTER PANEL--> 
                        <!--<a href="#" class="fa fa-minus-circle fa-1x" data-toggle="tooltip" data-placement="right" title="" data-original-title="FA-MINUS-CIRCLE"><i></i></a>-->
                        <!--<a href="#" class="fa fa-pencil fa-1x" data-toggle="tooltip" data-placement="right" title="" data-original-title="FA-PENCIL"><i></i></a>-->
                        <!--<a href="#" class="fa fa-search fa-1x" data-toggle="tooltip" data-placement="right" title="" data-original-title="FA-SEARCH"><i></i></a>-->
                        <!--<a href="#" class="fa fa-plus-circle fa-1x" data-toggle="tooltip" data-placement="right" title="" data-original-title="FA-PLUS-CIRCLE"><i></i></a>-->
                        <a href="#" id="toggle2" class="fa fa-chevron-up fa-1x" data-toggle="tooltip" data-placement="right" title="" data-original-title="FA-PLUS-CIRCLE"><i></i></a>
                    </div><!-- /FOOTER PANEL--> 

                </div> <!-- /TYPE PANEL -->
            </div>
        </div>
    </body>
</html>
