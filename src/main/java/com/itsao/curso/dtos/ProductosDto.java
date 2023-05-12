package com.itsao.curso.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductosDto {

    private Long id;
    private String nombre;
    private Float precio;
    private String presentacion;
    private String imagen;

}
