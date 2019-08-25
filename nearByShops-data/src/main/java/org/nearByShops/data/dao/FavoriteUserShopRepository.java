package org.nearByShops.data.dao;

import org.nearByShops.data.model.FavoriteUserShop;
import org.nearByShops.data.model.utils.FavoriteUserShopKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface FavoriteUserShopRepository extends JpaRepository<FavoriteUserShop, FavoriteUserShopKey> {
	public void deleteByUserUserIdAndShopShopId(int userId, int shopId);
}
