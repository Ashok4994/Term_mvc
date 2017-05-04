<%-- 
    Document   : view_files
    Created on : May 4, 2017, 2:09:21 AM
    Author     : ashok
--%>

<%@page import="com.model.FileBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


        <title>JSP Page</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </head>
    <body>
        <br>
        <br>
        <br>
        <% ArrayList<FileBean> flist = (ArrayList<FileBean>) request.getAttribute("file_list"); %>
        <div class="container">
            <div class="row">
              
                    <div class="panel panel-info">
                        <div class="panel-heading">Files</div>
                        <div class="panel-body">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>FileID</th>
                                        <th>File</th> 
                                        <th>Type</th>
                                        <th>Description</th>
                                        <th>User ID</th>
                                        <th>View</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%for (int j = 0; j < flist.size(); j++) {%>
                                    <tr>
                                <form method="POST" action="Displayf" target="_blank">
                                        <td><%=flist.get(j).getFiled()%></td>
                                        <td><%=flist.get(j).getFiles()%></td>
                                        <td><%=flist.get(j).getType() %></td>
                                        <td><%=flist.get(j).getTitle()%></td>
                                        <td><%=flist.get(j).getUId() %> </td>
                                        <td><button type="submit">
                                                <span class="glyphicon glyphicon-eye-open"></span>
                                            </button></td>
                                            <input type="hidden" name="file_id" value="<%=flist.get(j).getFiled()%>">
                                               
                                </form>
                                    </tr> 
                                    <%}%>
                                </tbody>
                            </table>

                        </div>
                    </div>
               
            </div>
        </div>



    </body>
</html>
