package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.MovieList;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieListDaoCollectionImplTest {

	public static void main(String[] args) throws Exception {

		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testModifyMovieList();

	}

	public static void testGetMovieListAdmin() throws Exception {
		System.out.println("Movie List for Admin: ");
		MovieListDao movieListDao = new MovieListDaoCollectionImpl();
		List<MovieList> movieList = movieListDao.getMovieListAdmin();
		for (MovieList movieName : movieList) {
			System.out.println(movieName);
		}
		System.out.println();

	}

	public static void testGetMovieListCustomer() throws Exception {
		System.out.println("Movie List for Customer: ");
		MovieListDao movieListDao = new MovieListDaoCollectionImpl();
		List<MovieList> movieList = movieListDao.getMovieListCustomer();
		for (MovieList movieName : movieList) {
			System.out.println(movieName);
		}
		System.out.println();
	}

	public static void testModifyMovieList() throws Exception {
		System.out.println("Modified Movie List: ");
		MovieList movieName1 = new MovieList(1001, "Forrest Gump", 27898550789l, true,
				DateUtil.convertToDate("15/03/2017"), "Drama", true);
		MovieListDao movieListDao = new MovieListDaoCollectionImpl();
		movieListDao.modifyMovieList(movieName1);
		for (MovieList movieName : movieListDao.getMovieListAdmin()) {
			System.out.println(movieName);
		}
		MovieList movieList = movieListDao.getMovieName(movieName1.getId());
		System.out.println("Modified Movie Details: ");
		System.out.println("Name: " + movieList.getTitle() + ", Genre: " + movieList.getGenre());

	}

}
