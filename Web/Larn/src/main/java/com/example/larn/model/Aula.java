package com.example.larn.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "aula")
public class Aula{
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
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
	@NotNull(message = "Informe o preço da aula!")
	private double preco;
	
	@Column(name = "data", columnDefinition = "DATE")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;
 
	@Column(name = "hora")
	@DateTimeFormat(pattern = "HH:mm")
    private LocalDateTime hora;

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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalDateTime getHora() {
		return hora;
	}

	public void setHora(LocalDateTime hora) {
		this.hora = hora;
	}


	
	

}
