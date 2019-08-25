package org.nearByShops.data.model.utils;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class FavoriteUserShopKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private int userId;
	private int shopId;

	public FavoriteUserShopKey() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public FavoriteUserShopKey(int userId, int shopId) {
		this.userId = userId;
		this.shopId = shopId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + shopId;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FavoriteUserShopKey other = (FavoriteUserShopKey) obj;
		if (shopId != other.shopId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FavoriteUserShopKey [userId=" + userId + ", shopId=" + shopId + "]";
	}

}
