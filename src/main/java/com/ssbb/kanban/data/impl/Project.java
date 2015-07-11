package com.ssbb.kanban.data.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

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

	//@ManyToMany(cascade = CascadeType.PERSIST)
	//@JoinTable(name = "user_project_role", joinColumns = { @JoinColumn(name = "upr_project_ID", referencedColumnName = "ID")}, inverseJoinColumns = { @JoinColumn(name = "upr_user_ID", referencedColumnName = "ID")})
	@Transient
	private List<User> userList = new ArrayList<User>();

	//@ManyToMany(cascade = CascadeType.PERSIST)
	//@JoinTable(name = "user_project_role", joinColumns = { @JoinColumn(name = "upr_project_ID", referencedColumnName = "ID")}, inverseJoinColumns = { @JoinColumn(name = "upr_user_ID", referencedColumnName = "ID")})
	public List<User> getUserList() {
		// if list has not been set, then create a new list
		//if (null == this.userList) {
			//setUserList(new ArrayList<User>());
		//}
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
