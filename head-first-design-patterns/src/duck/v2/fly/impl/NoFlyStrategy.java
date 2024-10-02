package duck.v2.fly.impl;

import duck.v2.fly.FlyBehaviour;

public class NoFlyStrategy implements FlyBehaviour{

    @Override
    public void fly() {
        System.out.println("I can't fly");
    }

}
