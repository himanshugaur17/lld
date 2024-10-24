package factory.creator;

import factory.product.CheeseSpicyPizza;
import factory.product.FarmFreshPizza;
import factory.product.Pizza;
import factory.product.ThickPizza;
import factory.product.ThinPizza;

public class VegPizzaStore extends PizzaStore {

    public VegPizzaStore(Integer pizzaStoreId) {
        super("ABC veg pizza store", pizzaStoreId);
    }

    @Override
    public Pizza orderPizza(String type) {
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
        /*
         * THE ABOVE IF ELSE NEED TO BE ADDED
         * AS NEW PIZZA's GET ADDED
         */
        pizza.cut();
        pizza.bake();
        pizza.box();

        return pizza;
    }

}
