package com.itsao.curso.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor 
public class GenericResponse {
    
    private Boolean success;
    private Integer errorCode;
    private String description;

}
