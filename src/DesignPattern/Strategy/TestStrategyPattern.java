package DesignPattern.Strategy;

import org.junit.Test;

public class TestStrategyPattern {
    @Test
    public void changeStrategy(){
        Context c = new Context();

        c.executeMethod();

        c.setStragegy(new StrategyB());

        c.executeMethod();
    }
}
