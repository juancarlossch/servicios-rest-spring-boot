package com.itsao.curso.common;

import org.springframework.stereotype.Component;

import com.itsao.curso.enums.ResponsesEnum;
import com.itsao.curso.responses.GenericResponse;

@Component
public class GenericResponsesComponent {

    private GenericResponse genericResponse = new GenericResponse();
    
    public GenericResponse getResponses(boolean success,ResponsesEnum responsesEnum){
        if(!success){
            genericResponse.setErrorCode(responsesEnum.value());
        }
        genericResponse.setSuccess(success);
        genericResponse.setDescription(responsesEnum.getName());
        return genericResponse;
    }

    public GenericResponse getResponses(boolean success,ResponsesEnum responsesEnum,String description){
        genericResponse = this.getResponses(success, responsesEnum);
        genericResponse.setDescription(description);
        return genericResponse;
    }
}
