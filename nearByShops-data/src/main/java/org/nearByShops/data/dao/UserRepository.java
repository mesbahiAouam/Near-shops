package org.nearByShops.data.dao;

import java.util.Optional;

import org.nearByShops.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public Optional<User> findByEmail(String email);
}
