package com.itsao.curso.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsao.curso.dtos.ProductosDto;
import com.itsao.curso.entities.Productos;
import com.itsao.curso.repositories.ProductosRepository;
import com.itsao.curso.services.ProductosService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductosServiceImpl implements ProductosService{

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ProductosRepository productosRepository;

    @Override
    public boolean guardar(ProductosDto productosDto) {

        try {
            Productos productosGuardar = this.modelMapper.map(productosDto, Productos.class);
            this.productosRepository.save(productosGuardar);
            return true;
        } catch (Exception e) {
            log.error("Error al guardar el producto", e.getMessage());
        }
        return false;
    }

    @Override
    public List<ProductosDto> obtenerTodos() {
        List<ProductosDto> productosDtoList = new ArrayList<>();
        try {
            List<Productos> productosList = this.productosRepository.findAll();

            for (Productos productos : productosList) {
                ProductosDto productosDto = this.modelMapper.map(productos, ProductosDto.class);
                productosDtoList.add(productosDto);
            }
        } catch (Exception e) {
            log.error("Error al obtener todos los productos", e.getMessage());
        }
        return productosDtoList;
    }
    
    
}
