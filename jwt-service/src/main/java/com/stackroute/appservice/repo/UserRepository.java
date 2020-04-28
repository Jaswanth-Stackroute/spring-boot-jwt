package com.stackroute.appservice.repo;

import com.stackroute.appservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{

	public User findByIdAndPassword(String id, String password);
	
}
