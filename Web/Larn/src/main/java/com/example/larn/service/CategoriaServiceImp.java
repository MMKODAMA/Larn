package com.example.larn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.larn.model.Categoria;
import com.example.larn.repository.CategoriaRepository;

@Service
public class CategoriaServiceImp implements CategoriaService{

	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@Override
	public List<Categoria> getAllCategoria() {
		
		return categoriaRepo.findAll();
	}

}
