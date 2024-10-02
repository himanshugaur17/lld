package duck.v2.fly.impl;

import duck.v2.fly.FlyBehaviour;

public class FlyWithWingsStrategy implements FlyBehaviour{

    @Override
    public void fly() {
        System.out.println("Fly with wings");
    }

}
