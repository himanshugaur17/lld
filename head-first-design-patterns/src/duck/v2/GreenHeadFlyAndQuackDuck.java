package duck.v2;

import duck.v2.fly.FlyBehaviour;
import duck.v2.quack.QuackStrategy;

public class GreenHeadFlyAndQuackDuck extends Duck {

    public GreenHeadFlyAndQuackDuck(FlyBehaviour flyBehaviour, QuackStrategy quackBehaviour) {
        super(flyBehaviour, quackBehaviour);
    }

    @Override
    public String display() {
        return "Green colored duck";
    }

}
