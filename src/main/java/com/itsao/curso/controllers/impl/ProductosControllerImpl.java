package com.itsao.curso.controllers.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.itsao.curso.controllers.ProductosController;
import com.itsao.curso.dtos.ProductosDto;
import com.itsao.curso.services.ProductosService;

@RestController
public class ProductosControllerImpl implements ProductosController{

    @Autowired
    ProductosService productosService;

    @Override
    public boolean guardarProducto(ProductosDto productosDto) {
        return this.productosService.guardar(productosDto);
    }

    @Override
    public List<ProductosDto> obtenerTodos() {
        return this.productosService.obtenerTodos();
    }

    
}
