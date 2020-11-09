package com.example.larn.model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "aula")
public class Aula implements Serializable{
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "id")
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
	
	@Column(name = "data")
    private String data;
 
	@Column(name = "hora")
    private String hora;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "rel_aula_categoria", joinColumns = @JoinColumn(name = "aula_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private Set<Categoria> categorias;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "rel_aula_professor", joinColumns = @JoinColumn(name = "aula_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
	private Set<Teacher> teacher;
	
	private String email;
	
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Set<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Set<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(Set<Teacher> teacher) {
		this.teacher = teacher;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
