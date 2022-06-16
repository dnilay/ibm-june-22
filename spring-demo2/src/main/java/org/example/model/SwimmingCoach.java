package org.example.model;

import org.springframework.stereotype.Component;

@Component
public class SwimmingCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "practice 200 mtr today..";
    }
}
