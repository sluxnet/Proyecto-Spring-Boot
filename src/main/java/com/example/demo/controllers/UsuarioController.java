package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.UsuarioModel;
import com.example.demo.services.impl.UsuarioServiceImpl;

@RestController

@RequestMapping("/usuario")
public class UsuarioController {
@Autowired
UsuarioServiceImpl usuarioService;
@GetMapping
public ArrayList<UsuarioModel> obtenerUsuarios(){
	return usuarioService.obtenerUsuarios();

	}
@GetMapping(path = "/{id}")
public Optional<UsuarioModel> buscarPorId(@PathVariable Long id) {
	return usuarioService.buscarPorId(id);
}
@GetMapping(path = "/query")
public ArrayList<UsuarioModel> obtenerUsuariosPorPrioridad(@RequestParam Integer prioridad){
	return usuarioService.obtenerPorPrioridad(prioridad);

	}
@PostMapping(path = "/save")
public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuarioModel) {
	return usuarioService.guardarUsuario(usuarioModel);
	
}
}

