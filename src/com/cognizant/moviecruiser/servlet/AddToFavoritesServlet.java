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
import com.cognizant.moviecruiser.dao.FavoritesDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.FavortiesDaoSqlImpl;
import com.cognizant.moviecruiser.dao.MovieListDao;
import com.cognizant.moviecruiser.dao.MovieListDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.MovieNameDaoSqlImpl;
import com.cognizant.moviecruiser.model.MovieList;

/**
 * Servlet implementation class AddToFavoritesServlet
 */
@WebServlet("/AddToFavorites")
public class AddToFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToFavoritesServlet() {
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
		long id = Long.parseLong(request.getParameter("id"));
		try {
			favoritesDao.addFavorites(userId, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MovieListDao movieListDao = new MovieNameDaoSqlImpl();
		List<MovieList> movieNameList = null;
		try {
			movieNameList = movieListDao.getMovieListCustomer();
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("movieNameList", movieNameList);
		request.setAttribute("addFavoriteStatus", true);
//		ServletContext context = getServletContext();
//		context.setAttribute("favoriteDao", favoritesDao);
		RequestDispatcher addStatusRd = request.getRequestDispatcher("movie-list-customer.jsp");
		addStatusRd.forward(request, response);
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
