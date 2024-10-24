package factory.product;

public class ThinPizza extends Pizza {

    public ThinPizza() {
        super("ThinPizza", 8, false, false);
    }

    @Override
    public void cut() {
        numberOfPieces = 2 * numberOfPieces;
    }

    @Override
    public void bake() {
        baked = true;
    }

    @Override
    public void box() {
        /*
         * THIN PIZZA AGAIN CUT BEFORE BOXING
         */
        cut();
        boxed = true;
    }

}
