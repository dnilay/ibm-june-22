package org.example;

public class HappyFortuneService implements IFortune{

    @Override
    public String getDailyFortune() {
        return "today is lucky day";
    }
}
