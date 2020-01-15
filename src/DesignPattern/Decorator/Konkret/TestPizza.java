package DesignPattern.Decorator.Konkret;

import org.junit.Test;

public class TestPizza {
    @Test
    public void makeAPizza(){
        Pizza pizza1;
        pizza1 = new Salami(new Bacon(new Drinks()));


        System.out.println(pizza1.getBezeichnung());
    }
}
