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
    
   
    
    

</head>




<script type="text/javascript">
	$(document).ready(
			function() {

				$('#btnSubmit').click(
						function(e) {
							console.log("button clicked");
							var frm = $('#submitForm');
							e.preventDefault();

							var courseId = $('#course').val();

							var instituteId = $('#institute').val();

							localStorage.setItem("courseId", courseId);
							localStorage.setItem("instituteId", instituteId);

							window.location = 'register'
							
						});
				
				$('#institute').change(function () { 
					
					alert("onChange");
			        var inst = $(this).children("option:selected").val();
			        
			        localStorage.setItem("instituteId", JSON.stringify(inst));
			        
			    	var myString="";
			    	myString = myString + "<option value='-1'  selected='default'>Select Course</option>"
			    				+ "<option value='18'  id='18' >M.tech. CSE</option>"
								+ "<option value='19'  id='19' >M.tech. ECE</option>";
			    	
			    	if(inst==1){
			    		
			    		myString = myString + "<option value='20'  id='20' >IM.tech. CSE</option>"
			    					+"<option value='21'  id='21' >IM.tech. ECE</option>";
			    	}
			    
			    	    $('#course').html(myString);
			    	    
			    	});
				
				$('#course').change(function () { 
					alert("onChangeCourse");
					var crs = $(this).children("option:selected").val();
			        
					localStorage.setItem("courseId", JSON.stringify(crs));
			        
				});
					
			   
		  });

			
		/* function changeCourse(value){
			alert("changeCourse");
			var inst = $(this).children("option:selected").val();
	    	var myString="";
	    	myString = myString + "<option value='-1'>Sub Category -Default</option>"
	    				+ "<option value='18'  id='18' >M.tech. CSE</option>"
						+ "<option value='19'  id='19' >M.tech. ECE</option>";
	    	
	    	if(inst==1){
	    		
	    		myString = myString + "<option value='20'  id='20' >IM.tech. CSE</option>"
	    					+"<option value='21'  id='21' >IM.tech. ECE</option>";
	    	}
	    
	    	$('#course').html(myString);
			
		} */
</script>


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
                        <form role="form" action="register" >
                        	<div  style="width:100%">
								Institute:
							    <div class="form-group input-group" style="margin-bottom:10px">
							    	
							    	<div class="input-group-prepend">
									    <span class="input-group-text"> <i class="fa fa-building"></i> </span>
									</div>
									<select id="institute" name="institute" class="form-control" >
										<option selected="default" value="-1"> Select Institute</option>
										<option  value="1" id="1"> International Institute of Information Technology, Bangalore </option>
										<option value="2" id="2">Indian Institute of Technology, Bombay</option>
										<option value="3" id="3">Indian Institute of Technology, Madras</option>
										<option value="4" id="4">Indian Institute of Technology, Delhi</option>
									</select>
								</div> <!-- form-group end.// -->
								
								Course:
								<div class="form-group input-group" style="margin-bottom:10px">
							    	<div class="input-group-prepend">
									    <span class="input-group-text"> <i class="fa fa-building"></i> </span>
									</div>
									<select id="course" name="course" class="form-control">	
							   			 <option value="-1"  selected="default">Select Course</option>
							   			 <option value="18"  id="18" >Mtech</option>
							   			 <option value="19"  >iMtech</option>
									</select>
								</div>								
							</div>
							<button type="submit"    class="btn btn-lg btn-success btn-block" id="btnSubmit">NEXT</button>
							
                       
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