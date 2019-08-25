package org.nearByShops.data.model.utils;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DislikedUserShopKey implements Serializable {

	private static final long serialVersionUID = 1L;
	private int userId;
	private int shopId;

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
		DislikedUserShopKey other = (DislikedUserShopKey) obj;
		if (shopId != other.shopId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

}
