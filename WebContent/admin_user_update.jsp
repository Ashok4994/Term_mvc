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
        <% ArrayList<Employee> active_emp_details = (ArrayList<Employee>) request.getAttribute("active_emplist");
            ArrayList<Employee> inactive_emp_details = (ArrayList<Employee>) request.getAttribute("inactive_emplist");
            ArrayList<Integer> manager_ids = (ArrayList<Integer>) request.getAttribute("manager_list");%>

        <br>
        <br>
        <br>


      


                <div class="container">

                    <div class="row">
                        <div class="col-sm-12">
                            <div class="panel panel-danger">
                                <div class="panel-heading">Inactive Employees</div>
                                <div class="panel-body">
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

                                            <%for (int i = 0; i < inactive_emp_details.size(); i++) {
                                                    String role = inactive_emp_details.get(i).getRole();
                                                    String status = inactive_emp_details.get(i).getStatus();
                                                    Integer mid = inactive_emp_details.get(i).getManagerId();
                                                    Integer team_id = inactive_emp_details.get(i).getTeamId();%>
                                            <tr> <th><%out.print(i + 1);%></th>
                                                <td><%=inactive_emp_details.get(i).getFirstname()%></td>
                                                <td><%=inactive_emp_details.get(i).getLastname()%></td>
                                                <td><%=inactive_emp_details.get(i).getUserId()%></td>
                                                <!--<td><%=inactive_emp_details.get(i).getRole()%></td>-->

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

<!-- <td><%=inactive_emp_details.get(i).getStatus()%></td> -->
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
                                             <!--  <td><%=inactive_emp_details.get(i).getManagerId()%></td> -->
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
                                                            <% if (mid == 0) {%>
                                                            <option>Not specified</option><%}%>
                                                            <option>72000</option>
                                                            <option>84000</option>
                                                            <option>96000</option>
                                                            <option>108000</option>
                                                        </select>
                                                    </div>	
                                                </td>

                                                <td>
                                                    <button type="submit" class="btn btn-danger">Update</button>
                                                </td>

                                        <input type="hidden" name="empid"
                                               value="<%=inactive_emp_details.get(i).getUserId()%>">

                                        </form>
                                        </tr> <%}%>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>



                <br>
                <br>
                <br>
                <br>





                <div class="container">

                    <div class="row">
                        <div class="col-sm-12">
                            <div class="panel panel-info">
                                <div class="panel-heading">Active Employees</div>
                                <div class="panel-body">
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

                                            <%for (int i = 0; i < active_emp_details.size(); i++) {
                                                    String role = active_emp_details.get(i).getRole();
                                                    String status = active_emp_details.get(i).getStatus();
                                                    Integer mid = active_emp_details.get(i).getManagerId();
                                                    Integer team_id = active_emp_details.get(i).getTeamId();%>
                                            <tr> <th  ><%out.print(i + 1);%></th>
                                                <td><%=active_emp_details.get(i).getFirstname()%></td>
                                                <td><%=active_emp_details.get(i).getLastname()%></td>
                                                <td><%=active_emp_details.get(i).getUserId()%></td>
                                                <!--<td><%=active_emp_details.get(i).getRole()%></td>-->

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

<!-- <td><%=active_emp_details.get(i).getStatus()%></td> -->
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
                                             <!--  <td><%=active_emp_details.get(i).getManagerId()%></td> -->
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
                                                            <% if (mid == 0) {%>
                                                            <option>Not specified</option><%}%>
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
                                               value="<%=active_emp_details.get(i).getUserId()%>">

                                        </form>
                                        </tr> <%}%>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
    </body>
</html>
