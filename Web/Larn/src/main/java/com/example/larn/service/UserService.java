package com.example.larn.service;

import com.example.larn.model.Student;
import com.example.larn.model.Teacher;
import com.example.larn.model.User;

public interface UserService {
	
	public void saveStudent(Student user);
	
	public void saveTeacher(Teacher user);
	
	public boolean isUserAlredyPresent(User user);
}
