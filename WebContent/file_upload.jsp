<%@page import="com.model.DirectoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
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


        <div class="container">
            <div class="row">
                <div class="col-sm-6" class="pull-right">
                    <div class="panel panel-primary" col-xs-8>
                        <div class="panel-heading">Upload File</div>
                        <div class="panel-body">

                            <form method="post" action="Upload" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Description</label>
                                    <input type="text" class="form-control" id="exampleInputEmail1" name="title" placeholder="Enter Description" size="50">
                                </div>

                                <div class="form-group">
                                    <label for="exampleInputFile">File input</label>
                                    <input type="file" id="exampleInputFile" name="file_uploaded">

                                </div>

                                <% ArrayList<DirectoryBean> own_dlist = (ArrayList<DirectoryBean>) request.getAttribute("ownDirectoryList");
                                    ArrayList<DirectoryBean> managers_dlist = (ArrayList<DirectoryBean>) request.getAttribute("managers_dlist");
                                %>

                                <div class="form-group">
                                    <label for="exampleInputFile"> Select Directory</label>
                                    <select id="disabledSelect" class="form-control" name="dir">
                                        <% if (!own_dlist.isEmpty()) {%>
                                        <optgroup label="Own Directories">

                                            <%for (int i = 0; i < own_dlist.size(); i++) {%>
                                            <option><%=own_dlist.get(i).getDirId()%></option>
                                            <%}
                                                }%>
                                        </optgroup>
                                        <optgroup label="Managers Directories">
                                            <%for (int i = 0; i < managers_dlist.size(); i++) {%>
                                            <option><%=managers_dlist.get(i).getDirId()%></option>
                                            <%}%>   

                                        </optgroup>

                                    </select>

                                </div>
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

