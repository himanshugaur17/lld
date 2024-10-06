package decorator.beverage.impl;

import decorator.beverage.Beverage;

public class RoastCoffee extends Beverage{

    @Override
    public int cost() {
        return 25;
    }

    @Override
    public String description() {
        return "RoastCoffee";
    }

}
