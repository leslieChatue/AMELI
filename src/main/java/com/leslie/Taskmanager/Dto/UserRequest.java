package com.leslie.Taskmanager.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequest {
	/*
	 * Ce que le client NE DOIT PAS contrôler → pas dans RequestDTO 🧠 Le client
	 * m’envoie des infos pour une création ou un update
	 */
	@NotBlank(message = "Le username ne doit pas être null")
	@Size( min =3 , max=20 , message="Votre username doit avoir entre 3 & 20 caracteres")
	private String username;
	@NotBlank(message = "L'adresse mail ne doit pas être null")
	@Size( min =10 , max=50 , message="Votre username doit avoir entre 3 & 20 caracteres")
	@Email(message="Entrez une adresse mail valide")
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRequest(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}

	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserResponse [ username=" + username + ", email=" + email + "]";
	}
}
