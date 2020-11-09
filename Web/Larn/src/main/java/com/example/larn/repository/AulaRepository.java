package com.example.larn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.larn.model.Aula;
import com.example.larn.model.Student;
import com.example.larn.model.Teacher;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Integer> {
	
	Iterable<Aula> findByTeacher(Teacher teacher);
	
	Iterable<Aula> findByStudent(Student student);

}
