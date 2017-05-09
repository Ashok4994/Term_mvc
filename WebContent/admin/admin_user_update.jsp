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
        <link rel="stylesheet" href="../css/bootstrap.min.css">

        <!-- Custom CSS -->

        <link rel="stylesheet" href="../css/style.css">

        <!-- Home page CSS -->
        <link rel="stylesheet" href="../css/admin.css">

        <!-- People page styles CSS -->
        <link rel="stylesheet" href="../css/people.css">
    </head>
    <body>
        <% ArrayList<Employee> emp_details = (ArrayList<Employee>) session.getAttribute("emp_list");
            ArrayList<Integer> manager_ids = (ArrayList<Integer>) session.getAttribute("mng_list");%>
        <div class="container">

            <div id="user-list" class="row">
                <div class="widget widget-2 primary"> <!-- TYPE PANEL -->
                    <div class="widget-head"> <!-- HEAD PANEL -->
                        <h4 class="heading"><i class="fa fa-briefcase"></i>Registered Users</h4>
                    </div><!-- /HEAD PANEL -->

                    <div class="widget-body" id="widget-body2"> <!-- CONTENT PANEL -->
                        <legend>Registered Users</legend>



                        <table class='table table-striped'>
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>FirstName</th>
                                    <th>LastName</th>
                                    <th>Userid</th>
                                    <th>Role</th>
                                    <th>Status</th>
                                    <th>ManagerID</th>
                                    <th>Salary(per annum)</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>


                                <%for (int i = 0; i < emp_details.size(); i++) {
                                        String role = emp_details.get(i).getRole();
                                        String status = emp_details.get(i).getStatus();
                                        Integer mid = emp_details.get(i).getManagerId();
                                        Integer team_id = emp_details.get(i).getTeamId();%>
                                <tr> <th  ><%out.print(i + 1);%></th>
                                    <td><%=emp_details.get(i).getFirstname()%></td>
                                    <td><%=emp_details.get(i).getLastname()%></td>
                                    <td><%=emp_details.get(i).getUserId()%></td>
                                    <!--<td><%=emp_details.get(i).getRole()%></td>-->

                                    <td> 
                                        <!--Role-->
                                        <form method="POST" action="AdminUpdate">
                                            <div class="form-group">

                                                <select id="disabledSelect" class="form-control" name="role">
                                                    <%if (role.equals("manager")) {%>
                                                    <option>manager</option>
                                                    <option>employee</option><%} else {%>
                                                   
                                                    <option>manager</option>
                                                     <option selected>employee</option>
                                                    <%}%>
                                                </select>
                                            </div>	
                                    </td>

<!-- <td><%=emp_details.get(i).getStatus()%></td> -->
                                    <td>
                                        <!--Status-->

                                        <div class="form-group">

                                            <select id="disabledSelect" class="form-control" name="stat">
                                                <%if (status.equals("active")) {%>
                                                <option>active</option>
                                                <option>inactive</option><%} else {%>
                                                <option>inactive</option>
                                                <option>active</option>
                                                <%}%>
                                            </select>
                                        </div>	

                                    </td> 
                                 <!--  <td><%=emp_details.get(i).getManagerId()%></td> -->
                                    <td>
                                        <!--ManagerID-->

                                        <div class="form-group">

                                            <select id="disabledSelect" class="form-control" name="mid">
                                                <% if (status.equals("inactive") && mid == 0) {%>
                                                <option>Not Assigned</option> <%} %>
                                                <%for (int j = 0; j < manager_ids.size(); j++) {%>
                                                <option><%=manager_ids.get(j)%></option>
                                                <% }%>
                                            </select>
                                        </div>	
                                    </td> 
                                    <td>
                                        <div class="form-group">

                                            <select id="disabledSelect" class="form-control" name="sal">
                                                <% if (mid == 0){%>
                                                <option>Not specified</option><%} %>
                                                <option>72000</option>
                                                <option>84000</option>
                                                <option>96000</option>
                                                <option>108000</option>
                                            </select>
                                        </div>	
                                    </td>
  
                                    <td>
                                        <button type="submit" class="btn btn-info">Update</button>
                                    </td>

                            <input type="hidden" name="empid"
                                   value="<%=emp_details.get(i).getUserId()%>">

                            </form>
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
