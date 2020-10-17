package com.example.larn.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.larn.model.Role;
import com.example.larn.model.Student;
import com.example.larn.model.User;
import com.example.larn.repository.RoleRepository;
import com.example.larn.repository.StudentRepository;

@Service
public class StudentServiceImp implements UserService{
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Override
	public void saveUser(User user) {
		Student student = (Student) user;
		student.setPassword(encoder.encode(student.getPassword()));
		student.setStatus("VERIFIED");
		Role userRole = roleRepo.findByRole("STUDENT_USER");
		student.setRoles(new HashSet<Role> (Arrays.asList(userRole)));
		studentRepo.save(student);
	}

	@Override
	public boolean isUserAlredyPresent(User user) {
		User existingUser = studentRepo.findByEmail(user.getEmail());
		
		return existingUser != null ? true : false; 
	}

}
