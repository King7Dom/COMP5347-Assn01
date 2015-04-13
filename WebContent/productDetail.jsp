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
				<div class="row">
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
				<div class="row">
					<h3>Your Rating</h3>
					<c:choose>
						<c:when test="${sessionScope.userRating[product.name]}">
							<h3>${sessionScope.userRating[product.name]}</h3>
							<c:forEach begin="1" end="5" varStatus="loop">
								<c:choose>
									<c:when test="${sessionScope.userRating[product.name] >= loop.count}">
										<i class="fa fa-star"></i>
									</c:when>
									<c:when test="${sessionScope.userRating[product.name] > (loop.index - 1)}">
										<i class="fa fa-star-half-o"></i>
									</c:when>
									<c:otherwise>
										<i class="fa fa-star-o"></i>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<form method="POST" action="rateProduct">
								<div class="form-group">
									<c:forEach begin="1" end="5" varStatus="loop">
									<label class="radio-inline">
										<input type="radio" name="rating" value="${loop.count}" /> ${loop.count} <i class="fa fa-star"></i>
									</label>
									</c:forEach>
									<input type="hidden" name="productNum" value="${productNum}" />
								</div>
								<button type="submit" class="btn btn-primary btn-block">Rate</button>
							</form>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="col-sm-12 col-md-4">
				<div class="progress">
					<div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="${product.ratings[4] / product.numberOfRatings * 100}" aria-valuemin="0" aria-valuemax="100" style="width: ${product.ratings[4] / product.numberOfRatings * 100}%">
						<span>${product.ratings[3] / product.numberOfRatings * 100}%</span>
					</div>
				</div>
				<div class="progress">
					<div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="${product.ratings[3] / product.numberOfRatings * 100}" aria-valuemin="0" aria-valuemax="100" style="width: ${product.ratings[3] / product.numberOfRatings * 100}%">
						<span>${product.ratings[3] / product.numberOfRatings * 100}%</span>
					</div>
				</div>
				<div class="progress">
					<div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="${product.ratings[2] / product.numberOfRatings * 100}" aria-valuemin="0" aria-valuemax="100" style="width: ${product.ratings[2] / product.numberOfRatings * 100}%">
						<span>${product.ratings[2] / product.numberOfRatings * 100}%</span>
					</div>
				</div>
				<div class="progress">
					<div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="${(product.ratings[1] / product.numberOfRatings) * 100}" aria-valuemin="0" aria-valuemax="100" style="width: ${product.ratings[1] / product.numberOfRatings * 100}%">
						<span>${product.ratings[1] / product.numberOfRatings * 100}%</span>
					</div>
				</div>
				<div class="progress">
					<div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar" aria-valuenow="${product.ratings[0] / product.numberOfRatings * 100}" aria-valuemin="0" aria-valuemax="100" style="width: ${product.ratings[0] / product.numberOfRatings * 100}%">
						<span>${product.ratings[0] / product.numberOfRatings * 100}%</span>
					</div>
				</div>
			</div>
		</div>
		<footer class="footer">
			<p>&copy; Dominic Cheung 430549850</p>
		</footer>
	</div>
</body>
</html>