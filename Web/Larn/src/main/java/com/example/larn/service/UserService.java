package com.example.larn.service;

import com.example.larn.model.Student;
import com.example.larn.model.Teacher;
import com.example.larn.model.User;

public interface UserService {

	public void saveStudent(Student user);

	public void saveTeacher(Teacher user);

	public void updateStudent(Student user);

	public void updateTeacher(Teacher user);

	public Student findStudentByID(int id);

	public Teacher findTeacherByID(int id);

	public boolean isUserAlredyPresent(User user);

	public boolean isCpfAlredyPresent(User user);
}
