package com.itsao.curso.services;

public interface AutenticacionService {

    public String signin(String email, String password);

    public String refresh(String username);
    
}
