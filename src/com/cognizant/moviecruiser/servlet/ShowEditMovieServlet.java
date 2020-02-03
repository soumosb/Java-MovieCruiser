package com.cognizant.moviecruiser.servlet;

import java.io.IOException;

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
 * Servlet implementation class ShowEditMovieServlet
 */
@WebServlet("/ShowEditMovie")
public class ShowEditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowEditMovieServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		MovieListDao movieListDao = new MovieNameDaoSqlImpl();
		MovieList editMovie = null;
		try {
			editMovie = movieListDao.getMovieName(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("editMovie", editMovie);
		RequestDispatcher editMenuRd = request.getRequestDispatcher("edit-movie.jsp");
		editMenuRd.forward(request, response);
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
