package decorator.beverage.impl;

import decorator.beverage.Beverage;

public class Lattee extends Beverage{

    @Override
    public int cost() {
        return 15;
    }

    @Override
    public String description() {
        return "Lattee";
    }

}
