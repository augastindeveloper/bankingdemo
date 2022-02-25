package com;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.entity.UserInfo;
import com.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		UserInfo user = new UserInfo();
		user.setEmail("hari@gmail.com");
		user.setPassword("hari123");
		user.setFirstName("hari");
		user.setLastName("krishnan");
		
		UserInfo saveuser= repo.save(user);
		
//		UserInfo exituser=entityManager.find(UserInfo.class, saveuser.getAccountNumber());
		
//		assertThat(exituser.getEmail()).isEqualTo(user.getEmail());
		
	}
	
	@Test
	public void testFindUserByEmail() {
		String email="nomailaugustin@gmail.com";
		
		UserInfo user = repo.findByEmail(email);
		
		assertThat(user).isNotNull();
	}


}
