package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.UsuarioModel;

import com.example.demo.services.impl.UsuarioServiceImpl;
@CrossOrigin(origins = "http://localhost:4200/",maxAge = 3600)
@RestController
public class UserController {
@Autowired
UsuarioServiceImpl usuarioService;

@RequestMapping("/usuarios/listado")
public List<UsuarioModel> obtenerUsuarios() {
return usuarioService.obtenerUsuarios() ;

}

@PostMapping("/usuarios/save")
public UsuarioModel grabarUsuarios(@RequestBody  UsuarioModel usuarioModel) {
return usuarioService.guardarUsuario(usuarioModel) ;

}

@GetMapping("/usuarios/getusuario/{id}")
public Optional<UsuarioModel> editUsuario(@PathVariable("id") Long id) {

return usuarioService.buscarPorId(id);
}
//
//@DeleteMapping("/usuarios/delete/{id}")
//public void deleteUsuario(@PathVariable("id") Long id) {
//usuarioService.delete(id);
//}
}

