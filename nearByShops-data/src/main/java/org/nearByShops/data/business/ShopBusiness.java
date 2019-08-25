package org.nearByShops.data.business;

import java.util.List;

import org.nearByShops.data.model.Shop;

public interface ShopBusiness {
	public List<Shop> getAllShops(int userId);

	public List<Shop> getAllFavoriteShops(int userId);

	// like a shop so it will be add to the favorite list
	public List<Shop> addShopToFavorite(int userId, int shopId);
	
	public void removeFavoriteShopRepository(int userId, int shopId);
}