package com.leslie.Taskmanager.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.leslie.Taskmanager.Dto.TasksRequestDto;
import com.leslie.Taskmanager.Entity.Tasks;
import com.leslie.Taskmanager.Exception.ResourceNotFoundException;
import com.leslie.Taskmanager.Service.TasksService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TasksController {

	private TasksService task ;

	public TasksController(TasksService task) {
		super();
		this.task = task;
	}
	
	/*** Méthodes CRUD de base ***/

	//Créer une tâche
		@PostMapping(path = "/ajout")
		public void CreerTache(@Valid @RequestBody TasksRequestDto tas) {
			task.CreateTask(tas);
		}

	//Récupérer une tâche par son id
		@GetMapping("/recupTache/{id}")
		public Tasks RecupTacheById( @PathVariable Long Id) {
			return task.getTasksById(Id);
		}

	//Récupérer toutes les tâches
		@GetMapping("/list")
		public List<Tasks> ListerTousTaches() {
			return task.getAllTasks();
		}

	//Mettre à jour une tâche
		@PutMapping("/maj/{id}")
		public Tasks MAJTask(@PathVariable Long id, Tasks ta) {
			return task.updateTask(id, ta).orElseThrow(()-> new ResourceNotFoundException("Impossible de modifier cette tâche car aucune entrée avec cet Id"+id));
		}

	//Supprimer une tâche
		@DeleteMapping("/delete/{id}")
		public void SuppTask(@PathVariable Long id) {
			task.deleteTask(id);
		}

		/*** Méthodes pour recherche / filtrage ***/

	//Récupérer toutes les tâches d’un utilisateur
	@GetMapping("/recupAll/{id}")
	public List<Tasks> recupTaskByUser(@PathVariable Long id){
		return task.getAllTaskByUser(id);
	}
}
