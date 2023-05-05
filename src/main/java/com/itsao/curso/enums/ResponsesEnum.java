package com.itsao.curso.enums;

public enum ResponsesEnum {

    ERROR_WHEN_REGISTERING("Ocurrió un error al realizar el registro", "0"),
    UPDATE_ERROR("Ocurrió un error al actualizar el registro", "1"),
    ERROR_WHEN_QUERYING("Ocurrió un error al realizar la consulta", "2"),
    REGISTRATION_NOT_FOUND("No existe el registro", "3"),
    SUCCESSFUL_REGISTRATION("Registro exitoso", "4"),
    SUCCESSFUL_UPDATE("Registro actualizado", "5"),
    CUSTOMER_NOT_FOUND("Cliente no registrado", "6"),
    ERROR_SENDING_EMAIL("Error al enviar el correo electrónico", "7"),
    EMAIL_SENT("Correo electrónico enviado", "8"),
    REQUIRE_UPPERCASE("La contraseña debe contener al menos una letra mayúscula", "9"),
    REQUIRE_LOWERCASE("La contraseña debe contener al menos una letra minúscula", "10"),
    REQUIRE_NUMBER("La contraseña debe contener al menos un número","11"),
    REQUIRE_SPECIAL_CHARACTER("La contraseña debe contener al menos un carácter especial","12"),
    VALID_PASSWORD("Contraseña correcta","13"),
    INVALID_PASSWORD("Contraseña incorrecta","14");

    private final String name;
    private final String value;

    private ResponsesEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }
    
    public String getName() {
        return name;
    }

    public int value() {
        return Integer.parseInt(value);
    } 

    public static ResponsesEnum fromName(String name) {
        for (ResponsesEnum d: ResponsesEnum.values()) {
            if (d.name.equalsIgnoreCase(name)) {
                return d;
            }
        }
        return null;
    }

    public static ResponsesEnum fromValue(String v) {
        for (ResponsesEnum c: ResponsesEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        return null;
    }
}
