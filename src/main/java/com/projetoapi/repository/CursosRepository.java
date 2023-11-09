package com.projetoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoapi.entities.Cursos;

public interface CursosRepository extends JpaRepository<Cursos, Long> {

}