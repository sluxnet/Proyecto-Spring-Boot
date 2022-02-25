package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.CiudadModel;
import com.example.demo.models.CiudadId;
import com.example.demo.models.PaisModel;
import com.example.demo.models.UsuarioModel;
import com.example.demo.services.impl.CiudadServiceImpl;
import com.example.demo.services.impl.UserExceptionDataFound;

@Controller
public class CiudadWebController  implements ErrorController {
	@Autowired
	CiudadServiceImpl ciudadServiceImpl;
	@SuppressWarnings("null")
	@RequestMapping("/ciudades")
	public String obtenerCiudades(@RequestParam Map<String, Object> params, Model model) {

		int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;
	
	
		
		int size = 20;

		PageRequest Pagerequest = PageRequest.of(page, size);

		Page<CiudadModel> pageCiudadModel = ciudadServiceImpl.getall(Pagerequest);

		int totalPage = pageCiudadModel.getTotalPages();
		if (totalPage > 0) {
			List<Integer> pages = new ArrayList<Integer>();
			for (int i = 1; i < (totalPage + 1); i++) {
				pages.add(i);
			}

			model.addAttribute("pages", pages);
		}
	
		model.addAttribute("listCitys", pageCiudadModel.getContent());
		model.addAttribute("titulo", "Prueba Spring");

		return "listadociudades";
	}

	@GetMapping("/ciudades/edit/{id}")
	public String editUsuario(@PathVariable("id") Long id, @PathVariable("idPais") Long idPais, Model model) {
		CiudadModel ciudad = null;
		try {
			CiudadId ciudadPK = new CiudadId();
			ciudadPK.setId(id);
			ciudadPK.setIdPais(idPais);
			ciudad = ciudadServiceImpl.getId(ciudadPK);
			model.addAttribute("ciudad", ciudad);
			model.addAttribute("pageTitle", "Editar");
			return "formulariociudad";

		} catch (UserExceptionDataFound e) {
			return "redirect:/ciudades";
		}
}
}