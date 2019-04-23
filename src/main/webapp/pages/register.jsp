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

<link rel="shortcut icon" type="../image/x-icon"
	href="images/favicon.ico">

<!-- jQuery -->
<script src="../js/jquery-2.0.0.min.js" type="text/javascript"></script>

<!-- Bootstrap4 files-->
<script src="../js/bootstrap.bundle.min.js" type="text/javascript"></script>
<link href="../css/bootstrap.css" rel="stylesheet" type="text/css" />

<!-- Font awesome 5 -->
<link href="../fonts/fontawesome/css/fontawesome-all.min.css"
	type="text/css" rel="stylesheet">

<!-- plugin: owl carousel  -->
<link href="../plugins/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="../plugins/owlcarousel/assets/owl.theme.default.css"
	rel="stylesheet">

<script src="../plugins/owlcarousel/owl.carousel.min.js"></script>

<!-- custom style -->
<link href="../css/ui.css" rel="stylesheet" type="text/css" />
<link href="../css/responsive.css" rel="stylesheet"
	media="only screen and (max-width: 1200px)" />
<link href="../css/custom.css" rel="stylesheet" />

<!-- custom javascript -->
<script src="../js/script.js" type="text/javascript"></script>
<script src="../js/scripts/addProduct.js" type="text/javascript"></script>


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<script>
	
</script>

</head>

<body>
	<%@include file="header1.jsp"%>



	<div class="container" id="rform">
		<div class="row">
			<div class="col-md-4 col-md-offset-4"></div>
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default text-center"
					style="margin-top: 60px">
					<div class="panel-heading">
						<h3 class="panel-title">Please Fill All The Details</h3>
					</div>
					<div class="panel-body">
						<form method="post" modelAttribute="userForm" id="submitForm">


							<div class="form-group">
								<input class="form-control" placeholder="Roll No." name="rollNo"
									type="text" id="rollNo" autofocus>
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Name" name="name"
									type="text" id="name">
							</div>
							<div class="form-group">
								<input class="form-control" placeholder="Password" name="pass"
									type="password" id="pwd">
							</div>

							<!-- Change this to a button or input when using this as a form -->

							<!-- button type="submit" class="btn btn-lg btn-success btn-block"
								id="registerbutton" value="Register"/-->
								<button type="submit"  class="btn btn-lg btn-success btn-block" id="btnSubmit">Register</button>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>



<%@include file="footer.jsp" %>

</body>

<script type="text/javascript">
	$(document).ready(function() {

		$('#btnSubmit').click(function(e) {
			console.log("button clicked");
			var frm = $('#submitForm');
			e.preventDefault();

			
			var r = $('#rollNo').val();
			
			var n = $('#name').val();
			
			var p = $('#pwd').val();
			var us = JSON.stringify({
				"rollNo" : r,
				"name" : n,
				"password" : p

			})
			ins=localStorage.getItem("instituteId");
			cos=localStorage.getItem("courseId");
			alert("http://localhost:8085/addUser"+ins+""+cos);
			
			console.log("IpData :: "+us);
			$.ajax({
				type : frm.attr('method'),
				contentType:'application/json',
				url : "http://localhost:8085/addUser/"+ins+"/"+cos,
				data : us, //JSON.stringify(data),
				dataType:"json",
				success : function(callback) {
					alert("Response: Name: " + callback.name);
					//$(this).html("Success!");
					window.location='login'
					
				},
				error : function() {
					alert("error")
					//$(this).html("Error!");
				}
			});
		});
	});

	//jquery end
</script>



</html>
