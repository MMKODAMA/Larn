package com.example.larn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.larn.model.Student;
import com.example.larn.model.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
	Teacher findByEmail(String email);

	Teacher findByCpf(String cpf);
}
