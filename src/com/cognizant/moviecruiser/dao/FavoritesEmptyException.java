package com.cognizant.moviecruiser.dao;

public class FavoritesEmptyException extends Exception {

	public FavoritesEmptyException() {
		super();

	}

	@Override
	public String toString() {
		return "Favorites is Empty";
	}

}
