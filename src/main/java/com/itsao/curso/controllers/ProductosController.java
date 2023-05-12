package com.itsao.curso.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itsao.curso.dtos.ProductosDto;

@RequestMapping("/productos")
public interface ProductosController {

    @PostMapping(value = "/guardar")
    public boolean guardarProducto(@RequestBody ProductosDto productosDto);

    @GetMapping(value = "/obtener-todos")
    public List<ProductosDto> obtenerTodos();
    
}
