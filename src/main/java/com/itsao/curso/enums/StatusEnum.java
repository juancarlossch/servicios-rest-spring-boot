package com.itsao.curso.enums;

public enum StatusEnum {

    INACTIVE("Inactive", "0"),
    ACTIVE("Active", "1");


    private final String name;
    private final String value;

    private StatusEnum(String name, String value) {
        this.name = name;
        this.value = value;
    }
    
    public String getName() {
        return name;
    }

    public int value() {
        return Integer.parseInt(value);
    } 

    public static StatusEnum fromName(String name) {
        for (StatusEnum d: StatusEnum.values()) {
            if (d.name.equalsIgnoreCase(name)) {
                return d;
            }
        }
        return null;
    }

    public static StatusEnum fromValue(String v) {
        for (StatusEnum c: StatusEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        return null;
    }
    
}
