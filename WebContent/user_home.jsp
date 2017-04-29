<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title></title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
<!-- Normalize CSS -->
<link rel="stylesheet" href="css/normalize.css">

<!-- Main CSS -->
<link rel="stylesheet" href="css/main.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Animate CSS -->
<link rel="stylesheet" href="css/animate.min.css">

<!-- Font-awesome CSS-->
<link rel="stylesheet" href="css/font-awesome.min.css">

<!-- Switch Style CSS -->
<link rel="stylesheet" href="css/switch-style.css">

<!-- Page1 CSS -->
<link rel="stylesheet" href="css/page1.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="css/style.css">

<!-- Home page CSS -->
<link rel="stylesheet" href="css/admin.css">

<!-- People page styles CSS -->
<link rel="stylesheet" href="css/people.css">
</head>
<body background="http://localhost:8080/Sampletp/img/hdwallpaper.jpg">

	<link
		href="http://fontawesome.io/assets/font-awesome/css/font-awesome.css"
		rel="stylesheet" media="screen">
	<!-- Header Area Start Here -->
	<header>
	<div class="header2-area">
		<div class="header-bottom-area" id="sticker">
			<div class="container">
				<div class="row">
					<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
						<div class="logo-area">
							<span><h3>EMS</h3></span>
						</div>
					</div>
					<div class="col-lg-8 col-md-8 col-sm-8 col-xs-12">
						<div class="main-menu-area">
							<nav>
							<ul>
								<!--<li><a href="<%=request.getContextPath()%>/controller?actionCode=getItemsOfCart&page=home" class="col-xs-24">Home</a></li>-->
								<!--<li><a href="#" class="col-xs-24">About</a></li>-->
								<!--<li><a href="cafeterialdetail?action=viewtable" class="col-xs-24">Cafeteria Details</a></li>-->

								<!--<li><a href="Addfooditem.jsp" class="col-xs-24"> Menu Management</a></li>-->

								<li><a
									href="<%=request.getContextPath()%>/update_profile.jsp"
									class="col-xs-24">Update Profile</a></li>

								<li><a href="<%=request.getContextPath()%>/Logout"
									class="col-xs-24">Log-Out</a></li>

							</ul>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</header>
<br>
<br>

	
	<div class="container">
	<ul class="nav nav-tabs">
  <li role="presentation" class="active"><a href="#">Home</a></li>
  <li role="presentation"><a href="#">Profile</a></li>
  
  <li role="presentation" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      Leave <span class="caret"></span>
    </a>
    <ul class="dropdown-menu">
   <li role="presentation"><a href="leave_request.jsp">Request Leave</a></li>
  <li role="presentation"><a href="leave_status.jsp">Leave status</a></li>
   <li role="presentation"><a href="approve_leave.jsp">Approve Leave</a></li>
      </ul>
  </li>
  <li role="files" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      Files <span class="caret"></span>
    </a>
    <ul class="dropdown-menu">
   <li role="presentation"><a href="file_upload.jsp">Upload files</a></li>
  <li role="presentation"><a href="view_files.jsp">View Files</a></li>
  <li role="presentation"><a href="view_employees.jsp">View Employee Hierarchy</a></li>
      </ul>
  </li>
  <li role="presentation" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      Directory <span class="caret"></span>
    </a>
    <ul class="dropdown-menu">
   <li role="presentation"><a href="create_dir.jsp">Create New Directory</a></li>
  <li role="presentation"><a href="#">Change permissions</a></li>
  <li role="presentation"><a href="view_dir.jsp">View Directories</a></li>
      </ul>
  </li>
  
</ul>
</div>
	
	<br>
	
	<div class="container">
	<ul class="nav nav-list">
  <li class="nav-header">List header</li>
  <li class="active"><a href="#">Home</a></li>
  <li><a href="#">Profile</a></li>
  <li><a href="#">Directory</a></li>
</ul>
	
	</div>
<br>
<br>

<center>
<p>I'm a</p>
<b>
  <span1>
    web developer<br /> 
    css cowboy<br />
    self-facilitating media node<br />
    box inside a box<br />
    part of the problem
    </span1>
</b>

</center>	




	<!-- jquery-->
	<script src="js/jquery-2.2.4.min.js" type="text/javascript"></script>

	<!-- Plugins js -->
	<!--<script src="js/plugins.js" type="text/javascript"></script>-->

	<!-- Bootstrap js -->
	<script src="js/bootstrap.min.js" type="text/javascript"></script>

	<!-- WOW JS -->
	<script src="js/wow.min.js"></script>

	<!-- Meanmenu Js -->
	<script src="js/jquery.meanmenu.min.js" type="text/javascript"></script>

	<!-- Srollup js -->
	<script src="js/jquery.scrollUp.min.js" type="text/javascript"></script>

	<!-- Custom Js -->
	<script src="js/main.js" type="text/javascript"></script>

	<!-- people Js -->
	<script src="js/people.js" type="text/javascript"></script>

</body>
</html>