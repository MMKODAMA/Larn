package com.example.larn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.larn.model.Student;
import com.example.larn.model.User;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	Student findByEmail(String email);

	Student findByCpf(String cpf);
}
