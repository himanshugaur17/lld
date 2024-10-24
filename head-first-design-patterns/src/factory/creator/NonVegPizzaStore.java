package factory.creator;

import factory.product.Pizza;

public class NonVegPizzaStore extends PizzaStore {

    public NonVegPizzaStore(Integer pizzaStoreId) {
        super("CDE Non veg pizza store", pizzaStoreId);
        // TODO Auto-generated constructor stub
    }

    @Override
    public Pizza orderPizza(String type) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'orderPizza'");
    }

}
