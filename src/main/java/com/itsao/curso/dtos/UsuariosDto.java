package com.itsao.curso.dtos;

import java.util.Date;

import com.itsao.curso.enums.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuariosDto {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private Date registrationDate;
    private StatusEnum status;

}
