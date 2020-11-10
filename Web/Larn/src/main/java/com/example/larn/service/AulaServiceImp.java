package com.example.larn.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.larn.model.Aula;
import com.example.larn.model.Categoria;
import com.example.larn.model.Teacher;
import com.example.larn.repository.AulaRepository;
import com.example.larn.repository.CategoriaRepository;
import com.example.larn.repository.TeacherRepository;

@Service
public class AulaServiceImp implements AulaService {

	@Autowired
	private AulaRepository aulaRepo;

	@Autowired
	private CategoriaRepository catRepo;

	@Autowired
	private TeacherRepository teacherRepo;;

	@Override
	public void saveAula(Aula aula) {
		Categoria c = catRepo.findByCategoria(aula.getMateria());
		aula.setCategorias(new HashSet<Categoria>(Arrays.asList(c)));
		Teacher t = teacherRepo.findByEmail(aula.getEmail());
		aula.setTeacher(new HashSet<Teacher>(Arrays.asList(t)));
		aulaRepo.save(aula);
	}
}
