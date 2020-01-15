package DesignPattern.Decorator.Konkret;

public abstract class Toppings implements Pizza{

    protected Pizza pizza;

    Toppings(Pizza toppings){
        pizza = toppings;
    }
}
