package com.leslie.Taskmanager.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.leslie.Taskmanager.Dto.UserRequest;
import com.leslie.Taskmanager.Dto.UserResponse;
import com.leslie.Taskmanager.Entity.User;
import com.leslie.Taskmanager.Service.UserService;
import jakarta.validation.Valid;
import java.util.List;

@RestController //
//Rest c'est pour préciser que c'est un controller qui travaille avec des API REST
@RequestMapping("/users") // Le lien de base pour nos URL
public class UserController {

	//Une API SERIEUSE ne renvoie JAMAIS directement l'intégralites des propriétes  de ses entités JPA
	
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}
	// Methodologie simple
	/*
	 * @GetMapping //Verbe Http get
	 *  public List<User> getUsers() {
	 *   return userService.getAllUsers();
	 *  }
	 * 
	 * @PostMapping //Verbe Http post
	 *  public User createUser(@RequestBody User user)
	 * { //RequestBody indique a java que les données qui vont être fournies seront
	 * au fichier Json
	 *  return userService.saveUser(user); }
	 */

	// Methodologie complexe pour faire des recherches d'API propres

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE , path="/listUsers")//Produces indique le type de données que la methode retournera
	@ResponseStatus(code = HttpStatus.ACCEPTED)//On precise le code de retour de la methode (Ce sont les bonnes pratiques de code/clean code)
	public List<UserResponse> getUsersDto() {//On utilise un DTO  a la place d'un objet simple pour controler les données qui seront affichées à l'utilisateur lors de sa recherche
		return userService.getAllUsers();
	}
	
	@GetMapping(path ="/oneUser/{id}" , produces =MediaType.APPLICATION_JSON_VALUE ) // C'est possible de combiner @path et produces dans le getMapping???
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public UserResponse getUsersDtoById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@PostMapping(path="/saveUser")
	@ResponseStatus(HttpStatus.CREATED)
	public User createUserDto( @Valid @RequestBody UserRequest urq) {
		return userService.saveUser(urq);
	}
	
	@DeleteMapping(path="/suppUser/{id}", produces =MediaType.APPLICATION_JSON_VALUE )
	@ResponseStatus(code = HttpStatus.GONE)
	public void deleteUserDto(@PathVariable Long id) {
		 userService.deleteUserById(id);
	}

}
