package com.leslie.Taskmanager.Entity;

import java.time.LocalDateTime;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;


@Entity
@Table(name = "tasks" , schema = "tasksmanager")
public class Tasks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="title", nullable=false , length=50)
	private String title;
	@Column(name="description", nullable=false )
	private String description;
	@Enumerated(EnumType.STRING)
	@Column(name="status", nullable=false)
	private Status status;
	@Column(name="created_at" )
	private LocalDateTime createdAt;
	@Column(name="updated_at" )
	private LocalDateTime updatedAt;
	@ManyToOne(fetch = FetchType.LAZY , optional = false)
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	
	//Constructeurs sans paramètres
	public Tasks() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Constructeurs avec paramètre

	public Tasks(Long id, String title, String description, Status status, LocalDateTime createdAt,
			LocalDateTime updatedAt, User user) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
	}

	//Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreated_at(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdated_at(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	//Persisiter les dates de mises à jour et création pour le faire de facon automatique dans la base de données
	@PrePersist
	public void Precreated() {
		this.createdAt=LocalDateTime.now();
	}
	@PreUpdate
    public void PreUpdated() {
    	this.updatedAt=LocalDateTime.now();
    }
	//Methods toString 
	@Override
	public String toString() {
		return "Tasks [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", user=" +  (user != null ? user.getId() : null) + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdAt, description, id, status, title, updatedAt, user);
	}
	

	//hashcode and Equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tasks other = (Tasks) obj;
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && status == other.status && Objects.equals(title, other.title)
				&& Objects.equals(updatedAt, other.updatedAt) && Objects.equals(user, other.user);
	}
	
	
	
	
	
	
	
}
