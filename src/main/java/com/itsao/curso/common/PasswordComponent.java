package com.itsao.curso.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itsao.curso.enums.ResponsesEnum;
import com.itsao.curso.responses.GenericResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PasswordComponent {

    @Autowired
    GenericResponsesComponent genericResponsesComponent;

    private GenericResponse genericResponse = new GenericResponse();

    public String generateRandomPassword(int totalCharacters) {
        return RandomStringUtils.random(totalCharacters, true, true);
    }

    public GenericResponse validatePasswordComplexity(boolean requireUpperCase, boolean requireLowerCase,
            boolean requireNumber, boolean requireSpecialCharacter, int minimumCharacters, String password) {

        try {
            // Validando longitud de la contraseña
            String[] passwordArray = password.split("");
            if (passwordArray.length < minimumCharacters) {
                return this.genericResponsesComponent.getResponses(false, ResponsesEnum.INVALID_PASSWORD,
                        "La contraseña debe contener al menos " + minimumCharacters + " caracteres.");
            }

            // Validando que contenga letras mayusculas
            if (requireUpperCase) {
                genericResponse = this.validateUppercase(password);
                if (Boolean.FALSE.equals(genericResponse.getSuccess())) {
                    return genericResponse;
                }
            }

            // Validando que contenga letras minusculas
            if (requireLowerCase) {
                genericResponse = this.validateLowerCase(password);
                if (Boolean.FALSE.equals(genericResponse.getSuccess())) {
                    return genericResponse;
                }
            }

            // Validar que contenga un caracter numérico
            if (requireNumber) {
                genericResponse = this.validateNumber(password);
                if (Boolean.FALSE.equals(genericResponse.getSuccess())) {
                    return genericResponse;
                }
            }

            // Validar que contenga un caracter numérico
            if (requireSpecialCharacter) {
                genericResponse = this.validateSpecialCharacter(password);
                if (Boolean.FALSE.equals(genericResponse.getSuccess())) {
                    return genericResponse;
                }
            }
            return genericResponse;
        } catch (Exception e) {
            log.error("Error al validar la complejidad de la contraseña: {}", e.getMessage());
            return this.genericResponsesComponent.getResponses(false, ResponsesEnum.INVALID_PASSWORD,
                    "Ocurrió un error al validar la contraseña");
        }
    }

    private GenericResponse validateUppercase(String password) {
        genericResponse = this.genericResponsesComponent.getResponses(false, ResponsesEnum.REQUIRE_UPPERCASE);
        for (char caracter : password.toCharArray()) {
            if (Character.isUpperCase(caracter)) {
                genericResponse = this.genericResponsesComponent.getResponses(true, ResponsesEnum.VALID_PASSWORD);
            }
        }
        return genericResponse;
    }

    private GenericResponse validateLowerCase(String password) {
        genericResponse = this.genericResponsesComponent.getResponses(false, ResponsesEnum.REQUIRE_LOWERCASE);
        for (char caracter : password.toCharArray()) {
            if (Character.isLowerCase(caracter)) {
                genericResponse = this.genericResponsesComponent.getResponses(true, ResponsesEnum.VALID_PASSWORD);
            }
        }
        return genericResponse;
    }

    private GenericResponse validateNumber(String password) {
        genericResponse = this.genericResponsesComponent.getResponses(false, ResponsesEnum.REQUIRE_NUMBER);
        for (char caracter : password.toCharArray()) {
            if (Character.isDigit(caracter)) {
                genericResponse = this.genericResponsesComponent.getResponses(true, ResponsesEnum.VALID_PASSWORD);
            }
        }
        return genericResponse;
    }

    private GenericResponse validateSpecialCharacter(String password) {
        genericResponse = this.genericResponsesComponent.getResponses(false, ResponsesEnum.REQUIRE_SPECIAL_CHARACTER);
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(password);
        if (m.find()) {
            genericResponse = this.genericResponsesComponent.getResponses(true, ResponsesEnum.VALID_PASSWORD);
        }
        return genericResponse;
    }

}
