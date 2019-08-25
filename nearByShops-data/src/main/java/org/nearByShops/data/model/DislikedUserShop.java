package org.nearByShops.data.model;

import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.nearByShops.data.model.utils.DislikedUserShopKey;

@Entity
public class DislikedUserShop {

	@EmbeddedId
	private DislikedUserShopKey dislikedUserShopId;
	private LocalDateTime dislikedDate;

	@ManyToOne
	@JoinColumn(name = "shopId")
	@MapsId("shopId")
	public Shop shop;

	@ManyToOne
	@JoinColumn(name = "userId")
	@MapsId("userId")
	public User user;

	public DislikedUserShopKey getDislikedUserShopId() {
		return dislikedUserShopId;
	}

	public void setDislikedUserShopId(DislikedUserShopKey dislikedUserShopId) {
		this.dislikedUserShopId = dislikedUserShopId;
	}

	public LocalDateTime getDislikedDate() {
		return dislikedDate;
	}

	public void setDislikedDate(LocalDateTime dislikedDate) {
		this.dislikedDate = dislikedDate;
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
		return "DislikedUserShop [dislikedUserShopId=" + dislikedUserShopId + ", dislikedDate=" + dislikedDate
				+ ", shop=" + shop + ", user=" + user + "]";
	}

}
