package com.wanderlust.wanderlust.model.role;

public enum Role {

    Adm("Administrador"),
    User("Usuário");

    private final String description;

    Role(String description) {
        this.description = description;
    }

    public String getValue() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
