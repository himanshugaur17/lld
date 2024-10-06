package decorator.decoratingobj;

import decorator.beverage.Beverage;

public abstract class Decorator extends Beverage {
    protected Beverage beverage;
    protected String descString = "Unknown decorator";

    public Decorator(Beverage beverage) {
        if (beverage == null)
            throw new UnsupportedOperationException("The decorator can't exist without the object being decorated");
        this.beverage = beverage;
    }
}
