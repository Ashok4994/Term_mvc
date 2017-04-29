<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
<div class="container">
<div class="panel panel-danger">
 <div class="panel-heading">Create new Directory</div>
  <div class="panel-body">
 
<form method="post" action="CreatDirectory" method="POST">
  <div class="form-group">
  
    <label for="exampleInputEmail1">Directory Name</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="name"  size="50">
  </div>
  
  <br>
 
  <div class="form-group">
    <label for="exampleInputEmail1">Directory ID</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="id"  size="50">
  </div>
  
  <br>
  
  
  <div class="form-group">
      <label for="disabledSelect">Permission2</label>
      <select id="disabledSelect" class="form-control" name="perm">
        <option>public</option>
        <option>private</option>
        <option>protected</option>
        <option>default</option>
      </select>
    </div>
  

  
  <button type="submit" class="btn btn-danger">Submit</button>
</form>
</div>
</div>
</div>


</body>
</html>