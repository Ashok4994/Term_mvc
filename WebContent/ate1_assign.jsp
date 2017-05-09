<%-- 
    Document   : ate1_assign
    Created on : May 7, 2017, 4:56:38 PM
    Author     : ashok
--%>

<%@page import="com.model.DirectoryBean"%>
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
        <br>
        <br>
        <br>

        <% ArrayList<Employee> oteam_emps = (ArrayList<Employee>) request.getAttribute("other_team_emp_list");
            ArrayList<DirectoryBean> subm_directories = (ArrayList<DirectoryBean>) request.getAttribute("sub_dir");
            ArrayList<DirectoryBean> own_directories = (ArrayList<DirectoryBean>) request.getAttribute("own_dir");
            ArrayList<DirectoryBean> supm_directories = (ArrayList<DirectoryBean>) request.getAttribute("supr_dir");%>

        <%if ((request.getAttribute("success") != null)) {%>
        <div class="alert alert-success">
            <strong><%=request.getAttribute("success")%>!</strong>
        </div>
        <%} %>
        <%if (request.getAttribute("failure") != null) {%>
        <div class="alert alert-danger">
            <strong><%=request.getAttribute("failure")%>!</strong>
        </div>
        <%}%>
        <div class="container">
            <div class="panel panel-success">
                <div class="panel-heading">ATE</div>
                <div class="panel-body">
                    <table class='table table-striped'>
                        <thead>
                            <tr>

                                <th>Another Team Employees</th>
                                <th>Directories</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    <form method="POST" action="ApproveATE">
                                        <div class="form-group">

                                            <select id="disabledSelect" class="form-control" name="uid">

                                                <%for (int i = 0; i < oteam_emps.size(); i++) {%>
                                                <option><%=oteam_emps.get(i).getUserId()%></option>

                                                <% }%>

                                            </select>
                                        </div>	

                                </td>
                                <td>
                                    <div class="form-group">

                                        <select id="disabledSelect" class="form-control" name="dir">
                                            <% if (!own_directories.isEmpty()) {%>
                                            <optgroup label="Own Directories">

                                                <%for (int i = 0; i < own_directories.size(); i++) {
                                                String r = own_directories.get(i).getPermission();
                                                 if (r.equals("protected")) {%>
                                                %>
                                                <option><%=own_directories.get(i).getDirId()%></option>
                                                <%}
                                                    }%>
                                            </optgroup>
                                            <optgroup label=" Super Managers Directories">
                                                <%for (int i = 0; i < supm_directories.size(); i++) {
                                                        String p = supm_directories.get(i).getPermission();
                                                        if (p.equals("protected")) {%>
                                                <option><%=supm_directories.get(i).getDirId()%></option>
                                                <%}
                                                    }%>   

                                            </optgroup>
                                            <optgroup label=" Sub Managers Directories">
                                                <%for (int i = 0; i < subm_directories.size(); i++) {
                                                        String q = subm_directories.get(i).getPermission();
                                                        if (q.equals("protected")) {%>%>
                                                <option><%=subm_directories.get(i).getDirId()%></option>
                                                <%}
                                                    }%>   
                                            </optgroup>
                                        </select>
                                    </div>
                                </td>
                                <td><button type="submit" class="btn btn-success">Give Access</button></td>
                                </form> 
                            </tr>

                        </tbody>
                    </table>

                    </body>
                    </html>
