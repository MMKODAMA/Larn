package com.example.larn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.larn.model.Aula;
import com.example.larn.repository.AulaRepository;

@Service
public class AulaServiceImp implements AulaService{

	@Autowired
	private AulaRepository aulaRepo;
	
	@Override
	public void saveAula(Aula aula) {
		this.aulaRepo.save(aula);		
	}

}
