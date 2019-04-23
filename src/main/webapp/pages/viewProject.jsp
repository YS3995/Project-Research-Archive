<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project Management</title>

<link rel="stylesheet" href="../bootstrap-4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="fonts/fontawesome/css/fontawesome-all.min.css">

<script src="../ajax/libs/jquery-3.3.1/jquery.min.js"></script>
<script src="../ajax/libs/popper-1.14.7/umd/popper.min.js"></script>
<script src="../bootstrap-4.3.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var pId = JSON.parse(localStorage.getItem("proSearch"));
		//alert(pId);
		var api = "http://localhost:8085/projectById/" + pId;
		$.get(api,function(data, status) {
			var myString = "";
			myString = myString
						+ "<h2>" + data.projectName
						+ "</h2><h5>Last updated on "
						+ data.date + "</h5><p>"
						+ data.description
						+ "</p><br><p>Readme File: </p><a href='http://localhost:8085/download/file/"
						+ data.readmeLocation
						+ "' data-fancybox=''><img src='images/pdfDownload.jpg' height='45' width='45'>"
						+ "</a><br><br><p>Project File: </p><a href='http://localhost:8085/download/file/"
						+ data.zipLocation 
						+ "' data-fancybox=''><img src='images/zipDownload.jpg' height='45' width='45'></a>";

			$('#projects').html(myString + "");
			
		});
		
		var user = JSON.parse(localStorage.getItem("userdata"));
		var api1;
		api1 = "http://localhost:8085/getUserById/" + user.rollNo;
		
		$.get(api1, function(data, status) {
			console.log("hello");
			var myString1 = "<h2>Roll No: " + data.rollNo
							+ "</h2><h5>Name: " + data.name
							+ "</h5><h5>Your Projects</h5>";
							
			var api2 = "http://localhost:8085/listAllProject/" + user.rollNo;
			
			$.get(api2, function(data1, status) {
				for (i = 0; i < data1.length; i++) {
					myString1 = myString1 + "<a href='#'>" + data1[i].projectName + "</a><br>";
					
				}
				
				var api3 = "http://localhost:8085/listAllResearch/" + user.rollNo;
				
				$.get(api3, function(data2, status) {
					
					myString1 = myString1 + "<br><h5>Your Researches</h5>";
					
					for (i = 0; i < data2.length; i++) {
						
						myString1 = myString1 + "<a href='#'>" + data2[i].researchName + "</a><br>";
						
					}
					$('#userDetail').html(myString1 + "");
					
				});
				
			});
			
		});
		
	});
</script>
</head>
<body>

	<%@include file="header.jsp"%>

	<div class="container" style="margin-top: 30px">
		<div class="row">
			<div class="col-sm-4" id="userDetail"></div>
			<div class="col-sm-8" id="projects"></div>
		</div>
	</div>

	<%@include file="footer.jsp"%>

</body>
</html>