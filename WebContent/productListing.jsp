<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>COMP5347-ASSIGNMENT01</title>
	<link rel="stylesheet" type="text/css" href="css/style.css" media="screen" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" media="screen" />
</head>

<body>
<div class="container">
	<div class="page-header">
	  <h1>Overall Product List Page <small>COMP5347 Assignment 1</small></h1>
	</div>
	<h2>Catalog</h2>
	<c:forEach var="product" items="${applicationScope.productList}" varStatus="productVar">
	<c:if test="${productVar.index % 4 == 0}">${'<div class=\"row\">'}</c:if>
		<div class="col-xs-12 col-sm-6 col-md-3">
		    <a class="product-item" href="productDetail?product=${productVar.index}">
		    	<h3>${product.name}</h3>
		    	<img class="img-rounded img-responsive" src="${product.imageURL}" alt="${product.name} image">
		    	<p>Price: $${product.price}</p>
		    	<p>Average Rating: ${product.averageRating}</p>
		    	<p>Total Number of Ratings: ${product.numberOfRatings}</p>
			</a>
		</div>
	<c:if test="${productVar.index % 4 == 3 || productVar.last}">${'</div>'}</c:if>
	</c:forEach>
	
	<footer class="footer">
		<p>&copy; Dominic Cheung 430549850</p>
	</footer>
</div>
</body>

</html>