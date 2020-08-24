<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> INSCRIPTION | PAGE </title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>

<div class="container" style="border:1px solid skyblue;padding:0;margin-top:20px;">
		<h1 class="bg-primary" style="color:white;font-weight:bold;text-align:center;">AJOUT PRODUIT</h1>
		
		<form method="post" action="addPro.php" class="form" style="margin:20px 0px 20px 20px;">
		
		<label style="font-weight:bold;">Designation</label>
		<input type="text" name="designation" class="form-control" style="text-align:center;width:300px;margin:0px 10px;" 
		placeholder="designation produit " />
		
		<label style="font-weight:bold;">Prix</label>
		<input type="text" name="prix" class="form-control" style="width:300px;margin:0px 10px;" 
		placeholder="prix produit " />
		
		<label style="font-weight:bold;">Quantite</label>
		<input type="text" name="quantite" class="form-control" style="width:300px;margin:0px 10px;"
		placeholder="quantite produit " />
		
		<button type="submit" class="btn btn-primary" style="margin-top:20px;">INSERT</button>
		
		</form>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>
</html>