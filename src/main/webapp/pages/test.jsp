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
	<script src="../js/jquery-1.11.0.min.js" type="text/javascript"></script>
	
    
    <link rel="shortcut icon" type="../image/x-icon" href="images/favicon.ico">

	<!-- jQuery -->
	<script src="../js/jquery-2.0.0.min.js" type="text/javascript"></script>
	
	<!-- Bootstrap4 files-->
	<script src="../js/bootstrap.bundle.min.js" type="text/javascript"></script>
	<link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
	
	<!-- Font awesome 5 -->
	<link href="../fonts/fontawesome/css/fontawesome-all.min.css" type="text/css" rel="stylesheet">
	
	<!-- plugin: owl carousel  -->
	<link href="../plugins/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
	<link href="../plugins/owlcarousel/assets/owl.theme.default.css" rel="stylesheet">
	
	<script src="../plugins/owlcarousel/owl.carousel.min.js"></script>
	
	<!-- custom style -->
	<link href="../css/ui.css" rel="stylesheet" type="text/css"/>
	<link href="../css/responsive.css" rel="stylesheet" media="only screen and (max-width: 1200px)" />
	<link href="../css/custom.css" rel="stylesheet"  />
	
	<!-- custom javascript -->
	<script src="../js/script.js" type="text/javascript"></script>

    
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <script>
    
    $(document).ready(function(){
    	console.log("here");

    	var api;
    	api = "http://localhost:8085/allInstitutes";


    	$.ajax(
        		{
        			type : 'GET',
        			contentType : 'application/json',
        			url : api,
        			dataType : "json", // data type of response
        			success : function(data) 		
{
    	   var myString="";
    	   myString = myString + "<option selected='default'> Select Institute</option>";
    			
    	    for(var i = 0; i < data.length; i++)
    		{
    	    	  myString=myString+"<option value = '"+ data[i].instituteId +"' >"+ data[i].instituteName +"</option>";
    		}
    	   
    	    alert(myString);
    	   $('#institute').html(myString);
},
error:function()
{
	alert("error occurred");
}
        		


    		});
    	
    	
    	
    	
    	 $('#institute').change(function () { 
    		
    		        var inst = $(this).children("option:selected").val();
    		    	api = "http://localhost:8085/ProjectManagement/webapi/InstituteController/allCourse/" + inst;


    		    	$.get(api , function(data, status){
    		    		console.log(data);
    		    	    var myString="";
    		    	    myString = myString + "<option value='-1'>Sub Category -Default</option>";
    		    			
    		    	    for(var i = 0; i < data.length; i++)
    		    		{
    		    	    	  myString=myString+"<option value = '"+ data[i].CourseId +"'>"+ data[i].CourseName +"</option>";
    		    		}
    		    	    $('#course').html(myString);
    		    	    
    		    	});
    		   
    	  });
    	
    	 	
    	
});
    
var coursesByinstitute = {
    	"IIITB": ["ML", "DS"]
     }
	
 
    
    


</script>

</head>

<body>
	<%@include file="header1.jsp" %>
	
    <div class="container">
        <div class="row">
        	<div class="col-md-3 col-md-offset-"></div>
            <div class="col-md-6 col-md-offset-6">
                <div class="login-panel panel panel-default text-center" style="margin-top:60px">
                    <div class="panel-heading">
                        <h2 class="panel-title"  style="margin-bottom:10px">Show where you conduct research</h2>
                        <h5  style="margin-bottom:10px">Enter your institution details to quickly find your colleagues and keep up with their research.</h5>
                    </div>
                    <div class="panel-body">
                        <form role="form" action="logincheck.jsp" >
                        	<div  style="width:100%">
								Institute:
							    <div class="form-group input-group" style="margin-bottom:10px">
							    	
							    	<div class="input-group-prepend">
									    <span class="input-group-text"> <i class="fa fa-building"></i> </span>
									</div>
									<select id="institute" name="institute" class="form-control" >
										<option selected="default" value="-1"> Select Institute</option>
										
									</select>
								</div> <!-- form-group end.// -->
								
								Course:
								<div class="form-group input-group" style="margin-bottom:10px">
							    	<div class="input-group-prepend">
									    <span class="input-group-text"> <i class="fa fa-building"></i> </span>
									</div>
									<select id="course" name="course" class="form-control">	
							   			 <option value="-1"  selected="default">Select Course</option>
									</select>
								</div>								
							</div>
							<a href="register.jsp" class="btn btn-lg btn-success btn-block" style="margin-top:30px">Continue</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="../vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>
<%@include file="footer.jsp" %>
</body>

</html>