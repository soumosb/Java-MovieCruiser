package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.MovieList;

public class FavortiesDaoSqlImpl implements FavoritesDao {

	private static final String INSERT_FAVORITE = "INSERT INTO moviecruiser.favorite(fv_us_id,fv_mo_id) VALUES (?,?)";
	private static final String GET_ALL_FAVORITES_BY_USER_ID = " SELECT m.mo_id, m.mo_title, m.mo_box_office , m.mo_genre, m.mo_has_teaser  from moviecruiser.movie m, moviecruiser.favorite f where f.fv_mo_id = m.mo_id and fv_us_id =?";
	private static final String GET_NO_OF_FAVORITE = "SELECT COUNT(mo_id) FROM moviecruiser.movie m, moviecruiser.favorite f where m.mo_id = f.fv_mo_id and f.fv_us_id=?;";
	private static final String REMOVE_FAVORITE = "DELETE FROM moviecruiser.favorite WHERE fv_us_id=? and fv_mo_id=?";

	@Override
	public void addFavorites(long userId, long movieNameId) throws Exception {
		Connection cn = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = cn.prepareStatement(INSERT_FAVORITE);
			statement.setLong(1, userId);
			statement.setLong(2, movieNameId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Favorites getAllFavorites(long userId) throws FavoritesEmptyException {
		int totalFavorites = 0;
		Favorites favorites = null;
		Connection cn = ConnectionHandler.getConnection();
		List<MovieList> movieNameList = new ArrayList<MovieList>();
		PreparedStatement statement = null;
		ResultSet favoriteResultSet = null;
		try {
			statement = cn.prepareStatement(GET_ALL_FAVORITES_BY_USER_ID);
			statement.setLong(1, userId);
			favoriteResultSet = statement.executeQuery();
			while (favoriteResultSet.next()) {
				MovieList movieName = new MovieList();
				movieName.setId(favoriteResultSet.getLong("mo_id"));
				movieName.setTitle(favoriteResultSet.getString("mo_title"));
				movieName.setBoxOffice(favoriteResultSet.getLong("mo_box_office"));
				movieName.setHasTeaser(favoriteResultSet.getString("mo_has_teaser").equals("Yes") ? true : false);
				movieName.setGenre(favoriteResultSet.getString("mo_genre"));
				movieNameList.add(movieName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement = cn.prepareStatement(GET_NO_OF_FAVORITE);
			statement.setLong(1, userId);
			favoriteResultSet = statement.executeQuery();
			while (favoriteResultSet.next()) {
				totalFavorites = favoriteResultSet.getInt("COUNT(mo_id)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (favoriteResultSet != null) {
					favoriteResultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		if (movieNameList.size() == 0) {
			throw new FavoritesEmptyException();
		}
		favorites = new Favorites(movieNameList, totalFavorites);
		return favorites;

	}

	@Override
	public void removeFavorites(long userId, long movieNameId) throws Exception {
		Connection cn = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = cn.prepareStatement(REMOVE_FAVORITE);
			statement.setLong(1, userId);
			statement.setLong(2, movieNameId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (cn != null) {
					cn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
