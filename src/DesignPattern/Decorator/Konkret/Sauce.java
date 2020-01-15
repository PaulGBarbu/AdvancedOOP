package DesignPattern.Decorator.Konkret;

public class Sauce extends Toppings{

    Sauce(Pizza toppings){
        super(toppings);
    }

    @Override
    public int getPreis() {
        return pizza.getPreis() + 3;
    }

    @Override
    public String getBezeichnung() {
        return pizza.getBezeichnung() + ", Sauce";
    }
}
