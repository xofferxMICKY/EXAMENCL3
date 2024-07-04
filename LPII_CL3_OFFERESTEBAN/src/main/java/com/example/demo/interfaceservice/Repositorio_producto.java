package com.example.demo.interfaceservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Modelo_producto;

public interface Repositorio_producto extends JpaRepository<Modelo_producto, Integer> {

}
