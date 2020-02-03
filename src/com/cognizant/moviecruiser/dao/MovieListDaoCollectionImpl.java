package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieList;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieListDaoCollectionImpl implements MovieListDao {

	private static List<MovieList> movieList;

	public MovieListDaoCollectionImpl() {
		super();
		if (movieList == null) {
			movieList = new ArrayList<MovieList>();
			MovieList movieName1 = new MovieList(1001, "Avatars", 2787965087l, true,
					DateUtil.convertToDate("15/03/2017"), "Science Fiction", true);
			MovieList movieName2 = new MovieList(1002, "The Avengers", 1518812988l, true,
					DateUtil.convertToDate("23/12/2017"), "Superhero", false);
			MovieList movieName3 = new MovieList(1003, "Titanic", 2187463944l, true,
					DateUtil.convertToDate("21/08/2017"), "Romance", false);
			MovieList movieName4 = new MovieList(1004, "Jurassic World", 1671713208l, false,
					DateUtil.convertToDate("02/07/2017"), "Science Fiction", true);
			MovieList movieName5 = new MovieList(1005, "Avengers: End Game", 2750760348l, true,
					DateUtil.convertToDate("02/11/2022"), "Superhero", true);
			movieList.add(movieName1);
			movieList.add(movieName2);
			movieList.add(movieName3);
			movieList.add(movieName4);
			movieList.add(movieName5);
		}
	}

	@Override
	public MovieList getMovieName(long movieNameId) throws Exception {
		for (MovieList movieName : movieList) {
			if (movieName.getId() == movieNameId)
				return movieName;
		}
		return null;
	}

	@Override
	public List<MovieList> getMovieListAdmin() throws Exception {
		return movieList;
	}

	@Override
	public List<MovieList> getMovieListCustomer() throws Exception {
		ArrayList<MovieList> filteredMovieName = new ArrayList<MovieList>();
		for (MovieList movieName : movieList) {
			if (movieName.getDateOfLaunch().before(new Date()) && movieName.isActive())
				filteredMovieName.add(movieName);
		}
		return filteredMovieName;
	}

	@Override
	public void modifyMovieList(MovieList movieName) throws Exception {
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getId() == movieName.getId()) {
				movieList.set(i, movieName);
			}
		}

	}

}
