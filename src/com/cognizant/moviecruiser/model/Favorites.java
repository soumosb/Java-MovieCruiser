package com.cognizant.moviecruiser.model;

import java.util.List;

public class Favorites {

	private List<MovieList> movieList;
	private int noOfFavorites;

	public Favorites() {
		super();

	}

	public Favorites(List<MovieList> movieList, int noOfFavorites) {
		super();
		this.movieList = movieList;
		this.noOfFavorites = noOfFavorites;
	}

	public List<MovieList> getmovieList() {
		return movieList;
	}

	public void setmovieList(List<MovieList> movieList) {
		this.movieList = movieList;
	}

	public int getNoOfFavorites() {
		return noOfFavorites;
	}

	public void setNoOfFavorites(int noOfFavorites) {
		this.noOfFavorites = noOfFavorites;
	}

	@Override
	public String toString() {
		return "Favorites [movieList=" + movieList + ", noOfFavorites=" + noOfFavorites + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favorites other = (Favorites) obj;
		if (movieList == null) {
			if (other.movieList != null)
				return false;
		} else if (!movieList.equals(other.movieList))
			return false;
		if (noOfFavorites != other.noOfFavorites)
			return false;
		return true;
	}

}
