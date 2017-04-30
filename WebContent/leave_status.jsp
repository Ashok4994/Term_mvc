<%-- 
    Document   : leave_status
    Created on : Apr 30, 2017, 1:00:17 AM
    Author     : ashok
--%>

<%@page import="com.model.LeaveBean"%>
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


        <div class="container">
            <div class="panel panel-warning">
                <div class="panel-heading">Leave Status </div>
                <div class="panel-body">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Start Date</th>
                                <th>End Date</th>
                                <th>Reason</th>
                                <th>Status</th>

                            </tr>
                        </thead>
                        <tbody>  
                            <% ArrayList<LeaveBean> leaveList = (ArrayList<LeaveBean>) session.getAttribute("leaveList");%>
                            <%for (int i = 0; i < leaveList.size(); i++) {%>
                            <tr>
                                <td><%=leaveList.get(i).getstartDate()%> </td>
                                <td><%=leaveList.get(i).getendDate()%> </td>    
                                <td><%=leaveList.get(i).getreason()%> </td>       
                                <td><%=leaveList.get(i).getstatus()%></td>
                            </tr>   
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>


    </body>
</html>
