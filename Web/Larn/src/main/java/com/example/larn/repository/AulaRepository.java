package com.example.larn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.larn.model.Aula;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Integer> {

}
