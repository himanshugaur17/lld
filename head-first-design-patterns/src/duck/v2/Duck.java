package duck.v2;

import duck.v2.fly.FlyBehaviour;
import duck.v2.quack.QuackStrategy;

public class Duck {
    private FlyBehaviour flyBehaviour;
    private QuackStrategy quackBehaviour;

    public Duck(FlyBehaviour flyBehaviour, QuackStrategy quackBehaviour) {
        this.flyBehaviour = flyBehaviour;
        this.quackBehaviour = quackBehaviour;
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }

    public void setQuackBehaviour(QuackStrategy quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }

    public String display() {
        return "looks like a duck";
    }

    public void fly() {
        flyBehaviour.fly();
    }

    public void quack() {
        quackBehaviour.quack();
    }

    public String swim() {
        return "I am swimming";
    }
}
