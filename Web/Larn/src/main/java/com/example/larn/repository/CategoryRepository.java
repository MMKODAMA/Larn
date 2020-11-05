package com.example.larn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.larn.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
