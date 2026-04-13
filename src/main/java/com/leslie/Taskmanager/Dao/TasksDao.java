package com.leslie.Taskmanager.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.leslie.Taskmanager.Entity.Tasks;

@Repository
public interface TasksDao extends JpaRepository<Tasks, Long> {


}
