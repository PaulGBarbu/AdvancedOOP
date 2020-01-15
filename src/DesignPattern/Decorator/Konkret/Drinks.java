package DesignPattern.Decorator.Konkret;

public class Drinks implements Pizza{

    @Override
    public int getPreis() {
        return 5;
    }

    @Override
    public String getBezeichnung() {
        return "Cola";
    }
}
