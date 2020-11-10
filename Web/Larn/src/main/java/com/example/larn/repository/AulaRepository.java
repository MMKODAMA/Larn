package com.example.larn.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.larn.model.Aula;
import com.example.larn.model.Student;
import com.example.larn.model.Teacher;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Integer> {

	Iterable<Aula> findByTeacher(Teacher teacher);

	Iterable<Aula> findByStudent(Student student);

	@Query(value = "SELECT * FROM aula a where a.materia = ?1 AND a.data BETWEEN ?2 AND ?3", nativeQuery = true)
	List<Aula> findByMateriaAndDateBetween(String materia, Date dataInicio, Date dataFim);

}
