package com.example.demo.todo;

public enum Priority {
    HIGH("high"),
    LOW("low"),
    MEDIUM("medium");

    private final String displayValue;

    Priority(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
