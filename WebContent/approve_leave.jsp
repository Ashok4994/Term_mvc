<%-- 
    Document   : approve_leave
    Created on : Apr 30, 2017, 2:01:48 AM
    Author     : ashok
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.model.LeaveBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <h2>Leave Requests</h2>
        <div class="container">
            <div class="panel panel-info">
                <div class="panel-heading">Approve Leave</div>
                <div class="panel-body">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Start Date</th>
                                <th>End Date</th>
                                <th>Reason</th>
                                <th>Employee ID</th>
                                <th>Status</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        <tbody>  
                            <% ArrayList<LeaveBean> approvalList = (ArrayList<LeaveBean>) session.getAttribute("approvalList");%>
                            <%for (int i = 0; i < approvalList.size(); i++) {%>
                            <tr>
                                <td><%=approvalList.get(i).getstartDate()%> </td>
                                <td><%=approvalList.get(i).getendDate()%> </td>    
                                <td><%=approvalList.get(i).getreason()%> </td> 
                                <td><%=approvalList.get(i).getuserid()%></td>

                                <td>
                                    <form method="POST" action="ApproveLeave">
                                        <div class="form-group">

                                            <select id="disabledSelect" class="form-control" name="perm">
                                                <option>pending</option>
                                                <option>approve</option>
                                                <option>decline</option>
                                            </select>
                                        </div>	

                                </td>
                                <td>
                                    <button type="submit" class="btn btn-info">Submit</button>
                                </td>
                            </tr>

                        <input type="hidden" name="empid"
                               value="<%=approvalList.get(i).getuserid()%>">
                        </form> 
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>



    </body>
</html>
