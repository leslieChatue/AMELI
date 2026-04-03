package com.leslie.Taskmanager.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.leslie.Taskmanager.Dto.TasksMapping;
import com.leslie.Taskmanager.Dto.TasksRequestDto;
import com.leslie.Taskmanager.Entity.Tasks;
import com.leslie.Taskmanager.Entity.User;
import com.leslie.Taskmanager.Exception.NullPointerEntityException;
import com.leslie.Taskmanager.Exception.ResourceNotFoundException;
import com.leslie.Taskmanager.Repository.TasksRepository;
import com.leslie.Taskmanager.Repository.UserRepository;

import jakarta.validation.Valid;

@Service
public class TasksService {

	private final TasksRepository taskDao;//toujours declarer en final car c'est une bonne pratique spring
	private final UserRepository userDao;

	public TasksService(TasksRepository taskDao ,UserRepository userDao) {
		super();
		this.taskDao = taskDao;
		this.userDao = userDao;
	}

	/*** Méthodes CRUD de base ***/

//Créer une tâche
	public ResponseEntity<String> CreateTask(@Valid @RequestBody TasksRequestDto request ) {

		User u = userDao.findById(request.getUser()).orElseThrow(()-> new ResourceNotFoundException("Aucun user trouvé avec l'id "+request.getUser()));
		Tasks t=TasksMapping.requestToTasks(request);
		t.setUser(u);
		taskDao.save(t);
		return   ResponseEntity.status(HttpStatus.CREATED).body("Création de votre tâche réussie");
	}

	
//Récupérer une tâche par son id
	public Tasks getTasksById(Long Id) {
		
			return	taskDao.findById(Id).orElseThrow(()-> new ResourceNotFoundException("Aucune tâche trouvée avec l'id"+Id+" dans la table"));
	}

//Récupérer toutes les tâches
	public List<Tasks> getAllTasks() {
		List<Tasks> li = taskDao.findAll();
				if(li.isEmpty() ) {
					throw new NullPointerEntityException("Vous n'avez pas de resultats dans la table");
				}
			return li;
	}

//Mettre à jour une tâche

	public Optional<Tasks> updateTask(Long id, Tasks ta) {
		return taskDao.findById(id).map(task -> {
			task.setDescription(ta.getDescription());
			task.setTitle(ta.getTitle());
			task.setStatus(ta.getStatus());
			return taskDao.save(task);
		});
	}

//Supprimer une tâche

	public void deleteTask(Long id) {
		Optional<Tasks> t= taskDao.findById(id);
		taskDao.delete(t.get());
	}

	/*** Méthodes pour recherche / filtrage ***/

//Récupérer toutes les tâches d’un utilisateur
public List<Tasks> getAllTaskByUser(Long id){
	return taskDao.findAll().stream().filter(ta -> ta.getUser().getId().equals(id)).collect(Collectors.toList());
}
//Récupérer toutes les tâches par statut (en cours, done, pending)

//Récupérer toutes les tâches d’un utilisateur selon le statut

	/*** Méthodes pratiques / avancées ***/

//Marquer une tâche comme “DONE”

//Récupérer les tâches créées entre deux dates

//Récupérer les tâches triées par date (ascendante ou descendante)

}
