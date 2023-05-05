package com.itsao.curso.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itsao.curso.dtos.UsuariosDto;

@RequestMapping("/autenticacion")
public interface AutenticacionController {
    
    @PostMapping("/signin")
    public String login(@RequestBody UsuariosDto usuariosDto);

    @GetMapping("/refresh")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public String refresh(HttpServletRequest req);
    
}
