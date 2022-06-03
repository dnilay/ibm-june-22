package org.example;

public class CricketCoach implements ICoach{

    private String coachName;
    private String coachId;
    private CoachType coachType;

    private IFortune fortuneService;

    public CricketCoach(String coachName, String coachId, CoachType coachType) {
        this.coachName = coachName;
        this.coachId = coachId;
        this.coachType = coachType;
        fortuneService=new HappyFortuneService();
    }



    @Override
    public String getDailyFortune() {
        return null;
    }

    @Override
    public String getDailyWorkout() {
        return null;
    }
}
