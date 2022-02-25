package com.example.demo.services.impl;


import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.models.PaisModel;
import com.example.demo.repositories.PaisRepository;
import com.example.demo.services.api.PaisServiceAPI;;



@Service
public class PaisServiceImpl implements PaisServiceAPI
{
@Autowired
PaisRepository paisRepository;
@Override
public ArrayList<PaisModel> obtenerPaises()
{
	return (ArrayList<PaisModel>) paisRepository.findAll();
}


}
