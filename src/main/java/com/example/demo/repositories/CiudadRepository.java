package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.models.CiudadModel;
import com.example.demo.models.CiudadId;



@Repository
public interface CiudadRepository extends JpaRepository<CiudadModel,CiudadId>{
	List<CiudadModel>  findByCiudadIdId(Long idPais);
	@Query(value="select id, id_pais, descripcion, activo from ciudad where id_Pais = ?",nativeQuery = true)
	List<CiudadModel> buscarCiudadPorPais(Long id);
	
}