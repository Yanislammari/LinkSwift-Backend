package com.example.linkswiftbackend.model.enums;

public enum UserGrade {
    NO_BAC("SANS BAC"),
    BAC("BAC"),
    BAC_PLUS_1("BAC+1"),
    BAC_PLUS_2("BAC+2"),
    BAC_PLUS_3("BAC+3"),
    BAC_PLUS_5("BAC+5"),
    BAC_PLUS_7("BAC+7"),
    BAC_PLUS_8("BAC+8"),
    BAC_PLUS_9("BAC+9"),
    BAC_PLUS_12("BAC+12");

    private final String label;

    UserGrade(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
