package com.thp.spring.simplecontext;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.thp.spring.simplecontext.Repository.AnnouncementRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnouncementTest {
	
	@Autowired
	private AnnouncementRepository announcementRepository;
	
	@Test
	public void test() {
		
		int id = announcementRepository.findById(1).get().getId();
		 assertEquals(1, id);
	}

}
