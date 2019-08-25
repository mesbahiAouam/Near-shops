package org.nearByShops.data.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.nearByShops.data.dao.UserRepository;
import org.nearByShops.data.model.Role;
import org.nearByShops.data.model.User;
import org.nearByShops.data.utils.AuthenticationException;
import org.nearByShops.data.utils.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessDefault implements UserBusiness {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public User signUp(User user) {
		if (userRepository.findByEmail(user.getEmail()).isPresent())
			throw new AuthenticationException("Email is already taken!");
		List<Role> roles = new ArrayList<>(Arrays.asList(new Role().roleName("AUTHENTICATE")));
		return userRepository.save(user.password(passwordEncoder.encode(user.getPassword())).roles(roles));
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByEmail(email);
		if (!user.isPresent())
			throw new UsernameNotFoundException("User not found with email : " + email);
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		user.get().getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
		return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(),
				authorities);
	}

}
