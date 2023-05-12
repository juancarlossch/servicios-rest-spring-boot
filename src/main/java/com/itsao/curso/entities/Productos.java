package com.itsao.curso.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Productos implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 255, message = "")
    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "precio", nullable = false)
    private Float precio;

    @Size(min = 1, max = 255, message = "")
    @Column(name = "presentacion", nullable = false)
    private String presentacion;

    @Size(min = 1, max = 255, message = "")
    @Column(name = "imagen", nullable = false)
    private String imagen;

}
