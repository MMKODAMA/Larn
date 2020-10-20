package com.example.larn.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.larn.model.Role;
import com.example.larn.model.Student;
import com.example.larn.model.Teacher;
import com.example.larn.model.User;
import com.example.larn.repository.RoleRepository;
import com.example.larn.repository.StudentRepository;
import com.example.larn.repository.TeacherRepository;

@Service
public class StudentServiceImp implements UserService{
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private TeacherRepository teacherRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Override
	public void saveStudent(Student user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setStatus("VERIFIED");
		Role userRole = roleRepo.findByRole("STUDENT_USER");
		user.setRoles(new HashSet<Role> (Arrays.asList(userRole)));
		studentRepo.save(user);
	}
	
	@Override
	public void saveTeacher(Teacher user) {
		System.out.println("SAVE TEACHER");
		user.setPassword(encoder.encode(user.getPassword()));
		user.setStatus("VERIFIED");
		Role userRole = roleRepo.findByRole("TEACHER_USER");
		user.setRoles(new HashSet<Role> (Arrays.asList(userRole)));
		teacherRepo.save(user);
	}

	@Override
	public boolean isUserAlredyPresent(User user) {
		User existingUser = studentRepo.findByEmail(user.getEmail());
		
		return existingUser != null ? true : false; 
	}

}
