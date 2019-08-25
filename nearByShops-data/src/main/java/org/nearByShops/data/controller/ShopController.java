package org.nearByShops.data.controller;

import java.util.List;

import org.nearByShops.data.business.ShopBusiness;
import org.nearByShops.data.model.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/shop")
public class ShopController {

	@Autowired
	private ShopBusiness shopBusiness;

	@GetMapping("/shopList")
	public ResponseEntity<List<Shop>> getShopsSortByDistance(@RequestParam int userId) {
		return ResponseEntity.ok(shopBusiness.getAllShops(userId));
	}

	@GetMapping("/favoriteShopList")
	public ResponseEntity<List<Shop>> getFavoriteShops(@RequestParam int userId) {
		return ResponseEntity.ok(shopBusiness.getAllFavoriteShops(userId));
	}

	@DeleteMapping("/removeFavoriteShop/{userId}/{shopId}")
	public void delete(@PathVariable int userId, @PathVariable int shopId) {
		shopBusiness.removeFavoriteShopRepository(userId, shopId);
	}

	@PutMapping("/addShopToFavorite/{userId}/{shopId}")
	public ResponseEntity<List<Shop>> addShopToFavorite(@PathVariable int userId, @PathVariable int shopId) {
		return ResponseEntity.ok(shopBusiness.addShopToFavorite(userId, shopId));
	}

}
