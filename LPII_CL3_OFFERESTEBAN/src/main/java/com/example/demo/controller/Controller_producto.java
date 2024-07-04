package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Modelo_producto;
import com.example.demo.service.Servicio_producto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/api")
public class Controller_producto {
	@Autowired
	private Servicio_producto servprod;
	
	@GetMapping("/registrar")
	public String registrar(Model model) {
		model.addAttribute("producto", new Modelo_producto());
		return "registrar";
	}
	
	@PostMapping("/registrarproducto")
	public String registrarproducto(Model model, @ModelAttribute("producto") Modelo_producto producto) {
		servprod.guardar(producto);
		model.addAttribute("producto", new Modelo_producto());
		return "registrar";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
        List<Modelo_producto> productos = servprod.listar();
        model.addAttribute("productos", productos);
        return "listar";
    }
	
	@GetMapping("/editar/{id}")
    public String buscar(@PathVariable("id") Integer id, Model model) {
        Optional<Modelo_producto> producto = servprod.buscarPorId(id);
        if (producto.isPresent()) {
            model.addAttribute("producto", producto.get());
            return "editar";
        } else {
            model.addAttribute("message", "Producto no encontrado");
            return "redirect:/api/listar";
        }
    }
	
	
	@PostMapping("/editar")
    public String actualizar(@ModelAttribute("producto") Modelo_producto prod, Model model, RedirectAttributes redirectAttributes) {
        servprod.editar(prod);
        redirectAttributes.addFlashAttribute("message", "Producto actualizado con éxito");
        return "redirect:/api/listar";
    }
	
	
	@GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer id, Model model) {
        Optional<Modelo_producto> producto = servprod.buscarPorId(id);
        if (producto.isPresent()) {
        	servprod.eliminar(id);
            return "redirect:/api/listar";
        } else {
            model.addAttribute("message", "Producto no encontrado");
            return "redirect:/api/listar";
        }
    }
	
}
