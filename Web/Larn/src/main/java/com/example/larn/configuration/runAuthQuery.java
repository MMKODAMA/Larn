package com.example.larn.configuration;

import java.util.List;

import javax.swing.text.html.parser.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.larn.model.Categoria;
import com.example.larn.model.Role;
import com.example.larn.repository.CategoriaRepository;
import com.example.larn.repository.RoleRepository;

@Component
public class runAuthQuery implements ApplicationRunner {

	    @Autowired
	    private RoleRepository repo;
	    
	    @Autowired
	    private CategoriaRepository catRepo;

	    @Override
	    public void run(ApplicationArguments args) throws Exception {

	    	List<Role>lista;
	    	lista=repo.findAll();
	    	boolean student=false;
	    	boolean teacher=false;
	    	for (Role role : lista) {
	    		if(role.getRole().equals("STUDENT_USER")) {
	    			student = true;
	    		}
	    		if(role.getRole().equals("TEACHER_USER")){
	    			teacher = true;
	    		}
			}
	    	if(!student) {
	    		 repo.save(new Role(1,"STUDENT_USER"));
	    	}
	    	if(!teacher) {
	    		 repo.save(new Role(2,"TEACHER_USER"));
	    	}
	    	
	    	List<Categoria> categorias;
	    	categorias = catRepo.findAll();
	    	if(categorias.isEmpty()) {
	    	catRepo.save(new Categoria(1,"Desenvolvimento"));
	    	}
	    }
	}
