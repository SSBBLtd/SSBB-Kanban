package com.ssbb.kanban.data.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ssbb.kanban.data.Storable;

@Entity
@Table(name = "projects")
public class Project implements Storable {

	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	@Column(name = "ID")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@OneToMany
	@JoinTable(name = "user_project", joinColumns = { @JoinColumn(name = "project_ID", referencedColumnName = "ID")}, inverseJoinColumns = { @JoinColumn(name = "user_ID", referencedColumnName = "ID")})
	private List<User> userList;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
	private List<Task> tasks;
	

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<User> getUserList() {
		if(this.userList == null){
			userList = new ArrayList<User>();
		}
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
