package com.wanderlust.wanderlust.model.role;

public enum Role {

    ADM("Admnistrador"),
    USER("Usuario");

    private final String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Role getEnumValue(String description) {
        return Role.valueOf(description);
    }

}
