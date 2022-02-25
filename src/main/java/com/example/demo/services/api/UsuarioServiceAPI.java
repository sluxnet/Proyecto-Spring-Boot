package com.example.demo.services.api;

 

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.models.UsuarioModel;
public interface UsuarioServiceAPI {
	Page<UsuarioModel> getall(Pageable pageable);
	

}
