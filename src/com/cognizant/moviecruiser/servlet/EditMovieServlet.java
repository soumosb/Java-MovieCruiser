package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.Date;

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
import com.cognizant.moviecruiser.util.DateUtil;

/**
 * Servlet implementation class EditMovieServlet
 */
@WebServlet("/EditMovie")
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMovieServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("title");
		long boxOffice = Long.parseLong(request.getParameter("boxOffice"));
		boolean active = request.getParameter("active").equals("Yes") ? true : false;
		Date dateOfLaunch = DateUtil.convertToDate(request.getParameter("dateOfLaunch"));
		String genre = request.getParameter("genre");
		boolean hasTeaser = request.getParameter("hasTeaser") != null ? true : false;
		MovieListDao movieListDao = new MovieNameDaoSqlImpl();
		MovieList movieName = new MovieList(id, name, boxOffice, active, dateOfLaunch, genre, hasTeaser);
		try {
			movieListDao.modifyMovieList(movieName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("edit-movie-status.jsp");
		rd.forward(request, response);
	}

}
