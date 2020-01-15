package DesignPattern.Strategy;

public class Context {

    private Strategies s = new StrategyA(); // With A as default Strategy if execute is used before setStrategy

    public void setStragegy(Strategies strat){
        s = strat;
    }

    public void executeMethod(){
        s.method();
    }

}
