package org.example;

public class SwimmingCoach implements ICoach{

    private IFortune fortuneService;
    public SwimmingCoach() {
        fortuneService=new SadFortuneService();
    }

    @Override
    public String getDailyWorkout() {
        return "practice swimming today";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getDailyFortune();
    }


}
