package com.example.demo.services.api;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.models.CiudadModel;
import com.example.demo.models.CiudadId;
import com.example.demo.services.impl.UserExceptionDataFound;


public interface CiudadServiceAPI {
	public ArrayList<CiudadModel> obtenerCiudades();
	public CiudadModel saveCiudad(CiudadModel ciudadModel);
	Page<CiudadModel> getall(Pageable pageable);
	CiudadModel getId(CiudadId ciudadPK) throws UserExceptionDataFound ;
	public ArrayList<CiudadModel> obtenerCiudadesporPais(Long id);
	public ArrayList<CiudadModel> obtenerCiudadesByPais(Long id);
}
