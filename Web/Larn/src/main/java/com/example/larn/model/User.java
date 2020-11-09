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
	@Column(name = "id")
	private int id;
	
	@Column(name = "nome")
	@NotEmpty(message = "Nome é um campo obrigatorio!")
	private String name;
		
	@Column(name = "cpf", length = 11)
	@Size(min = 11, max = 11, message = "CPF invalido")
	@NotEmpty(message = "CPF é um campo obrigatorio!")
	private String cpf;
	
	@NotEmpty(message = "E-mail é um campo obrigatorio!")
	@Email(message = "E-mail invalido")
	private String email;
	
	@Column(name = "bio", length = 255)
	private String bio;
	
	@Column(name = "lates", length = 50)
	private String lates;
	
	@NotEmpty(message = "Senha é um campo obrigatorio!")
	@Length(min = 6, message = "A senha deve ter 6 ou mais caracteres")
	private String password;
	
	private String status;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "rel_cargo_usuario", joinColumns = @JoinColumn(name = "usuario_id	"), inverseJoinColumns = @JoinColumn(name = "cargo_id"))
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getLates() {
		return lates;
	}

	public void setLates(String lates) {
		this.lates = lates;
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
