package decorator.decoratingobj.impl;

import decorator.beverage.Beverage;
import decorator.decoratingobj.Decorator;

public class Mocha extends Decorator {

    public Mocha(Beverage beverage) {
        super(beverage);
        this.descString=" Mocha";
    }

    @Override
    public int cost() {
        return beverage.cost() + 2;
    }

    @Override
    public String description() {
        return beverage.description() + this.descString;
    }

}
