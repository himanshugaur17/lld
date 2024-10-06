package decorator.decoratingobj.impl;

import decorator.beverage.Beverage;
import decorator.decoratingobj.Decorator;

public class Whip extends Decorator {

    public Whip(Beverage beverage) {
        super(beverage);
        this.descString = " Whip";
    }

    @Override
    public int cost() {
        return this.beverage.cost() + 5;
    }

    @Override
    public String description() {
        return this.beverage.description() + this.descString;
    }

}
