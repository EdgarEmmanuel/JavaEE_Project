<%@page import="metier.entities.Produit"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="taglib" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<title>PRODUIT | PAGE</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container" style="border:1px solid skyblue;padding:0;margin-top:20px;">
		<h1 class="bg-primary" style="color:white;font-weight:bold;text-align:center;">LISTE DES PRODUITS</h1>
		<form method="post" action="index.php" class="form form-inline" style="text-align:center;margin-top:20px;">
		<label style="font-weight:bold;">Mot-Cle</label>
		<input type="text" name="cle" class="form-control" style="width:300px;margin:0px 10px;" placeholder="mot-cle" />
		<button type="submit" class="btn btn-primary">SEARCH</button>
		</form>
		<!-- table part -->
<table class="table" style="margin-top:30px;">
  <thead class="thead-primary bg-primary">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Description</th>
      <th scope="col">Prix</th>
      <th scope="col">Quantite</th>
    </tr>
  </thead>
  <tbody>
  <taglib:forEach items="${model.listProds}" var="produit">
  	<tr>
      <th scope="row"><taglib:out value="${produit.id}"/></th>
      <td><taglib:out value="${produit.designation}"/></td>
      <td><taglib:out value="${produit.prix}"/></td>
      <td><taglib:out value="${produit.quantite}"/></td>
      <td><a href="modifier.php?id=${produit.id}" class="btn btn-primary">EDIT</a> 
      <a href="supprimer.php?id=${produit.id}" class="btn btn-danger">DELETE</a></td>
    </tr>
  </taglib:forEach>
  </tbody>
</table>
	
	</div>
	
	
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>
</html>