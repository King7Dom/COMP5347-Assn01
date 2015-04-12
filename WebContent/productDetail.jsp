<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>${product.name}</title>
	<link rel="stylesheet" type="text/css" href="css/style.css" media="screen" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" media="screen" />
	<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css" media="screen" />
</head>

<body>
	<div class="container">
		<div class="page-header text-center">
			<h1>${product.name}</h1>
		</div>
		<div class="img-hero-wrapper img-rounded">
			<img class=" img-hero" src="${product.imageURL}"
				alt="${product.name} image">
		</div>
		<div class="row">
			<div class="col-sm-12 col-md-4">
				<div class="panel panel-default">
					<!-- Panel Heading -->
					<div class="panel-heading">Details</div>
					<!-- List group -->
					<ul class="list-group">
						<li class="list-group-item">Price: $${product.price}</li>
					</ul>
				</div>
			</div>
			<div class="col-sm-12 col-md-4 text-center">
				<h3>Product Rating</h3>
				<h3>${product.averageRating}</h3>
				<c:forEach begin="1" end="5" varStatus="loop">
					<c:choose>
						<c:when test="${product.averageRating >= loop.count}">
							<i class="fa fa-star"></i>
						</c:when>
						<c:when test="${product.averageRating > (loop.index - 1)}">
							<i class="fa fa-star-half-o"></i>
						</c:when>
						<c:otherwise>
							<i class="fa fa-star-o"></i>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<h4>
					<i class="fa fa-fw fa-user"></i><small>${product.numberOfRatings} total</small>
				</h4>
			</div>
		</div>
	</div>
</body>
</html>