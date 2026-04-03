package com.leslie.Taskmanager.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.leslie.Taskmanager.Entity.User;
import com.leslie.Taskmanager.Repository.UserRepository;

@SpringBootTest
public class UserDaoTest {
	@Autowired
	private UserRepository userDao;
	public int tailleUser=0;
	@Test
	public void enregistrerTache() {
		User t= new User();
		t.setEmail("leslie@gmail.com");
		t.setUsername("leslie");
		userDao.save(t);
		tailleUser=userDao.findAll().size();
		assertEquals(1, tailleUser);
	}
	
}
