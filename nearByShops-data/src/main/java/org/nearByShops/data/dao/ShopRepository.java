package org.nearByShops.data.dao;

import java.util.List;

import org.nearByShops.data.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Integer> {

	/*
	 * Near Shops ordered by distance, respecting also the criteria : liked shops
	 * shouldn’t be displayed on the main page
	 */
	@Query(value = "select s.* from nearbyshops.shop s where s.shop_id not in"
			+ " (select fvShop.shop_id from nearbyshops.favorite_user_shop fvShop where fvShop.user_id = ?1) order by s.distance", nativeQuery = true)
	public List<Shop> findByOrderByDistance(int id);

	/*
	 * Render all the favorite shops for the given user (here we are using email, we
	 * can use the user Id but we implement this solution for diversity)
	 */
	@Query(value = "select * from nearbyshops.shop s join nearbyshops.favorite_user_shop fvShop on s.shop_id = fvShop.shop_id "
			+ "where fvShop.user_id = ?1 order by s.distance", nativeQuery = true)
	public List<Shop> findFavoriteShop(int userId);

}
