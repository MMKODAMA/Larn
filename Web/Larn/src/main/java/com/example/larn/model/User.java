package com.example.larn.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@MappedSuperclass
public abstract class User implements Serializable {

	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE)
	@Column(name = "auth_user_id")
	private int id;
	
	@Column(name = "first_name")
	@NotEmpty(message = "Nome é um campo obrigatorio!")
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "user_cpf", length = 11)
	@Size(min = 11, max = 11, message = "CPF invalido")
	@NotEmpty(message = "CPF é um campo obrigatorio!")
	private String cpf;
	
	@NotEmpty(message = "E-mail é um campo obrigatorio!")
	@Email(message = "E-mail invalido")
	private String email;
	
	@NotEmpty(message = "Senha é um campo obrigatorio!")
	@Length(min = 6, message = "A senha deve ter 6 ou mais caracteres")
	private String password;
	
	private String status;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "auth_user_id"), inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
	private Set<Role> roles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
