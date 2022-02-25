package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.CiudadModel;
import com.example.demo.models.UsuarioModel;
import com.example.demo.services.impl.CiudadServiceImpl;
import com.example.demo.services.impl.UserExceptionDataFound;


@RestController
public class CiudadController {
	@Autowired
	CiudadServiceImpl ciudadServiceImpl;
	
	
	
	@PostMapping("/ciudad/save")
	public CiudadModel salvarCiudad(@RequestBody CiudadModel ciudadModel) {
		ciudadServiceImpl.saveCiudad(ciudadModel);
		
		return ciudadServiceImpl.saveCiudad(ciudadModel);

	}
	@PostMapping("/ciudad/savemvc")
	public String salvarUsuario(CiudadModel ciudadModel, RedirectAttributes ra) throws Exception, UserExceptionDataFound {
		ciudadServiceImpl.saveCiudad(ciudadModel);
		try {
			ra.addFlashAttribute("message", "Grabado con Exito!!!");

		} catch (DataAccessException e) {
			ra.addFlashAttribute("message", e.getMessage());

		}

		return "redirect:/ciudades";

	}
}