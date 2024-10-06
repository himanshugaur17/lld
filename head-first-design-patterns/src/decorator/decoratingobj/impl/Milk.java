package decorator.decoratingobj.impl;

import decorator.beverage.Beverage;
import decorator.decoratingobj.Decorator;

public class Milk extends Decorator {
    public Milk(Beverage beverage) {
        super(beverage);
        this.descString = " Milk";
    }

    @Override
    public int cost() {
        return this.beverage.cost() + 3;
    }

    @Override
    public String description() {
        return this.beverage.description() + this.descString;
    }

}
