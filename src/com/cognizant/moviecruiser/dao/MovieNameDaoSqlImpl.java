package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieList;

public class MovieNameDaoSqlImpl implements MovieListDao {

	private static final String GET_ALL_MOVIE_NAMES = "SELECT * FROM moviecruiser.movie";
	private static final String GET_MOVIE_LIST_CUSTOMER = "SELECT * FROM moviecruiser.movie WHERE mo_date_of_launch < CURDATE() AND mo_active= 'Yes';";
	private static final String UPDATE_MOVIE_NAME = "UPDATE moviecruiser.movie SET mo_title = ?, mo_box_office = ?, mo_active = ?,mo_date_of_launch = ?,mo_genre = ?,mo_has_teaser = ? where mo_id =?";
	private static final String GET_MOVIE_BY_ID = "select * from moviecruiser.movie where mo_id = ?";

	@Override
	public List<MovieList> getMovieListAdmin() throws Exception {
		Connection cn = ConnectionHandler.getConnection();
		List<MovieList> movieNameList = new ArrayList<MovieList>();
		PreparedStatement statement = null;
		ResultSet movieNameResultSet = null;
		MovieList movieName = null;
		try {
			statement = cn.prepareStatement(GET_ALL_MOVIE_NAMES);
			movieNameResultSet = statement.executeQuery();
			while (movieNameResultSet.next()) {
				movieName = new MovieList();
				movieName.setId(movieNameResultSet.getLong("mo_id"));
				movieName.setTitle(movieNameResultSet.getString("mo_title"));
				movieName.setBoxOffice(movieNameResultSet.getLong("mo_box_office"));
				movieName.setActive(movieNameResultSet.getString("mo_active").equals("Yes") ? true : false);
				movieName.setDateOfLaunch(movieNameResultSet.getDate("mo_date_of_launch"));
				movieName.setGenre(movieNameResultSet.getString("mo_genre"));
				movieName.setHasTeaser(movieNameResultSet.getString("mo_has_teaser").equals("Yes") ? true : false);
				movieNameList.add(movieName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (movieNameResultSet != null) {
					movieNameResultSet.close();

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
		return movieNameList;
	}

	@Override
	public List<MovieList> getMovieListCustomer() throws Exception {
		Connection cn = ConnectionHandler.getConnection();
		List<MovieList> movieNameList = new ArrayList<MovieList>();
		PreparedStatement statement = null;
		ResultSet movieNameResultSet = null;
		MovieList movieName = null;
		try {
			statement = cn.prepareStatement(GET_MOVIE_LIST_CUSTOMER);
			movieNameResultSet = statement.executeQuery();
			while (movieNameResultSet.next()) {
				movieName = new MovieList();
				movieName.setId(movieNameResultSet.getLong("mo_id"));
				movieName.setTitle(movieNameResultSet.getString("mo_title"));
				movieName.setBoxOffice(movieNameResultSet.getLong("mo_box_Office"));
				movieName.setActive(movieNameResultSet.getString("mo_active").equals("Yes") ? true : false);
				movieName.setHasTeaser(movieNameResultSet.getString("mo_has_teaser").equals("Yes") ? true : false);
				movieName.setGenre(movieNameResultSet.getString("mo_genre"));
				movieNameList.add(movieName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (movieNameResultSet != null) {
					movieNameResultSet.close();

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
		return movieNameList;
	}

	@Override
	public void modifyMovieList(MovieList movieName) throws Exception {
		Connection cn = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = cn.prepareStatement(UPDATE_MOVIE_NAME);
			statement.setString(1, movieName.getTitle());
			statement.setLong(2, movieName.getBoxOffice());
			statement.setString(3, movieName.isActive() ? "Yes" : "No");
			statement.setDate(4, new java.sql.Date(movieName.getDateOfLaunch().getTime()));
			statement.setString(5, movieName.getGenre());
			statement.setString(6, movieName.isHasTeaser() ? "Yes" : "No");
			statement.setLong(7, movieName.getId());
			statement.executeUpdate();
			System.out.println(movieName);
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
	public MovieList getMovieName(long movieNameId) throws Exception {
		Connection cn = ConnectionHandler.getConnection();
		MovieList movieName = new MovieList();
		PreparedStatement statement = null;
		ResultSet movieNameResultSet = null;
		try {
			statement = cn.prepareStatement(GET_MOVIE_BY_ID);
			statement.setLong(1, movieNameId);
			movieNameResultSet = statement.executeQuery();
			while (movieNameResultSet.next()) {
				movieName = new MovieList();
				movieName.setId(movieNameResultSet.getLong("mo_id"));
				movieName.setTitle(movieNameResultSet.getString("mo_title"));
				movieName.setBoxOffice(movieNameResultSet.getLong("mo_box_office"));
				movieName.setActive(movieNameResultSet.getString("mo_active").equals("Yes") ? true : false);
				movieName.setDateOfLaunch(movieNameResultSet.getDate("mo_date_of_launch"));
				movieName.setGenre(movieNameResultSet.getString("mo_genre"));
				movieName.setHasTeaser(movieNameResultSet.getString("mo_has_teaser").equals("Yes") ? true : false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (movieNameResultSet != null) {
					movieNameResultSet.close();

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
		return movieName;
	}

}
