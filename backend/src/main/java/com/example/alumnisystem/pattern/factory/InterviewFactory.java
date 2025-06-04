// InterviewFactory.java
package com.example.alumnisystem.pattern.factory;

public class InterviewFactory {
    public static Interview getInterview(String type) {
        return switch (type.toLowerCase()) {
            case "technical" -> new TechnicalInterview();
            case "hr" -> new HRInterview();
            default -> throw new IllegalArgumentException("Unknown type");
        };
    }
}
