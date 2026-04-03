package com.leslie.Taskmanager.Dto;

import java.time.LocalDateTime;
import java.util.Objects;

import com.leslie.Taskmanager.Entity.Status;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TasksRequestDto {
	@NotBlank(message="Le titre ne doit pas être vide")
	@Size(min=3 , max=50 , message="Votre titre doit avoir une longueur comprise entre 3 et 20")
	private String title;
	@NotBlank(message="La description ne doit pas etre vide")
	@Size(min=3 , max=200 , message="La description")
	private String description;
	@NotNull(message="Le statut ne doit pas etre vide")
	private Status status;
	@FutureOrPresent(message = "La date de mise à jour doit être postérieure ou égale à la date d'aujourd'hui")
	private LocalDateTime updatedAt;
	@NotNull(message="Une tache doit toujours être attachée à un utilisateur")
	private Long user;
	
	public TasksRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TasksRequestDto(
			@NotBlank(message = "Le tritre ne doit pas être vide") @Size(min = 3, max = 50, message = "Votre titre doit avoir une longueur comprise entre 3 et 20") String title,
			@NotBlank(message = "La description ne doit pas etre vide") @Size(min = 3, max = 200, message = "La description") String description,
			@NotNull(message = "La status ne doit pas etre vide")  Status status,
			@FutureOrPresent(message = "La date de mise à jour doit être postérieure ou égale à la date d'aujourd'hui") LocalDateTime updatedAt,
			@NotNull(message = "Une tache doit toujours être attachée à un utilisateur") Long user) {
		super();
		this.title = title;
		this.description = description;
		this.status = status;
		this.updatedAt = updatedAt;
		this.user = user;
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

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "TasksRequestDto [title=" + title + ", description=" + description + ", status=" + status
				+ ", updatedAt=" + updatedAt + ", user=" + user + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, status, title, updatedAt, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TasksRequestDto other = (TasksRequestDto) obj;
		return Objects.equals(description, other.description) && status == other.status
				&& Objects.equals(title, other.title) && Objects.equals(updatedAt, other.updatedAt)
				&& Objects.equals(user, other.user);
	}
	
	
	
}
