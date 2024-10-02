package duck.v2;

import duck.v2.fly.FlyBehaviour;
import duck.v2.quack.QuackStrategy;

public class RedHeadNoFlySilenceQuackDuck extends Duck {

    public RedHeadNoFlySilenceQuackDuck(FlyBehaviour flyBehaviour, QuackStrategy quackBehaviour) {
        super(flyBehaviour, quackBehaviour);
    }

    @Override
    public String display() {
        return "Red colored duck";
    }

}
