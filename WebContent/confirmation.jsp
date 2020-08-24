<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="taglib" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> CONFIRMATION | PAGE </title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>

<div class="container" style="border:1px solid skyblue;padding:0;margin-top:20px;">
		<h1 class="bg-primary" style="color:white;font-weight:bold;text-align:center;">
			<taglib:out value="${message}" />
		</h1>
</div>


</body>
</html>