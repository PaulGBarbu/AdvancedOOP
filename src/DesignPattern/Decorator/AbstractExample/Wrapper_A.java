package DesignPattern.Decorator.AbstractExample;

public class Wrapper_A extends AbstractDecorator{

    Wrapper_A(Main_Interface mi){
        super(mi);
    }

    @Override
    public String someMethod() {
        return someObj.someMethod() + " Hello from Wrapper A \n";
    }
}
