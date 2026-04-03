package com.leslie.Taskmanager.Dto;

import com.leslie.Taskmanager.Entity.User;

//Classe qui mappe les données de l'user initial(dans la base de données) à celui de l'user finale (dans notre api) 
public class UserMapping {

	/* Ce que le client NE DOIT PAS contrôler → pas dans RequestDTO */
	// je mappe ma donnée que j'envoie(donc userrequest) en une donnée initiale(user
	// initial)
	public static User createEntiy(UserRequest urq) {
		User user = new User();
		user.setEmail(urq.getEmail());
		user.setUsername(urq.getUsername());
		return user;

	}

	// Je mappe ma donnée que je vais afficher en donnée formatée comme je
	// veux(userresponse)
	public static UserResponse userToDto(User user) {
		UserResponse uresp = new UserResponse();
		uresp.setEmail(user.getEmail());
		uresp.setUsername(user.getUsername());
		uresp.setId(user.getId());
		return uresp;
	}
}
