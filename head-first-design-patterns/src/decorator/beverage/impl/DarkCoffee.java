package decorator.beverage.impl;

import decorator.beverage.Beverage;

public class DarkCoffee extends Beverage {
    
    @Override
    public int cost() {
        return 30;
    }

    @Override
    public String description() {
        return "DarkCoffee";
    }
    

}
