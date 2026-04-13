package com.leslie.Taskmanager.Dao;

import java.util.List;

import com.leslie.Taskmanager.Dto.UserResponse;

public interface IUserDao {

	//Methode qui permet d'afficher la lise total des utilisateurs trié par ordre croissan avec Criteria Builder
	public List<UserResponse> getUsersCriteria(String username);
	
	//Methode qui permet d'afficher le nombre total de user avec Criteria Builder
	public Long countUser();
	
}
