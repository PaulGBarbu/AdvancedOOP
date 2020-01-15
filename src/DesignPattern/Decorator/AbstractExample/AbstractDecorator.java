package DesignPattern.Decorator.AbstractExample;

public abstract class AbstractDecorator implements Main_Interface {
    Main_Interface someObj; // Decorator Methods will be executed on this Object

    AbstractDecorator(Main_Interface mi){
        someObj = mi;
    }
}
