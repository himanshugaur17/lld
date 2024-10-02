package duck.v2.quack.impl;

import duck.v2.quack.QuackStrategy;

public class NormalQuackStrategy implements QuackStrategy{

    @Override
    public void quack() {
        System.out.println("Normal quacking");
    }

}
