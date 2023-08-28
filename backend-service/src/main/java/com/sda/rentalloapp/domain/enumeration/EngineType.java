package com.sda.rentalloapp.domain.enumeration;

public enum EngineType {
    ELECTRIC_MOTOR ("Electric motor"),
    V12 ("V12"),
    V10 ("V10"),
    V8 ("V8"),
    V6 ("V6"),
    R4 ("R4");

    private final String description;
    EngineType(String description) {
        this.description = description;
    }
    public String description() {
        return description;
    }
}
