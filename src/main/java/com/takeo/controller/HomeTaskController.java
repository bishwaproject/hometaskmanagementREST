package com.takeo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.takeo.entity.HomeTask;
import com.takeo.repository.HomeTaskRepository;


/*
 GET : '/api/tasks' -> retrieve a list of all tasks
 GET : '/api/tasks/{id}' -> retrive a specific task by ID
 POST: '/api/tasks' -> create a new task
 PUT: '/api/tasks/{id}' -> update an existing task by ID
 PATCH: '/api/tasks/{id}' -> mark a task as complete by ID
 DELETE: '/api/tasks/{id}' -> delete a task by ID
 */
@RestController
@RequestMapping("/api/tasks")
public class HomeTaskController {
	@Autowired
	private HomeTaskRepository homeTaskRepository;
	
	
	 /*public HomeTaskController(HomeTaskRepository homeTaskRepository) {
		this.homeTaskRepository = homeTaskRepository;
	}*/
	
	@GetMapping
	public List<HomeTask> getAllTasks(){
		return homeTaskRepository.findAll();
	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<HomeTask> getTaskById(@PathVariable Long id){
		Optional<HomeTask> task = homeTaskRepository.findById(id);
		return task.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<HomeTask> createTask(@RequestBody HomeTask task){
		HomeTask savedTask = homeTaskRepository.save(task);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<HomeTask> updateTask(@PathVariable Long id, @RequestBody HomeTask updatedTask){
		Optional<HomeTask> existingTask = homeTaskRepository.findById(id);
		if(existingTask.isPresent()) {
			updatedTask.setId(id);
			HomeTask savedTask = homeTaskRepository.save(updatedTask);
			return ResponseEntity.ok(savedTask);
			
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PatchMapping("{/id}")
	public ResponseEntity<HomeTask> completeTask(@PathVariable Long id){
		Optional<HomeTask> existingTask = homeTaskRepository.findById(id);
		if(existingTask.isPresent()) {
			HomeTask task = existingTask.get();
			task.setComplete(true);
			HomeTask savedTask = homeTaskRepository.save(task);
			return ResponseEntity.ok(savedTask);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	/*
	@DeleteMapping("{/id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id){
		homeTaskRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	*/
	@DeleteMapping("{'/id}")
	public ResponseEntity<?> deleteTask(@PathVariable Long id) {
        Optional<HomeTask> deleteHomeTask = homeTaskRepository.findById(id);
        if (deleteHomeTask.isPresent()) {
            HomeTask homeTask = deleteHomeTask.get();
            homeTaskRepository.delete(homeTask);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
