package factory.product;

public class FarmFreshPizza extends Pizza {

    public FarmFreshPizza() {
        super("Farm fresh", 5, false, false);
    }

    @Override
    public void cut() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cut'");
    }

    @Override
    public void bake() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bake'");
    }

    @Override
    public void box() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'box'");
    }

}
