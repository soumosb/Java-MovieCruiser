<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

	<div class="page-title">
		Favorites <br /> <br /> <br />
		<p class="favoriteEmpty-message">
			No items in Favorites. Use 'Add to Favorite' option in <a
				href="ShowMovieListCustomer" class="linkColorEmpty">Movie List.</a>
		</p>
	</div>

	<footer> Copyright &copy; 2019 </footer>
</body>

</html>