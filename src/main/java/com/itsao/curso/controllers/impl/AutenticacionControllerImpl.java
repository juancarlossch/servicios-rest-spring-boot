package com.itsao.curso.controllers.impl;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.itsao.curso.controllers.AutenticacionController;
import com.itsao.curso.dtos.UsuariosDto;
import com.itsao.curso.services.AutenticacionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AutenticacionControllerImpl implements AutenticacionController{
    
    @Autowired
    AutenticacionService autenticacionService;

    @Autowired
    ModelMapper modelMapper;
    
    @Override
    public String login(UsuariosDto usuariosDto) {
        return autenticacionService.signin(usuariosDto.getEmail(), usuariosDto.getPassword());
    }

    @Override
    public String refresh(HttpServletRequest req) {
        return autenticacionService.refresh(req.getRemoteUser());
    }

}
