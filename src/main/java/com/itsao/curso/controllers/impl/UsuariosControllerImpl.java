package com.itsao.curso.controllers.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.itsao.curso.controllers.UsuariosController;
import com.itsao.curso.dtos.UsuariosDto;
import com.itsao.curso.responses.GenericResponse;
import com.itsao.curso.services.UsuariosService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UsuariosControllerImpl implements UsuariosController{
    
    @Autowired
    UsuariosService usuariosService;



    @Override
    public GenericResponse save(UsuariosDto usuariosDto) {
        return this.usuariosService.save(usuariosDto);
    }

    @Override
    public UsuariosDto whoami(HttpServletRequest req) {
        return usuariosService.whoami(req);
    }
    
}
