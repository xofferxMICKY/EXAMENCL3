package com.example.demo.interfaces;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Modelo_producto;

public interface Interfaz_producto {
	 Modelo_producto guardar(Modelo_producto prd);
	 void eliminar(Integer id);
	 List<Modelo_producto> listar();
	 Optional<Modelo_producto> buscarPorId(Integer id);
	 Modelo_producto editar(Modelo_producto prd);
}

