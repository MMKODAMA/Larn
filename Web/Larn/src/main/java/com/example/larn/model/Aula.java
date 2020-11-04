package com.example.larn.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "aula")
public class Aula implements Serializable{
	
	@Id
	@GeneratedValue(strategy =  GenerationType.SEQUENCE)
	@Column(name = "aula_id")
	private int id;
	
	@Column(name = "materia")
	@NotEmpty(message = "Selecione a matéria!")
	private String materia;
	
	@Column(name = "tema")
	@NotEmpty(message = "Tema é um campo obrigatorio!")
	private String tema;
	
	@Column(name = "descricao")
	@NotEmpty(message = "Informe a descrição da aula!")
	private String descricao;
	
	@Column(name = "link")
	@NotEmpty(message = "Informe o link da video aula!")
	private String link;
	
	@Column(name = "preco")
	@NotEmpty(message = "Informe o preço da aula!")
	private String preco;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

}
