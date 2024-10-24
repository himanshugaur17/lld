package factory;

import factory.creator.PizzaStore;
import factory.creator.VegPizzaStore;
import factory.product.Pizza;

public class FactoryPatternTestSim {
    public static void main(String[] args) {
        /*
         * There will be multiple pizza stores, I can order from any PizzaStore
         * and based on a parameter, different base must be used for Pizza preparation
         */
        PizzaStore vegPizzaStore = new VegPizzaStore(1);
        Pizza thinVegPizza = vegPizzaStore.orderPizza("Thin");
        System.out.println("I got the pizza: " + thinVegPizza.toString());

        System.out.println("Let's order one more from veg store");
        Pizza thickVegPizza = vegPizzaStore.orderPizza("Thick");
        System.out.println("I got the pizza: " + thickVegPizza.toString());

    }
}
