<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="resources/css/jquery.autocomplete.css" />
	<script type="text/javascript" 
			src="resources/js/jquery.min.js"></script>
	<script src="resources/js/jquery.autocomplete.js"></script>  
	<style>
		input {
			font-size: 120%;
		}
	</style>
</head>
<body>
	<h3>Country</h3>
	<input type="text" id="country" name="country"/>
	
	<script>
		$("#country").autocomplete("getdata.jsp");
	</script>
</body>
</html>