<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="../bootstrap-4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="fonts/fontawesome/css/fontawesome-all.min.css">

<script src="../ajax/libs/jquery-3.3.1/jquery.min.js"></script>
<script src="../ajax/libs/popper-1.14.7/umd/popper.min.js"></script>
<script src="../bootstrap-4.3.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(function () {
    $("#btnSubmit").click(function (event) {
        //stop submit the form, we will post it manually.
        event.preventDefault();
          alert("adsf");
        fire_ajax_submit();
    });
    
    
    
    var api2 = "";
    api2 = "http://localhost:8085/getAllProjectTopic";
	
	$.get( api2, function(data1, status) {
		
		var ptopics = "";
		ptopics = "<option selected='default'> Select Topic</option>";
		for (i = 0; i < data1.length; i++) {
			ptopics = ptopics + "<option  value='" 
						+ data1[i].topicId + "'>" + data1[i].topicName + "</option>";
		}
		$('#ptopic').html(ptopics);
	});
    
    
    
    
    
});
function fire_ajax_submit() {
    // Get form
    var form = $('#fileUploadForm')[0];
    $("#btnSubmit").prop("disabled", true);
    var data = new FormData(form);
    var user=JSON.parse(localStorage.getItem("userdata"));
     var pid=$('#ptopic').val();
      $("#btnSubmit").prop("disabled", true);
        alert("http://localhost:8085/addProject/"+user.rollNo+"/"+pid);
         $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "http://localhost:8085/addProject/"+user.rollNo+"/"+pid,
        data: data,
        //http://api.jquery.com/jQuery.ajax/
        //https://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
        	 alert("pass");
        	 $("#result").text(data);
        	 $("#btnSubmit").prop("disabled", false);
        },
        error: function (e) {
                alert("error");
                $("#result").text(e.responseText);
                $("#btnSubmit").prop("disabled", false);
        }
    });
}
</script>



<head>
<meta charset="UTF-8">
<title>Project Management</title>
</head>
<body>

<%@include file="header.jsp" %>

<div class="container">
        <div class="row">
        	<div class="col-md-3 col-md-offset-3"></div>
            <div class="col-md-6 col-md-offset-6">
                <div class="panel panel-default" style="margin-top:60px">
                    <div class="panel-heading">
                        <h3 class="panel-title">Enter Project Details</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form"  enctype="multipart/form-data" id="fileUploadForm">
                            <div  style="width:100%">
								<label>Project Topic</label> 
								<div class="form-group input-group" style="margin-bottom:10px">
									<div class="input-group-prepend">
									    <span class="input-group-atext"> <i class="fa fa-building"></i> </span>
									</div>
									<select id="ptopic" name="institute" class="form-control">
										<select id="ptopic" name="ptopic" class="form-control">
										<option selected='default' value='-1'> Select Topics</option>
										<option  value='1' id='1'>DevOps</option>
										<option  value='2' id='2'>MAchine Learning</option>
										<option  value='4' id='4'>Data modeling</option>
										<option  value='3' id='3'>web developement</option>
									</select>
									</select>
								</div>
								<label>Name of Project</label> 
								<div class="form-group input-group" style="margin-bottom:10px">
									<input type="text" class="form-control" name="pname" id="pname" placeholder="Project Name" required />
								</div>
								<label>Readme File</label> 
                                <div class="form-group input-group" style="margin-bottom:10px">
                                    <input type="file" class="form-control"  name="files">
                                </div>
                                <label>Upload Project File</label> 
                                <div class="form-group input-group" style="margin-bottom:10px">
                                    <input type="file" class="form-control"  name="files" >
                                </div>
                                <label>Description</label> 
                                <div class="form-group input-group" style="margin-bottom:10px">
                                    <textarea class="form-control" name="description" rows="5" id="description" placeholder="Description"></textarea>
									<br/>
                                </div>
                                <br/>
                                <!-- Change this to a button or input when using this as a form -->
                               <button class="btn btn-lg btn-success btn-block" type="submit"
								id="btnSubmit">Submit</button>
                                </div>
                                <br/>
                            	
                        </form>
                        
               <h2></h2>
                  <pre>
                  <span id="result"></span>
                  </pre>
                    </div>
                </div>
            </div>
        </div>
    </div>
<%@include file="footer.jsp" %>
</body>
</html>
