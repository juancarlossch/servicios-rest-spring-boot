package com.itsao.curso.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.itsao.curso.exceptions.CustomException;
import com.itsao.curso.repositories.UsuariosRepository;
import com.itsao.curso.security.JwtTokenProvider;
import com.itsao.curso.services.AutenticacionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AutenticacionServiceImpl implements AutenticacionService{

    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    @Autowired
    UsuariosRepository usuariosRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public String refresh(String username) {
        return this.jwtTokenProvider.createToken(username);
    }

    @Override
    public String signin(String email, String password) {
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
            return this.jwtTokenProvider.createToken(email);
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
    
}
