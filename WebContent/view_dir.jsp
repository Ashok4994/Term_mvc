<%-- 
    Document   : view_dir
    Created on : May 4, 2017, 12:56:30 AM
    Author     : ashok
--%>

<%@page import="com.model.Employee"%>
<%@page import="com.model.DirectoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <br>

         <%if (session.getAttribute("id") == null)
	{
		response.sendRedirect(request.getContextPath()+ "/index.jsp");
	}%>

        <jsp:include page="header.jsp" />
        <% ArrayList<DirectoryBean> subm_directories = (ArrayList<DirectoryBean>) request.getAttribute("sub_dir");
            ArrayList<DirectoryBean> own_directories = (ArrayList<DirectoryBean>) request.getAttribute("own_dir");
            ArrayList<DirectoryBean> supm_directories = (ArrayList<DirectoryBean>) request.getAttribute("supr_dir");
            ArrayList<DirectoryBean> ate_directories = (ArrayList<DirectoryBean>) request.getAttribute("ate_dir");
            String role = (String) session.getAttribute("role");
        %>

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

            <div class="row">
                <div class="col-sm-6">
                    <div class="panel panel-success">
                        <div class="panel-heading">Super Managers Directories</div>
                        <div class="panel-body">
                            <table class="table table-condensed">
                                <thead>
                                    <tr>
                                        <th>DirectoryID</th>
                                        <th>Directory Name</th> 
                                        <th>Permission</th>
                                        <th>View</th>
                                            <% if (role.equals("manager")) {%>
                                        <th>Restrict Permission</th> <%}%>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%for (int i = 0; i < supm_directories.size(); i++) {
                                            String perm = supm_directories.get(i).getPermission();
                                    %>
                                    <tr>
                                <form action="ViewFiles" method="POST">
                                    <td><%=supm_directories.get(i).getDirId()%></td>
                                    <td><%=supm_directories.get(i).getDname()%>   </td>
                                    <td><%=supm_directories.get(i).getPermission()%></td>
                                    <td><button type="submit" class="btn-info">
                                            <span class="glyphicon glyphicon-eye-open"></span>
                                        </button></td>
                                    <input type="hidden" name="dir_id" value="<%=supm_directories.get(i).getDirId()%>">
                                </form>     

                                <form method="post" action="ChangePerm">
                                    <% if (role.equals("manager")) {%>
                                    <%if (perm.equals("protected") || perm.equals("default")) {%>

                                    <td><button type="submit" class="btn btn-success">Restrict permission</button></td> <%}%>
                                    <%}%>
                                    <input type="hidden" name="dirid" value="<%=supm_directories.get(i).getDirId()%>">
                                </form>
                                </tr> 
                                <%}%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">

            <div class="row">
                <div class="col-sm-6">
                    <div class="panel panel-info">
                        <div class="panel-heading">Own Directories</div>
                        <div class="panel-body">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>DirectoryID</th>
                                        <th>Directory Name</th> 
                                        <th>Permission</th>
                                        <th>View</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%for (int j = 0; j < own_directories.size(); j++) {%>
                                    <tr>
                                <form action="ViewFiles" method="POST">
                                    <td><%=own_directories.get(j).getDirId()%></td>
                                    <td><%=own_directories.get(j).getDname()%>   </td>
                                    <td><%=own_directories.get(j).getPermission()%></td>
                                    <td><button type="submit" class="btn-info">
                                            <span class="glyphicon glyphicon-eye-open"></span>
                                        </button></td>
                                    <input type="hidden" name="dir_id" value="<%=own_directories.get(j).getDirId()%>">
                                </form> 
                                </tr> 
                                <%}%>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!--Super Managers Dir -->
        <div class="container">

            <div class="row">
                <div class="col-sm-8">
                    <div class="panel panel-danger">
                        <div class="panel-heading">Sub-Managers Directories</div>
                        <div class="panel-body">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>DirectoryID</th>
                                        <th>Directory Name</th> 
                                        <th>Permission</th>
                                        <th>Manager ID</th>
                                        <th>Hierarchy</th>
                                        <th>View</th>
                                        
                                    </tr>
                                </thead>
                                <tbody>
                                    <%for (int k = 0; k < subm_directories.size(); k++) {%>
                                    <tr>
                                <form action="ViewFiles" method="POST">
                                    <td><%=subm_directories.get(k).getDirId()%></td>
                                    <td><%=subm_directories.get(k).getDname()%>   </td>
                                    <td><%=subm_directories.get(k).getPermission()%></td>
                                    <td><%=subm_directories.get(k).getManagerId()%></td>
                                    <td><%=subm_directories.get(k).getHierarchy()%></td>
                                    <td><button type="submit" class="btn-danger">
                                            <span class="glyphicon glyphicon-eye-open"></span>
                                        </button>
                                    </td>
                                    <input type="hidden" name="dir_id" value="<%=subm_directories.get(k).getDirId()%>">
                                </form> 
                                </tr> 
                                <%}%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--ATE Directories-->
        <div class="container">

            <div class="row">
                <div class="col-sm-6">
                    <div class="panel panel-danger">
                        <div class="panel-heading">ATE Directories</div>
                        <div class="panel-body">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>DirectoryID</th>
                                        <th>Directory Name</th> 
                                        <th>Permission</th>
                                        <th>View</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%for (int k = 0; k < ate_directories.size(); k++) {%>
                                    <tr>
                                <form action="ViewFiles" method="POST">
                                    <td><%=ate_directories.get(k).getDirId()%></td>
                                    <td><%=ate_directories.get(k).getDname()%>   </td>
                                    <td><%=ate_directories.get(k).getPermission()%></td>
                                    <td><button type="submit" class="btn-danger">
                                            <span class="glyphicon glyphicon-eye-open"></span>
                                        </button>
                                    </td>
                                    <input type="hidden" name="dir_id" value="<%=ate_directories.get(k).getDirId()%>">
                                </form> 
                                </tr> 
                                <%}%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
