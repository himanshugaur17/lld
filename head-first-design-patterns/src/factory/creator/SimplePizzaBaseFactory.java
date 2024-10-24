package factory.creator;

import factory.product.CheeseSpicyPizza;
import factory.product.FarmFreshPizza;
import factory.product.Pizza;
import factory.product.ThickPizza;
import factory.product.ThinPizza;

public class SimplePizzaBaseFactory {
    public Pizza pizza(String type) {
        Pizza pizza = null;
        if (type.equals("Thin")) {
            pizza = new ThinPizza();
        } else if (type.equals("Thick")) {
            pizza = new ThickPizza();
        } else if (type.equals("Cheese")) {
            pizza = new CheeseSpicyPizza();
        } else if (type.equals("Fresh")) {
            pizza = new FarmFreshPizza();
        } else {
            throw new UnsupportedOperationException("Pizza not supported YET!");
        }
        return pizza;
    }
}
