package DesignPattern.Decorator.AbstractExample;

public class Wrapper_B extends AbstractDecorator{

    Wrapper_B(Main_Interface mi){
        super(mi);
    }

    @Override
    public String someMethod() {
        return someObj.someMethod() + " Hello from Wrapper B \n";
    }
}
