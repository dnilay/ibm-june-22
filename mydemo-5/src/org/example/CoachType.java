package org.example;

public enum CoachType {

    REGULAR("Regular Coach"),
    FREELANCER("Freelance Coach");
    private String type;

    CoachType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
