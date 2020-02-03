package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.MovieList;

public class FavoritesDaoCollectionImpl implements FavoritesDao {

	private HashMap<Long, Favorites> userFavorites;

	public FavoritesDaoCollectionImpl() {
		super();
		if (userFavorites == null)
			userFavorites = new HashMap<Long, Favorites>();
	}

	@Override
	public void addFavorites(long userId, long movieNameId) throws Exception {
		MovieListDao movieListDao = new MovieListDaoCollectionImpl();
		MovieList movieList = movieListDao.getMovieName(movieNameId);
		if (userFavorites.containsKey(userId)) {
			userFavorites.get(userId).getmovieList().add(movieList);
		} else {
			Favorites newFavorites = new Favorites();
			ArrayList<MovieList> movieNames = new ArrayList<>();
			movieNames.add(movieList);
			newFavorites.setmovieList(movieNames);
			userFavorites.put(userId, newFavorites);
		}
	}

	public Favorites getAllFavorites(long userId) throws FavoritesEmptyException {
		Favorites favorites = userFavorites.get(userId);
		if (favorites == null || favorites.getmovieList().isEmpty()) {
			throw new FavoritesEmptyException();
		}
		List<MovieList> movieList = favorites.getmovieList();
		favorites.setNoOfFavorites(movieList.size());
		return favorites;

	}

	/**
	 * Used to remove the favorites. Has two attributes userId and movieNameId
	 */
	public void removeFavorites(long userId, long movieNameId) throws Exception {
		List<MovieList> movieList = userFavorites.get(userId).getmovieList();
		for (MovieList movieNameList : movieList) {
			if (movieNameList.getId() == movieNameId) {
				movieList.remove(movieNameList);
				break;

			}
		}
	}

}
