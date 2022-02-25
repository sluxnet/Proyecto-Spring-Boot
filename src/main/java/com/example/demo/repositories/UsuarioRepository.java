package com.example.demo.repositories;

import java.awt.print.Pageable;
import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.UsuarioModel;
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel,Long>{
public abstract ArrayList<UsuarioModel> findByPrioridad(Integer prioridad);
public Long countById(Long id) ;



}