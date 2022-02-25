package com.example.demo.services.impl;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepository;
import com.example.demo.services.api.UsuarioServiceAPI;


@Service
public class UsuarioServiceImpl implements UsuarioServiceAPI {
@Autowired
UsuarioRepository usuarioRepository;

public ArrayList<UsuarioModel> obtenerUsuarios()
{
	return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
}


public UsuarioModel guardarUsuario(UsuarioModel usuarioModel) {
	return usuarioRepository.save(usuarioModel);
	
	
}
public Optional<UsuarioModel> buscarPorId(Long id) {
	return usuarioRepository.findById(id);
}

public UsuarioModel getId(Long id) throws UserExceptionDataFound {
	Optional<UsuarioModel> result = usuarioRepository.findById(id);
	if (result.isPresent())
		return result.get();
	throw new UserExceptionDataFound("No existe el Usuario");
	
}
public void deleteId(Long id) throws UserExceptionDataFound {
	Long cantidad = usuarioRepository.countById(id);
	if (cantidad==null || cantidad==0)
		throw new UserExceptionDataFound("No existe el Usuario");
	else
	{
		usuarioRepository.deleteById(id);;
	}

	
}

public ArrayList<UsuarioModel> obtenerPorPrioridad(Integer prioridad)
{
	return usuarioRepository.findByPrioridad(prioridad);
}
@Override
public Page<UsuarioModel> getall(Pageable pageable) {
	// TODO Auto-generated method stub
	
	return usuarioRepository.findAll(pageable);
}

}
