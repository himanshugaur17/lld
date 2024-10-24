package factory.product;

public class ThickPizza extends Pizza {

    public ThickPizza() {
        super("Thick pizza", 3, false, false);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void cut() {
        numberOfPieces = 1 * numberOfPieces;
    }

    @Override
    public void bake() {
        baked = true;
    }

    @Override
    public void box() {
        boxed = true;
    }

}
