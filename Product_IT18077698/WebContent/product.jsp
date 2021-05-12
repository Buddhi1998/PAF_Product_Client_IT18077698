<%@page import="com.product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/product.js"></script>
<meta charset="ISO-8859-1">
<title>
 GadgetBadget
Product  Details
</title>
</head>
<body>
	<div class="container"><div class="row"><div class="col-6">
		<h1> GadgetBadget Product Details</h1>

			<form id="formproduct" name="formproduct">
			
				ID:
				<input id="id" name="id" type="text" class="form-control form-control-sm"><br>
		 		Name:
				<input id="name" name="name" type="text" class="form-control form-control-sm"><br> 
				Amount:
				<input id="amount" name="amount" type="text" class="form-control form-control-sm"><br>
		 		Description:
				<input id="des" name="des" type="text" class="form-control form-control-sm"><br>
				
				<br>
				<br>
      			<input id="btnCreateproduct" name="btnCreateproduct" type="button" value="Save" class="btn btn-primary">
      			<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
			</form>
	
			<div id="alertSuccess" class="alert alert-success"></div>
			<div id="alertError" class="alert alert-danger"></div>
			<br>
			<div id="divItemsGrid">
				<%
 product productObj = new product();
 out.print(productObj.readproduct());
 %>
			</div>
	</div> </div> </div> 

</body>
</html>