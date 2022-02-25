package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.UserInfo;
@Repository
public interface UserRepository extends JpaRepository<UserInfo, Long> {
	
	@Query("SELECT u FROM UserInfo u WHERE u.email = ?1")
	UserInfo findByEmail(String email);

}
