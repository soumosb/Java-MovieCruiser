package com.cognizant.moviecruiser.dao;

public class FavoritesDaoCollectionImplTest {

	public static void main(String[] args) throws Exception {

		testAddFavorites();
		testRemoveFavorites();
	}

	public static void testAddFavorites() throws Exception {
		FavoritesDao favoriteDao = new FavoritesDaoCollectionImpl();
		favoriteDao.addFavorites(2, 1003);
		favoriteDao.addFavorites(2, 1005);
		favoriteDao.addFavorites(1, 1004);
		try {
			System.out.println(favoriteDao.getAllFavorites(2));
			System.out.println(favoriteDao.getAllFavorites(1));
		} catch (FavoritesEmptyException e) {
			e.printStackTrace();
		}
	}

	public static void testRemoveFavorites() throws Exception {
		FavoritesDao favoriteDao = new FavoritesDaoCollectionImpl();
		favoriteDao.addFavorites(2, 1001);
		favoriteDao.removeFavorites(2, 1001);
		try {
			System.out.println(favoriteDao.getAllFavorites(2));
		} catch (FavoritesEmptyException e) {
			System.out.println(e);
		}
	}

}
