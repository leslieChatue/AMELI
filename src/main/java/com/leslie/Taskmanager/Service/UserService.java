package com.leslie.Taskmanager.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.leslie.Taskmanager.Dto.UserMapping;
import com.leslie.Taskmanager.Dto.UserRequest;
import com.leslie.Taskmanager.Dto.UserResponse;
import com.leslie.Taskmanager.Entity.User;
import com.leslie.Taskmanager.Exception.ResourceNotFoundException;
import com.leslie.Taskmanager.Repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// Methode simple
	/*
	 * public List<User> getAllUsers() { return userRepository.findAll(); }
	 * 
	 * public User saveUser(User user) { return userRepository.save(user); }
	 */
	
	

	// Méthode complexe
	//Affichage de tous les Users
	//On va refaire la même chose que l'on a fait pour la methode simple sauf que ctte fois ci on va l'adpater pour que cela correspondent
	// avec les dto que l'on a créé 
	public List<UserResponse> getAllUsers() {
		List<User> list = userRepository.findAll();
		List<UserResponse> listUserResp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			listUserResp.add(UserMapping.userToDto(list.get(i)));
		}
		return listUserResp;

	}
   //Enregistrement d'un User
	public User saveUser(UserRequest userReq) {
		return userRepository.save(UserMapping.createEntiy(userReq));
	}
	
	//Recupération d'un seul User
	public UserResponse getUserById(Long Id) {
		User us=userRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("User avec l'ID " + Id + " non trouvé"));
		return UserMapping.userToDto(us);
	}
	
	//Suppression d'un user
	public void deleteUserById(Long Id) {
		User us=userRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("User avec l'ID " + Id + " non trouvé"));
		userRepository.delete(us);
		
	}
}