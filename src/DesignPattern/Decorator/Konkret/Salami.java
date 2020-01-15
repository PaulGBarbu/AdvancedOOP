package DesignPattern.Decorator.Konkret;

public class Salami extends Toppings{

    Salami(Pizza toppings){
        super(toppings);
    }

    @Override
    public int getPreis() {
        return pizza.getPreis() + 1;
    }

    @Override
    public String getBezeichnung() {
        return pizza.getBezeichnung() + " , Salami";
    }
}
