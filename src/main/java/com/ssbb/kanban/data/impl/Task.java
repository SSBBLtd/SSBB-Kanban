package com.ssbb.kanban.data.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ssbb.kanban.data.Storable;

@Entity
@Table(name = "tasks")
public class Task implements Storable {

	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	@Column(name = "ID")
	private int ID;

	@ManyToOne
	@JoinColumn(name = "t_project_ID")
	private Project project;

	@OneToOne
	@JoinColumn(name = "t_user_ID")
	private User user;

	@OneToOne
	@JoinColumn(name = "t_status_ID")
	private Status status;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "date_created")
	private String dateCreated;

	@Column(name = "estimate")
	private String estimate;

	@Column(name = "time_remaining")
	private String timeRemaining;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getEstimate() {
		return estimate;
	}

	public void setEstimate(String estimate) {
		this.estimate = estimate;
	}

	public String getTimeRemaining() {
		return timeRemaining;
	}

	public void setTimeRemaining(String timeRemaining) {
		this.timeRemaining = timeRemaining;
	}

	@Override
	public int getId() {
		return ID;
	}

}
