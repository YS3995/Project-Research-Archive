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
		var ptId = JSON.parse(localStorage.getItem("ptopicId"));
		
		var api = "http://localhost:8085/listProjectsByTopic/" + ptId;
		$.get(api,function(data, status) {
			var myString = "";
			// alert("hello");
			var api1 = "http://localhost:8085/getProjectTopicById/" + ptId;
			
			$.get(api1,function(data1, status) {
				
				myString = myString + "<h2><strong>"+data1.topicName+"</strong></h2><br><br>";
			
				
				for (i = 0; i < data.length; i++) {
					myString = myString + "<h4>"
								+ data[i].projectName
								+ "</h4><h5>Last updated on"
								+ data[i].date + "</h5><p>"
								+ data[i].description
								+ "</p><div class='col-sm-4'><button class='btn btn-lg btn-success btn-block' type='submit' id='btnSubmit'  onClick='searchPro("
								+ data[i].pId
								+ ");'>Read More</button></div><br>";
								
								
				}
				$('#projects').html(myString + "");
				
			});
			
			
		});
		
	});
	
	function searchPro(id) {
		localStorage.setItem("proSearch", id);
		window.location.href = "viewProject";
	}
</script>
</head>
<body>

	<%@include file="header.jsp"%>

	<div class="container" style="margin-top: 30px">
		<div class="row">
			<div class="col-sm-2" id="topicNme"></div>
			<div class="col-sm-8" id="projects"></div>
		</div>
	</div>

	<%@include file="footer.jsp"%>

</body>
</html>