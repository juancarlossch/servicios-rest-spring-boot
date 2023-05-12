package com.itsao.curso.services;

import java.util.List;

import com.itsao.curso.dtos.ProductosDto;

public interface ProductosService {
    
    /**
     * Metodo para guardar un nuevo producto
     * @param productosDto Objeto de tipo ProductosDto
     * @return true si se guardó el registro y false si no se guardó
     */
    public boolean guardar(ProductosDto productosDto);

    /**
     * Método para obtener todos los productos
     * @return Lista de tipo ProductosDto
     */
    public List<ProductosDto> obtenerTodos();

}
