package duck.v2.quack.impl;

import duck.v2.quack.QuackStrategy;

public class SilenceQuackStrategy implements QuackStrategy{

    @Override
    public void quack() {
        System.out.println("Silence quacking");
    }

}
