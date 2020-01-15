package DesignPattern.Decorator.Konkret;

public class Bacon extends Toppings{

    Bacon(Pizza toppings){
        super(toppings);
    }

    @Override
    public int getPreis() {
        return pizza.getPreis() + 2;
    }

    @Override
    public String getBezeichnung() {
        return pizza.getBezeichnung() + ", Bacon";
    }
}
