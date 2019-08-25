package org.nearByShops.data.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.nearByShops.data.model.utils.FavoriteUserShopKey;

@Entity
public class FavoriteUserShop {

	// @EmbeddedId : used to mark the primary key
	@EmbeddedId
	private FavoriteUserShopKey favoriteUserShopKey;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_id")
	@MapsId("shopId")
	private Shop shop;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@MapsId("userId")
	private User user;

	public FavoriteUserShop(FavoriteUserShopKey favoriteUserShopKey, Shop shop, User user) {
		this.favoriteUserShopKey = favoriteUserShopKey;
		this.shop = shop;
		this.user = user;
	}
	
	public FavoriteUserShop() {
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "FavoriteUserShop [favoriteUserShopId=" + favoriteUserShopKey + ", shop=" + shop + ", user=" + user + "]";
	}

}
