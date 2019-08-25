package org.nearByShops.data.business;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.nearByShops.data.dao.FavoriteUserShopRepository;
import org.nearByShops.data.dao.ShopRepository;
import org.nearByShops.data.dao.UserRepository;
import org.nearByShops.data.model.FavoriteUserShop;
import org.nearByShops.data.model.Shop;
import org.nearByShops.data.model.User;
import org.nearByShops.data.model.utils.FavoriteUserShopKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopBusinessDefault implements ShopBusiness {
	@Autowired
	private ShopRepository shopRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FavoriteUserShopRepository favoriteUserShopRepository;

	@Override
	public List<Shop> getAllFavoriteShops(int userId) {
		return shopRepository.findFavoriteShop(userId);
	}

	@Override
	public List<Shop> getAllShops(int userId) {
		return shopRepository.findByOrderByDistance(userId);
	}

	@Override
	public List<Shop> addShopToFavorite(int userId, int shopId) {
		Optional<User> user = userRepository.findById(userId);
		Optional<Shop> shop = shopRepository.findById(shopId);
		if (user.isPresent() && shop.isPresent()) {
			favoriteUserShopRepository.save(new FavoriteUserShop(
					new FavoriteUserShopKey(user.get().getUserId(), shop.get().getShopId()), shop.get(), user.get()));
			return getAllFavoriteShops(userId);
		}
		return Collections.emptyList();
	}

	@Override
	public void removeFavoriteShopRepository(int userId, int shopId) {
		favoriteUserShopRepository.deleteByUserUserIdAndShopShopId(userId, shopId);
	}

}
