package br.com.sertaodata.sertaoapi.enums;

public enum TypeUser {
    PRODUCER("PRODUTOR"),
    TECHNICIAN("TECNICO");

    private final String label;

    TypeUser(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
