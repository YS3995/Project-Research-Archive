<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Project Management</title>


<link rel="stylesheet" href="../bootstrap-4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="fonts/fontawesome/css/fontawesome-all.min.css">

<script src="../ajax/libs/jquery-3.3.1/jquery.min.js"></script>
<script src="../ajax/libs/popper-1.14.7/umd/popper.min.js"></script>
<script src="../bootstrap-4.3.1/js/bootstrap.min.js"></script>


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


<script type="text/javascript">
	$(document).ready(
			function() {

				$('#login').click(
						function(e) {
							console.log("button clicked");
							var frm = $('#submitForm');
							e.preventDefault();

							var r = $('#roll').val();

							var p = $('#pass').val();

							var us = JSON.stringify({
								"rollNo" : r,
								"password" : p

							})
							console.log("IpData :: " + us);
							//localStorage.setItem("rollNo", r);
							
							var api1 = "http://localhost:8085/getUserById/"+r;
                                alert("testing");
							$.get(api1 , function(data, status){
								//alert(data.rollNo);
								
								localStorage.setItem("userdata", JSON.stringify(data));
                           var te=JSON.parse(localStorage.getItem("userdata",data));
								alert(te.rollNo);
								});
							
							
							$.ajax({
								type : 'POST',
								contentType : 'application/json',
								url : "http://localhost:8085/loginCheck",
								data : us, //JSON.stringify(data),
								dataType : "json",
								success : function(callback) {
									

										alert("Response: Name : "
												+ callback.name
												+ " login sucessful");
										//$(this).html("Success!");
										//localStorage.setItem("courseId", callback.courseId);
										//localStorage.setItem("institute_id", callback.instituteId);
										window.location = 'home'
									
								},
								error : function() {
									alert("error Try Again")
									window.location = 'login'
									//$(this).html("Error!");
								}
							});
						});
			});
</script>




</head>

<body>
	<%@include file="header1.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4"></div>
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default text-center"
					style="margin-top: 60px">
					<div class="panel-heading">
						<h3 class="panel-title">Please Sign In</h3>
					</div>
					<div class="panel-body">
						<form method="get" modelAttribute="userForm" id="submitForm">

							<div class="form-group">
								<input class="form-control" placeholder="Roll No." name="roll"
									id="roll" type="text" autofocus>
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Password" name="pass"
									id="pass" type="password" value="">
							</div>
							<div class="checkbox">
								<label> <input name="remember" type="checkbox"
									value="Remember Me">Remember Me
								</label>
							</div>
							<!-- Change this to a button or input when using this as a form -->
							<!-- <a href="home" class="btn btn-lg btn-success btn-block">Login</a> -->
							<button class="btn btn-warning btn-block" type="submit"
								id="login">Login</button>

							<a class="nav-link" href="institute">Create new account</a>
						</form>
					</div>
				</div>


			</div>
		</div>
	</div>

	<!-- jQuery -->

	<!-- Custom Theme JavaScript -->

<%@include file="footer.jsp" %>
</body>

</html>
