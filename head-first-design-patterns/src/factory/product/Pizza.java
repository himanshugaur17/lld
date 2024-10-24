package factory.product;

public abstract class Pizza {
    String pizzaDesc;
    Integer numberOfPieces;
    boolean baked;
    boolean boxed;

    public abstract void cut();

    public Pizza(String pizzaDesc, Integer numberOfPieces, boolean baked, boolean boxed) {
        this.pizzaDesc = pizzaDesc;
        this.numberOfPieces = numberOfPieces;
        this.baked = baked;
        this.boxed = boxed;
    }

    public abstract void bake();

    public abstract void box();

    @Override
    public String toString() {
        return "Pizza [pizzaDesc=" + pizzaDesc + ", numberOfPieces=" + numberOfPieces + ", baked=" + baked + ", boxed="
                + boxed + "]";
    }
}
