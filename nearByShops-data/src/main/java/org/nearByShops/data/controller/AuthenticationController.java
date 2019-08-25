package org.nearByShops.data.controller;

import java.net.URI;

import javax.validation.Valid;

import org.nearByShops.data.business.UserBusiness;
import org.nearByShops.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
	@Autowired
	private UserBusiness userBusiness;

	@PostMapping("/signup")
	public ResponseEntity<User> signUp(@Valid @RequestBody User user) {

		User result = userBusiness.signUp(user);
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/{user}")
				.buildAndExpand(result.getEmail()).toUri();
		return ResponseEntity.created(location).body(result);

	}
}
