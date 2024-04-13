package com.rbaintro.RoleBasedAuthorisationIntroduction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rbaintro.RoleBasedAuthorisationIntroduction.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.username=?1")
	public User getUserByUsername(String username);
}
