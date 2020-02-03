package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.MovieList;

public interface MovieListDao {
	public List<MovieList> getMovieListAdmin() throws Exception;

	public List<MovieList> getMovieListCustomer() throws Exception;

	public void modifyMovieList(MovieList movieName) throws Exception;

	public MovieList getMovieName(long movieNameId) throws Exception;

}
