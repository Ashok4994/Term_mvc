<%-- 
    Document   : payroll
    Created on : May 6, 2017, 1:02:59 PM
    Author     : ashok
--%>

<%@page import="com.model.SalaryBean"%>
<%@page import="java.util.ArrayList"%>
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
        <br>
        <br>
        <br>

        <%ArrayList<SalaryBean> sal_list = (ArrayList<SalaryBean>) request.getAttribute("salary_list"); %>
        <div class="container">

            <div class="row">
                <div class="col-sm-6">
                    <div class="panel panel-success">
                        <div class="panel-heading">Run Payroll</div>
                        <div class="panel-body">
                            <table class="table table-condensed">
                                <thead>
                                    <tr>
                                        <th>Employee ID</th>
                                        <th>Annual Salary</th>
                                        <th>Monthly Salary</th>
                                        <th>Bonus</th> 
                                        <th>Run Payroll</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <%for (SalaryBean s : sal_list) {
                                    %>
                                    <tr>
                                        <td><%=s.getuserid()%></td>
                                        <td><%=s.getAnnualSalary()%></td>
                                        <td><%=s.getMonthlySalary()%></td>

                                        <td><%=s.getBonus()%>
                                            <form method="POST" action="AdminRunPayroll">
                                                <td>  <button type="submit" class="btn btn-success">Run Payroll</button>  </td>

                                                <input type="hidden" name="empid" value="<%=s.getuserid()%>">
                                                 <input type="hidden" name="annual_salary" value="<%=s.getAnnualSalary()%>">
                                                  <input type="hidden" name="msalary" value="<%=s.getMonthlySalary()%>">
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
