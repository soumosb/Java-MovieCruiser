package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieListDao;
import com.cognizant.moviecruiser.dao.MovieListDaoCollectionImpl;
import com.cognizant.moviecruiser.dao.MovieNameDaoSqlImpl;
import com.cognizant.moviecruiser.model.MovieList;

/**
 * Servlet implementation class ShowMovieListAdminServlet
 */
@WebServlet("/ShowMovieListAdmin")
public class ShowMovieListAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowMovieListAdminServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MovieListDao movieListDao = new MovieNameDaoSqlImpl();
		List<MovieList> movieNameList = null;
		try {
			movieNameList = movieListDao.getMovieListAdmin();
		} catch (Exception e) {

			e.printStackTrace();
		}
		request.setAttribute("movieNameList", movieNameList);
		RequestDispatcher rd = request.getRequestDispatcher("movie-list-admin.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
