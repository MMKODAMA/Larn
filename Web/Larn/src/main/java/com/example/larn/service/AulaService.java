package com.example.larn.service;

import java.util.List;

import com.example.larn.model.Aula;
import com.example.larn.model.Categoria;
import com.example.larn.model.Student;

public interface AulaService {

	public void saveAula(Aula aula);

	public void saveCompra(Aula aula, Student t);

}
