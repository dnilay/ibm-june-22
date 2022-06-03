package org.example;

import java.util.UUID;

public class App {

    public static void main(String[] args)
    {
        ICoach coach= new CricketCoach("John Doe",UUID.randomUUID().toString(),CoachType.REGULAR);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        coach=new SwimmingCoach();

    }
}
