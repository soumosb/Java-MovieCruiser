<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="style/style.css">
<title>Movie Cruiser</title>
</head>

<body>
	<header>
		<header class="home">Movie Cruiser</header>
		<img src="images/logo.png"> <a class="topnavlink"
			href="ShowMovieListCustomer">Movies</a> <a
			class="topnavlink-favorites" href="ShowFavorites">Favorites</a>
	</header>

	<div class="page-title">Movies</div>
	<c:if test="${addFavoriteStatus}">
		<h3 class="notification-message">Movie added to Favorites
			Successfully</h3>
	</c:if>

	<table class="movieList" cellspacing="15">
		<tr>
			<th class="nameitem">Title</th>
			<th class="boxOffice">Box Office</th>
			<th>Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${movieNameList}" var="movieName">
			<tr>
				<td class="nameitem">${movieName.title}</td>
				<td class="price"><fmt:setLocale value="en_US" /> <fmt:formatNumber
						value="${movieName.boxOffice}" type="currency"
						minFractionDigits="0" /></td>
				<td>${movieName.genre}</td>
				<c:if test="${movieName.hasTeaser}">
					<td>Yes</td>
				</c:if>
				<c:if test="${!movieName.hasTeaser}">
					<td>No</td>
				</c:if>
				<td><a class="link-color"
					href="AddToFavorites?id=${movieName.id}">Add to Favorite</a></td>
			</tr>
		</c:forEach>

	</table>

	<footer> Copyright &copy; 2019 </footer>
</body>

</html>