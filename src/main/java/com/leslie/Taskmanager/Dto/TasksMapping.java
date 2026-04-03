package com.leslie.Taskmanager.Dto;

import com.leslie.Taskmanager.Entity.Tasks;

public class TasksMapping {

	public static TasksResponseDTO TaskToresponse(Tasks ta) {
		TasksResponseDTO tr = new TasksResponseDTO();
		tr.setDescription(ta.getDescription());
		tr.setId(ta.getId());
		tr.setStatus(ta.getStatus());
		tr.setTitle(ta.getTitle());
		tr.setUpdatedAt(ta.getUpdatedAt());
		tr.setUser(ta.getUser().getId());
		return tr;
		
	}
	
	public static Tasks requestToTasks(TasksRequestDto ta) {
		Tasks tas = new Tasks();
		tas.setDescription(ta.getDescription());
		tas.setStatus(ta.getStatus());
		tas.setTitle(ta.getTitle());
		tas.setUpdated_at(ta.getUpdatedAt());
		
		return tas;
		
	}
}
