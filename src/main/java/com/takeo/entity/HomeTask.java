package com.takeo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "home_tasks")
public class HomeTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String taskName;
	private String description;
	private boolean isComplete;
	
	public HomeTask(String taskName, String description, boolean isComplete) {
		this.taskName=taskName;
		this.description=description;
		this.isComplete=isComplete;
	}

}
