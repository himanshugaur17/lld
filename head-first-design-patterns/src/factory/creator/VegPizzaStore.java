package factory.creator;

import factory.product.Pizza;

public class VegPizzaStore extends PizzaStore {

    public VegPizzaStore(Integer pizzaStoreId, SimplePizzaBaseFactory pizzaBaseFactory) {
        super("ABC veg pizza store", pizzaStoreId, pizzaBaseFactory);
    }

    @Override
    public Pizza orderPizza(String type) {
        Pizza pizza = this.pizzaBaseFactory.pizza(type);
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
