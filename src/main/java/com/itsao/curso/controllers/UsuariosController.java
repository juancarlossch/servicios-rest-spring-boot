package com.itsao.curso.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itsao.curso.dtos.UsuariosDto;
import com.itsao.curso.responses.GenericResponse;

@RequestMapping("/usuarios")
public interface UsuariosController {

    @GetMapping(value = "/me")
    public UsuariosDto whoami(HttpServletRequest req);

    @PostMapping(value = "/")
    public GenericResponse save(@RequestBody UsuariosDto usuariosDto);

}
