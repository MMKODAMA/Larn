package com.example.larn.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categoria")
public class Categoria implements Serializable{

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "nome")
	private String categoria;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public Categoria (int id, String categoria) {
		this.id=id;
		this.categoria=categoria;
	}
	
	public Categoria() {
		
	}
	
	
	
}
