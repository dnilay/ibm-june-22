package org.example;

public class SadFortuneService implements IFortune{

    @Override
    public String getDailyFortune() {
        return "today is sad day";
    }
}
