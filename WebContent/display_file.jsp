<%-- 
    Document   : display_file
    Created on : May 4, 2017, 2:32:04 AM
    Author     : ashok
--%>

<%@page import="com.model.FileBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv
              ="Content-Type" content="text/html; charset=UTF-8">
        <title>View File</title>
    </head>
    <body>
        <% FileBean f = (FileBean) request.getAttribute("file_details");
            Blob file = null;
            byte[] fileData = null;
            String type = null;
            file = f.getFiles();
            type = f.getType();
            fileData = file.getBytes(1, (int) file.length());
            response.setContentType(type);
            response.setHeader("Content-Disposition", "inline");
            response.setContentLength(fileData.length);
            OutputStream output = response.getOutputStream();
            if (type == "video/mpeg" || type == "audio/mpeg") {
                System.out.print(type);%>
        <audio controls>
            <source src="${fileData}" type="video/mpeg">
            <source src="${fileData}" type="audio/mpeg">
            Your browser does not support the audio element.
        </audio>
       
            <%}else {
        output.write(fileData);
        output.flush();
        }
        %>

    </body>
</html>
