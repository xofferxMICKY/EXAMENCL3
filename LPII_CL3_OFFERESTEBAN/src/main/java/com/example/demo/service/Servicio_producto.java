package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.Interfaz_producto;
import com.example.demo.interfaceservice.Repositorio_producto;
import com.example.demo.modelo.Modelo_producto;

@Service
public class Servicio_producto implements Interfaz_producto {
	@Autowired
    private Repositorio_producto reprod;
	
	
	@Override
	public Modelo_producto guardar(Modelo_producto prd) {
		
		return reprod.save(prd);
	}

	@Override
	public void eliminar(Integer id) {
		reprod.deleteById(id);	
	}

	@Override
	public List<Modelo_producto> listar() {
		return reprod.findAll();
	}

	@Override
	public Optional<Modelo_producto> buscarPorId(Integer id) {
		return reprod.findById(id);
	}

	@Override
	public Modelo_producto editar(Modelo_producto prd) {
		return reprod.save(prd);
	}

}
