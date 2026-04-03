package com.leslie.Taskmanager.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.leslie.Taskmanager.Entity.Status;
import com.leslie.Taskmanager.Entity.Tasks;
import com.leslie.Taskmanager.Repository.TasksRepository;
import com.leslie.Taskmanager.Repository.UserRepository;

@SpringBootTest
public class TasksDaoTest {
	public int tailleUser=0;
	@Autowired
	private TasksRepository task;
	@Autowired
	private UserRepository userDao;
	@SuppressWarnings("deprecation")
	@Test
	public void enregistrerTache() {
		Tasks t= new Tasks();
		t.setDescription("Apprendre Git en profondeur");
		t.setStatus(Status.IN_PROGRESS);
		t.setTitle("GIT");
		t.setUser(userDao.getById((long) 1));
		task.save(t);
		tailleUser=task.findAll().size();
		assertEquals(1, tailleUser);
	}
}
