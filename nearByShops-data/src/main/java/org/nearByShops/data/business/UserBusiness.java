package org.nearByShops.data.business;

import org.nearByShops.data.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserBusiness extends UserDetailsService {
	public User signUp(User user);

}
