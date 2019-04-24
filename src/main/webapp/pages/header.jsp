<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Project Management</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <link rel="stylesheet" href="../bootstrap-4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="fonts/fontawesome/css/fontawesome-all.min.css">  
  
  <script src="../ajax/libs/jquery-3.3.1/jquery.min.js"></script>
  <script src="../ajax/libs/popper-1.14.7/umd/popper.min.js"></script>
  <script src="../bootstrap-4.3.1/js/bootstrap.min.js"></script>
  
  <script type="text/javascript">
	$(document).ready(function() {
		//alert("asdf");
		var api;
		api = "http://localhost:8085/getAllProjectTopic";
		//alert("helldrgdgo");
		$.get( api, function(data, status) {
			// alert("hello");
			var myString = "";
			for (i = 0; i < data.length; i++) {
				myString = myString + "<a id='" + data[i].topicId 
				+ "' class='dropdown-item' href='http://localhost:8085/projectsByTopic' onclick='setPtopic(this.id);'>"
				+ data[i].topicName + "</a>";
			}
			
			
			$('#ptopic').html(myString + "");
			
		});
		
		var api1;
		api1 = "http://localhost:8085/getAllResearchTopic";
		//alert("helldrgdgo");
		$.get( api1, function(data1, status) {
			// alert("hello");
			var myString = "";
			for (i = 0; i < data1.length; i++) {
				myString = myString + "<a id='" + data1[i].topicId 
				+ "' class='dropdown-item' href='http://localhost:8085/researchesByTopic' onclick='setRtopic(this.id);'>"
				+ data1[i].topicName + "</a>";
			}
			
			
			$('#rtopic').html(myString + "");
			
		});
		
	});
	
	function setPtopic(id){
		localStorage.setItem("ptopicId", JSON.stringify(id));
	}
	
	function setRtopic(id){
		localStorage.setItem("rtopicId", JSON.stringify(id));
	}
		
				
	</script>
</head>
<body>

<div class="text-center" style="height:100px; background:#F4F3FF">
  <h1 class="text-bold" style="height:100%; vertical-align:middle">
  	<strong>Project Management</strong>
  </h1>
</div>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<div class="dropdown">
				<button type="button" class="btn color-white dropdown-toggle" data-toggle="dropdown" style="color:white">Select Project Topic</button>
				<div class="dropdown-menu"  id="ptopic">
				</div>
	</div>
	<div class="dropdown">
				<button type="button" class="btn color-white dropdown-toggle" data-toggle="dropdown" style="color:white">Select Research Topic</button>
				<div class="dropdown-menu"  id="rtopic">
				</div>
	</div>		
	<div class="col-sm-6"></div> 
	<div class="collapse navbar-collapse float-right" id="collapsibleNavbar" style="margin:10px 10px">
		<a class="nav-link" href="home" style="color:white">Home</a>
			
		<div class="dropdown">
			<button type="button" class="btn dropdown-toggle" data-toggle="dropdown" style="color:white">Add New</button>
			<div class="dropdown-menu">
				<a class="dropdown-item" href="addProject">Add Project</a>
				<a class="dropdown-item" href="addResearch">Add Research</a>
			</div>
		</div>
		 
		     
	</div>  
</nav>

<!-- 
<div class="container" style="margin-top:30px">
  <div class="row">
    <div class="col-sm-4">
      <h2>About Me</h2>
      <h5>Photo of me:</h5>
      <div class="fakeimg">Fake Image</div>
      <p>Some text about me in culpa qui officia deserunt mollit anim..</p>
      <h3>Some Links</h3>
      <p>Lorem ipsum dolor sit ame.</p>
      <ul class="nav nav-pills flex-column">
        <li class="nav-item">
          <a class="nav-link active" href="#">Active</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#">Disabled</a>
        </li>
      </ul>
      <hr class="d-sm-none">
    </div>
    <div class="col-sm-8">
      <h2>TITLE HEADING</h2>
      <h5>Title description, Dec 7, 2017</h5>
      <div class="fakeimg">Fake Image</div>
      <p>Some text..</p>
      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
      <br>
      <h2>TITLE HEADING</h2>
      <h5>Title description, Sep 2, 2017</h5>
      <div class="fakeimg">Fake Image</div>
      <p>Some text..</p>
      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
    </div>
  </div>
</div>

 -->  
<!--  
<div class="jumbotron text-center" style="margin-bottom:0">
  <p>Footer</p>
</div>
-->

</body>
</html>
    
