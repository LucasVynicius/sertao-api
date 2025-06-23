package br.com.sertaodata.sertaoapi.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum TypeUser {
    PRODUCER("PRODUTOR"),
    TECHNICIAN("TECNICO");

    private final String label;

    TypeUser(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    @JsonCreator
    public static TypeUser fromValue(String value) {
        return Arrays.stream(values())
                .filter(t -> t.name().equalsIgnoreCase(value) || t.label.equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Tipo de usuário inválido: " + value));
    }

}
