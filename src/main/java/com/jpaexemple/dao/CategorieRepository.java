package com.jpaexemple.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaexemple.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
