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
	<script src="js/script.js" type="text/javascript"></script>
	<header>
		<header class="home">Movie Cruiser</header>
		<img src="images/logo.png"> <a class="topnavlink"
			href="ShowMovieListAdmin">Movies</a>

	</header>

	<div class="page-title">Edit Movie</div>
	<form onsubmit='return fvalidate()' method="POST" action="EditMovie"
		name="editDetails">
		<table class="movieList" cellspacing="1">
			<tr>
				<th class="alignReq"><b><label for="moviename">Title</label></b>
				</td>
			</tr>
			<tr>
				<td><input type="hidden" name="id" value="${editMovie.id}">
					<input type="text" id="moviename" name="title" size="67"
					value="${editMovie.title}"></td>
			</tr>
		</table>
		<table class="movieEdit-customer" cellpadding="1" cellspacing="1">
			<br />
			<tr>
				<th class="alignReq"><label for="moviegross">Gross ($)</label>
				</th>
				<td>&nbsp;</td>
				<th class="alignReq">Active</th>
				<td></td>
				<td></td>
				<th class="alignReq"><label for="date">Date of Launch</label></th>
				<td></td>
				<td></td>
				<th class="alignReq"><label for="selectCategory">Genre</label>
				</th>
			</tr>
			<tr>
				<td><input type="text" id="moviegross" name="boxOffice"
					size="9"
					value="<fmt:formatNumber value="${editMovie.boxOffice}" pattern="##########" minFractionDigits = "0" />">
				</td>
				<td>&nbsp;</td>
				<td><input type="radio" id="Active-yes" name="active"
					value="Yes" <c:if test="${editMovie.active}">checked</c:if>>
					<label for="Active-yes">Yes</label> <input type="radio"
					id="Active-no" name="active" value="No"
					<c:if test="${!editMovie.active}">checked</c:if>> <label
					for="Active-no">No</label></td>
				<td></td>
				<td>&nbsp;</td>
				<td><input type="text" name="dateOfLaunch" id="date" size="16"
					value="<fmt:formatDate value="${editMovie.dateOfLaunch}" pattern="dd/MM/yyyy" />">
				</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td><select name="genre" id="selectCategory">
						<option value="Science Fiction"
							<c:if test="${editMovie.genre eq 'Science Fiction'}">selected</c:if>>Science
							Fiction</option>
						<option value="Superhero"
							<c:if test="${editMovie.genre eq 'Superhero'}">selected</c:if>>Superhero</option>
						<option value="Romance"
							<c:if test="${editMovie.genre eq 'Romance'}">selected</c:if>>Romance</option>
						<option value="Comedy"
							<c:if test="${editMovie.genre eq 'Comedy'}">selected</c:if>>Comedy</option>
						<option value="Adventure"
							<c:if test="${editMovie.genre eq 'Adventure'}">selected</c:if>>Adventure</option>
						<option value="Thriller"
							<c:if test="${editMovie.genre eq 'Thriller'}">selected</c:if>>Thriller</option></td>
			</tr>
			<tr>
				<td><br /></td>
			</tr>
			<tr>
				<td colspan="4" class="alignReq"><input type="checkbox"
					name="hasTeaser" id="check"
					<c:if test="${editMovie.hasTeaser}">checked</c:if>><strong><label
						for="check">Has Teaser</label></strong></td>
			</tr>
			<tr>
				<td><br /></td>
			</tr>
			<tr>
				<td colspan="4" class="alignReq"><input type="submit"
					class="submitBtn" value="Save" name="submit"></td>
			</tr>
			<table>
				</form>

				<footer>Copyright &copy; 2019</footer>
</body>

</html>