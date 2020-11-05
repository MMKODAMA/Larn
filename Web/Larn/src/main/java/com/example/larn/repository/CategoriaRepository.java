package com.example.larn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.larn.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
