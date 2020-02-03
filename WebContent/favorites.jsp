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
			class="topnavlink-favorites" href="ShowCart">Favorites</a>
	</header>

	<div class="page-title">Favorites</div>
	<c:if test="${removeFavoriteStatus}">
		<p class="notification-message">Movie removed from Favorites
			successfully</p>
	</c:if>
	<table class="movieList" cellspacing="15">
		<tr>
			<th class="nameitem">Title</th>
			<th class="boxOffice">Box Office</th>
			<th>Genre</th>

		</tr>

		<c:forEach items="${movieNameList}" var="movieName">
			<tr>
				<td class="nameitem">${movieName.title}</td>

				<td class="price"><fmt:setLocale value="en_US" /> <fmt:formatNumber
						value="${movieName.boxOffice}" type="currency"
						minFractionDigits="0" /></td>

				<td>${movieName.genre}</td>
				<td><a href="RemoveFavorites?id=${movieName.id}">Delete</a></td>
			</tr>
		</c:forEach>

	</table>

	<p class="favorites-count">
		<b>No. of Favorites:</b>${setFavorites}</p>

	<footer> Copyright &copy; 2019 </footer>
</body>

</html>