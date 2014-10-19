package com.ssbb.kanban.data.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ssbb.kanban.data.Storable;

@Entity
@Table(name = "Role")
public class Role implements Storable {

	@Id
	@GenericGenerator(name = "gen", strategy = "increment")
	@GeneratedValue(generator = "gen")
	@Column(name = "ID")
	private int id;

	@Column(name = "TYPE")
	private String type;

	public int getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
