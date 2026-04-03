package com.leslie.Taskmanager.Dto;

public class UserResponse {
	// Ce que le client DOIT connaître → dans ResponseDTO
	// 🧠 “Je renvoie quelque chose au client” ---> GET POST PUT
	private Long id;
	private String username;
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public UserResponse(Long id, String username, String email) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
	}

	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserResponse [id=" + id + ", username=" + username + ", email=" + email + "]";
	}

}
