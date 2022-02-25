package com.example.demo.services.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.models.CiudadModel;
import com.example.demo.models.CiudadId;
import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.CiudadRepository;

import com.example.demo.services.api.CiudadServiceAPI;;
@Service
public class CiudadServiceImpl implements CiudadServiceAPI{
	@Autowired
	CiudadRepository ciudadRepository;
	@Override
	public ArrayList<CiudadModel> obtenerCiudades()
	{
		return (ArrayList<CiudadModel>) ciudadRepository.findAll();
	}
	@Override
	public CiudadModel saveCiudad(CiudadModel ciudadModel) {
		// TODO Auto-generated method stub
		return  ciudadRepository.save(ciudadModel);
	}
	@Override
	public Page<CiudadModel> getall(Pageable pageable) {
		// TODO Auto-generated method stub
		
		return ciudadRepository.findAll(pageable);
	
	}
	@Override
	public CiudadModel getId(CiudadId ciudadPK) throws UserExceptionDataFound {
		Optional<CiudadModel> result = ciudadRepository.findById(ciudadPK);
		if (result.isPresent())
			return result.get();
		throw new UserExceptionDataFound("No existe el Ciudad");
		
	}
	
	@Override
	public ArrayList<CiudadModel> obtenerCiudadesporPais(Long id)
	{
		return (ArrayList<CiudadModel>) ciudadRepository.buscarCiudadPorPais(id);
	}
	@Override
	public ArrayList<CiudadModel> obtenerCiudadesByPais(Long id)
	{
		return (ArrayList<CiudadModel>) ciudadRepository.findByCiudadIdId(id);
	}
}