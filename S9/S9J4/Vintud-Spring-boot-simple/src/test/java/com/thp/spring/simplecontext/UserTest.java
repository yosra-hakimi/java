package com.thp.spring.simplecontext;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.thp.spring.simplecontext.Repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void testFindUserByMail() {
		 int id = userRepository.findByMail("johnyPirate@Cara.com").getId();
		 assertEquals(1, id);
	}

}
