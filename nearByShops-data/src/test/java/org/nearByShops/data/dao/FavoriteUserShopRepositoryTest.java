package org.nearByShops.data.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.nearByShops.data.business.ShopBusiness;
import org.nearByShops.data.business.ShopBusinessDefault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FavoriteUserShopRepositoryTest {

//	private FavoriteUserShopRepository favoriteUserShopRepository;
	@Autowired
	private ShopBusiness shopBusiness;

	@TestConfiguration
	static class Config {
		@Bean
		public ShopBusiness shopBusiness() {
			return new ShopBusinessDefault();
		}
	}

	@Test
	@Transactional
	public void deleteFavoriteShop() {
	}
}
