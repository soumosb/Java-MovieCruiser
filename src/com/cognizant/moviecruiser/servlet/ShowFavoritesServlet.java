package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavoritesDao;
import com.cognizant.moviecruiser.dao.FavoritesEmptyException;
import com.cognizant.moviecruiser.dao.FavortiesDaoSqlImpl;
import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.MovieList;

/**
 * Servlet implementation class ShowFavoritesServlet
 */
@WebServlet("/ShowFavorites")
public class ShowFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowFavoritesServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FavoritesDao favoritesDao = new FavortiesDaoSqlImpl();
		long userId = 1;
//		ServletContext context = getServletContext();
//		FavoritesDao favoritesDao = (FavoritesDao) context.getAttribute("favoriteDao");
		try {
			Favorites favorites = favoritesDao.getAllFavorites(userId);
			List<MovieList> movieNameList = favorites.getmovieList();
			request.setAttribute("movieNameList", movieNameList);
			request.setAttribute("setFavorites", favorites.getNoOfFavorites());
			RequestDispatcher showFavorites = request.getRequestDispatcher("favorites.jsp");
			showFavorites.forward(request, response);
		} catch (FavoritesEmptyException e) {
			RequestDispatcher emptyCartRd = request.getRequestDispatcher("favorites-empty.jsp");
			emptyCartRd.forward(request, response);
		} catch (Exception e) {
			RequestDispatcher emptyCartRd = request.getRequestDispatcher("favorites-empty.jsp");
			emptyCartRd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
