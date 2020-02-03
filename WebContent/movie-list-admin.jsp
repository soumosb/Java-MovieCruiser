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
			href="ShowMovieListAdmin">Movies</a>

	</header>
	<div class="page-title">Movies</div>
	<table class="movieList" cellspacing="15">
		<tr>
			<th class="nameitem">Title</th>
			<th class="boxOffice">Box Office</th>
			<th>Active</th>
			<th>Date of Launch</th>
			<th>Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${movieNameList}" var="movieName">
			<tr>
				<td class="nameitem">${movieName.title}</td>
				<td class="boxOffice"><fmt:setLocale value="en_US" /> <fmt:formatNumber
						value="${movieName.boxOffice}" type="currency"
						minFractionDigits="0" /></td>
				<c:if test="${movieName.active}">
					<td>Yes</td>
				</c:if>
				<c:if test="${!movieName.active}">
					<td>No</td>
				</c:if>
				<td><fmt:formatDate value="${ movieName.dateOfLaunch}"
						pattern="dd/MM/yyyy" /></td>
				<td>${movieName.genre}</td>
				<c:if test="${movieName.hasTeaser}">
					<td>Yes</td>
				</c:if>
				<c:if test="${!movieName.hasTeaser}">
					<td>No</td>
				</c:if>
				<td><a class="link-color"
					href="ShowEditMovie?id=${movieName.id}">Edit</a></td>
			</tr>
		</c:forEach>

	</table>
	<footer> Copyright &copy; 2019 </footer>
</body>

</html>