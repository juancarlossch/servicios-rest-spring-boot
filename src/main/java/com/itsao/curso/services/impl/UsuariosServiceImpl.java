package com.itsao.curso.services.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.itsao.curso.common.GenericResponsesComponent;
import com.itsao.curso.common.PasswordComponent;
import com.itsao.curso.dtos.UsuariosDto;
import com.itsao.curso.entities.Usuarios;
import com.itsao.curso.enums.ResponsesEnum;
import com.itsao.curso.enums.StatusEnum;
import com.itsao.curso.exceptions.CustomException;
import com.itsao.curso.repositories.UsuariosRepository;
import com.itsao.curso.responses.GenericResponse;
import com.itsao.curso.security.JwtTokenProvider;
import com.itsao.curso.services.UsuariosService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsuariosServiceImpl implements UsuariosService {

    @Value("${itsao.password.length}")
    private Integer passwordLength;

    private final JwtTokenProvider jwtTokenProvider;

    private final PasswordEncoder passwordEncoder;

    private GenericResponse genericResponse = new GenericResponse();

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    GenericResponsesComponent genericResponsesComponent;
    
    @Autowired
    PasswordComponent passwordComponent;

    @Autowired
    UsuariosRepository usuariosRepository;

    @Override
    public void delete(String name) {
        this.usuariosRepository.deleteByName(name);
    }

    @Override
    public UsuariosDto search(String name) {
        Usuarios user = this.usuariosRepository.findByName(name);
        if (user == null) {
            throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return this.modelMapper.map(user, UsuariosDto.class);
    }

    @Override
    public UsuariosDto whoami(HttpServletRequest req) {
        Usuarios user = this.usuariosRepository
                .findByEmail(this.jwtTokenProvider.getUsername(this.jwtTokenProvider.resolveToken(req)));
        return this.modelMapper.map(user, UsuariosDto.class);
    }

    @Override
    public GenericResponse save(UsuariosDto usuariosDto) {
        try {
            if (!this.usuariosRepository.existsByEmail(usuariosDto.getEmail())) {
                String passwordGenerated = this.passwordComponent.generateRandomPassword(passwordLength);
                Usuarios usuarios = this.modelMapper.map(usuariosDto, Usuarios.class);
                usuarios.setId(0L);
                usuarios.setPassword(passwordEncoder.encode(passwordGenerated));
                usuarios.setRegistrationDate(new Date());
                usuarios.setStatus(StatusEnum.ACTIVE);
                this.usuariosRepository.save(usuarios);

                genericResponse = this.genericResponsesComponent.getResponses(true,
                        ResponsesEnum.SUCCESSFUL_REGISTRATION);
            } else {
                genericResponse = this.genericResponsesComponent.getResponses(false,
                        ResponsesEnum.ERROR_WHEN_REGISTERING, "El correo electrónico ya se encuentra registrado");
            }

        } catch (Exception e) {
            log.error("Error save: {}", e.getMessage());
            genericResponse = this.genericResponsesComponent.getResponses(false, ResponsesEnum.ERROR_WHEN_REGISTERING);
        }
        return genericResponse;
    }

}
