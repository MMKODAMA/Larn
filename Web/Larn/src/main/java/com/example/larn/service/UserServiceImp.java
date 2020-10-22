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
public class UserServiceImp implements UserService{
	
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
		user.setPassword(encoder.encode(user.getPassword()));
		user.setStatus("VERIFIED");
		Role userRole = roleRepo.findByRole("TEACHER_USER");
		user.setRoles(new HashSet<Role> (Arrays.asList(userRole)));
		teacherRepo.save(user);
	}

	@Override
	public void updateStudent(Student user) {
		Student student = studentRepo.findById(user.getId()).get();
		if(user.getPassword().isEmpty()) {
			user.setPassword(student.getPassword());
		} else {
			user.setPassword(encoder.encode(user.getPassword()));
		}
		user.setRoles(student.getRoles());
		user.setStatus("VERIFIED");
		studentRepo.save(user);
	}

	@Override
	public void updateTeacher(Teacher user) {
		Teacher student = teacherRepo.findById(user.getId()).get();
		if(user.getPassword().isEmpty()) {
			user.setPassword(student.getPassword());
		} else {
			user.setPassword(encoder.encode(user.getPassword()));
		}
		user.setRoles(student.getRoles());
		user.setStatus("VERIFIED");
		teacherRepo.save(user);
	}
	
	@Override
	public Student findStudentByID(int id) {
		return studentRepo.findById(id).get();
	}

	@Override
	public Teacher findTeacherByID(int id) {
		return teacherRepo.findById(id).get();
	}

	@Override
	public boolean isUserAlredyPresent(User user) {
		User existingUser = studentRepo.findByEmail(user.getEmail());
		
		return existingUser != null ? true : false; 
	}

}
