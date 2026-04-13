package com.leslie.Taskmanager.Service;

import org.springframework.stereotype.Service;

import com.leslie.Taskmanager.ApiResponse.SearchResponse;
import com.leslie.Taskmanager.Dao.IUserDao;
import com.leslie.Taskmanager.Dao.UserDao;
import com.leslie.Taskmanager.Dto.UserResponse;
import com.leslie.Taskmanager.Entity.User;

@Service
public class UserService {

	private final IUserDao userRepository;
	private final UserDao userDao;

	public UserService(IUserDao userRepository ,UserDao userDao) {
		this.userRepository = userRepository;
		this.userDao = userDao;
	}

	
	//Methode pour APIRESPONSE
	 public SearchResponse<UserResponse> getAllUsers(String name ) {
		 String message =null;
		 Long Total =(long) userRepository.getUsersCriteria(name).size();
		 int limit =2;
		 boolean limited =userRepository.countUser() > limit;
		 if(limited) {
			 message = "Trop de resultats! Veuillez affinez votre recherche";
		 }
		 if(name.length()<2 || name.isEmpty()) {
			 message="Merci de saisir un nom avce plus d'un caracteres";
		 }
		 
			 
		 return new SearchResponse<UserResponse>(Total ,userRepository.getUsersCriteria(name) , message) ;
		  
	 }
	 
	
	// Methode simple
	/*
	 * public List<User> getAllUsers() { return userRepository.findAll(); }
	 * 
	 * 
	 */
	 public User saveUser(User user) { return userDao.save(user); }
	 
	
	

	// Méthode complexe
	//Affichage de tous les Users
	//On va refaire la même chose que l'on a fait pour la methode simple sauf que ctte fois ci on va l'adpater pour que cela correspondent
	// avec les dto que l'on a créé 
	/*public List<UserResponse> getAllUsers() {
		List<User> list = userRepository.findAll();
		List<UserResponse> listUserResp = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			listUserResp.add(UserMapping.userToDto(list.get(i)));
		}
		return listUserResp;

	}*/
   //Enregistrement d'un User
	/*public User saveUser(UserRequest userReq) {
		return userRepository.save(UserMapping.createEntiy(userReq));
	}
	*/
	/*//Recupération d'un seul User
	public UserResponse getUserById(Long Id) {
		User us=userRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("User avec l'ID " + Id + " non trouvé"));
		return UserMapping.userToDto(us);
	}
	
	//Suppression d'un user
	public void deleteUserById(Long Id) {
		User us=userRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("User avec l'ID " + Id + " non trouvé"));
		userRepository.delete(us);
		
	}*/
}