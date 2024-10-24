package factory.creator;

import factory.product.Pizza;

public abstract class PizzaStore {
    String pizzaStoreName;
    Integer pizzaStoreId;

    public PizzaStore(String pizzaStoreName, Integer pizzaStoreId) {
        this.pizzaStoreName = pizzaStoreName;
        this.pizzaStoreId = pizzaStoreId;
    }

    public abstract Pizza orderPizza(String type);
}
