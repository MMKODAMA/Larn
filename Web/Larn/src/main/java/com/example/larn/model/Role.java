package com.example.larn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auth_role")
public class Role {
	
	@Id
	@Column(name = "auth_role_id")
	private int id;
	
	@Column(name = "role_name")
	private String role;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public Role (int id, String role) {
		
		this.id=id;
		this.role=role;
		
	}
	public Role() {
		
	}
	
	
}
