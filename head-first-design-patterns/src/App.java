import duck.v2.Duck;
import duck.v2.GreenHeadFlyAndQuackDuck;
import duck.v2.fly.impl.FlyWithWingsStrategy;
import duck.v2.fly.impl.NoFlyStrategy;
import duck.v2.quack.impl.NormalQuackStrategy;

public class App {
    public static void main(String[] args) throws Exception {
        Duck greenFlyQuackingDuck = new GreenHeadFlyAndQuackDuck(new FlyWithWingsStrategy(), new NormalQuackStrategy());
        System.out.println(greenFlyQuackingDuck.display());
        greenFlyQuackingDuck.fly();
        greenFlyQuackingDuck.quack();

        // change fly strategy to none at runtime

        greenFlyQuackingDuck.setFlyBehaviour(new NoFlyStrategy());
        greenFlyQuackingDuck.fly();
    }
}
