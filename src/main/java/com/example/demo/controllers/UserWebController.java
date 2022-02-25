package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.CiudadModel;
import com.example.demo.models.PaisModel;
import com.example.demo.models.UsuarioModel;
import com.example.demo.services.impl.CiudadServiceImpl;
import com.example.demo.services.impl.PaisServiceImpl;
import com.example.demo.services.impl.UserExceptionDataFound;
import com.example.demo.services.impl.UsuarioServiceImpl;

@Controller
public class UserWebController implements ErrorController {
	@Autowired
	UsuarioServiceImpl usuarioService;
	@Autowired
	PaisServiceImpl paisService;
	@Autowired
	CiudadServiceImpl ciudadService;

	@RequestMapping("/users2")
	public String obtenerUsuarios2(Model model) {
		List<UsuarioModel> listUsers = usuarioService.obtenerUsuarios();
		model.addAttribute("listUsers", listUsers);
		model.addAttribute("titulo", "Prueba Spring");
		return "listadousuarios";

	}

	@SuppressWarnings("null")
	@RequestMapping("/users")
	public String obtenerUsuarios(@RequestParam Map<String, Object> params, Model model) {

		int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;
	
	
		
		int size = 2;

		PageRequest Pagerequest = PageRequest.of(page, size);

		Page<UsuarioModel> pageUsuarioModel = usuarioService.getall(Pagerequest);

		int totalPage = pageUsuarioModel.getTotalPages();
		if (totalPage > 0) {
			List<Integer> pages = new ArrayList<Integer>();
			for (int i = 1; i < (totalPage + 1); i++) {
				pages.add(i);
			}

			model.addAttribute("pages", pages);
		}
	
		model.addAttribute("listUsers", pageUsuarioModel.getContent());
		model.addAttribute("titulo", "Prueba Spring");

		return "listadousuarios";
	}

	@RequestMapping("/newuser")
	public String nuevoUsuario(Model model) {
		model.addAttribute("user", new UsuarioModel());
		model.addAttribute("pageTitle", "Nuevo");
		return "formulariousuario";

	}

	@PostMapping("/saveuser")
	public String salvarUsuario(UsuarioModel user, RedirectAttributes ra) throws Exception, UserExceptionDataFound {
		usuarioService.guardarUsuario(user);
		try {
			ra.addFlashAttribute("message", "Grabado con Exito!!!");

		} catch (DataAccessException e) {
			ra.addFlashAttribute("message", e.getMessage());

		}

		return "redirect:/users";

	}

	@GetMapping("/users/edit/{id}")
	public String editUsuario(@PathVariable("id") Long id, Model model) {
		UsuarioModel usuario = null;
		try {
			usuario = usuarioService.getId(id);
			List<PaisModel> listPaises = paisService.obtenerPaises();
			model.addAttribute("listPaises", listPaises);
			model.addAttribute("user", usuario);
			model.addAttribute("pageTitle", "Editar");
			return "formulariousuario";

		} catch (UserExceptionDataFound e) {
			return "redirect:/users";
		}

	}

	@GetMapping("/users/delete/{id}")
	public String deleteUsuario(@PathVariable("id") Long id, RedirectAttributes ra) {
		try {
			usuarioService.deleteId(id);
			ra.addFlashAttribute("message", "Eliminado con Exito!!!, ID=" + id);
		} catch (UserExceptionDataFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/users";

	}
	@RequestMapping(value = "/users/refreshItem", method = RequestMethod.GET)
	public String refreshItem(@RequestParam("idPais") Long idPais, Model model) {
	    List<CiudadModel> itemList = ciudadService.obtenerCiudadesByPais(idPais);

	    model.addAttribute("itemList", itemList);

	    return "formulariousuario :: #item";
	}

}