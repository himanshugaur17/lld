package factory.creator;

import factory.product.Pizza;

public abstract class PizzaStore {
    String pizzaStoreName;
    Integer pizzaStoreId;
    protected SimplePizzaBaseFactory pizzaBaseFactory;

    public PizzaStore(String pizzaStoreName, Integer pizzaStoreId, SimplePizzaBaseFactory pizzaBaseFactory) {
        this.pizzaStoreName = pizzaStoreName;
        this.pizzaStoreId = pizzaStoreId;
        this.pizzaBaseFactory = pizzaBaseFactory;
    }

    public abstract Pizza orderPizza(String type);
}
