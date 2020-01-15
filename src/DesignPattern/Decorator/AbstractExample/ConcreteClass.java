package DesignPattern.Decorator.AbstractExample;

/**
 * This class can live on its own and might get some decoration but not neccessarily
 */

public class ConcreteClass implements Main_Interface{
    ConcreteClass(){

    }

    @Override
    public String someMethod() {
        return " Hello from the ConcreteClass \n";
    }
}
