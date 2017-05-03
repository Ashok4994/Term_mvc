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
        <% ArrayList<Employee> mngr_emps = (ArrayList<Employee>) request.getAttribute("mngr_emps");
            %>

        <div class="container">
            <div class="panel panel-success">
                <div class="panel-heading">Assign Bonus</div>
                <div class="panel-body">
                     <table class='table table-striped'>
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>FirstName</th>
                                    <th>LastName</th>
                                    <th>Userid</th>
                                    <th>ManagerID</th>
                                    <th>LevelID</th>
                                    <th>TeamID</th>
                                    <th> Bonus</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>


                                <%for (int i = 0; i < mngr_emps.size(); i++) {%>
                                <tr> <th  ><%out.print(i + 1);%></th>
                                    <td><%=mngr_emps.get(i).getFirstname()%></td>
                                    <td><%=mngr_emps.get(i).getLastname()%></td>
                                    <td><%=mngr_emps.get(i).getUserId()%></td>
                                    
                                   <td><%=mngr_emps.get(i).getManagerId()%></td>
                                   
                                    
                                    <td><%=mngr_emps.get(i).getLevelId()%></td>
                                    <td><%=mngr_emps.get(i).getTeamId()%></td>
                                    <td>
                                        <form method="POST" action="ApproveBonus">
                                        <div class="form-group">

                                            <select id="disabledSelect" class="form-control" name="bonus">
                                                <option>5000</option>
                                                <option>10000</option>
                                                <option>15000</option>
                                            </select>
                                        </div>	

                                </td>
                                <td>
                                    <button type="submit" class="btn btn-success">Update</button>
                                </td>
                            </tr>

                        <input type="hidden" name="empid"
                               value="<%=mngr_emps.get(i).getUserId()%>">
                        </form> 
                                         
                                    </td>
                                    </form>
                                </tr> <%}%>
                        </table>
                   
                    </body>
                    </html>
