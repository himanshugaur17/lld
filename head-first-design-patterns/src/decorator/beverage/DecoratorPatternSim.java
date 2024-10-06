package decorator.beverage;

import decorator.beverage.impl.RoastCoffee;
import decorator.decoratingobj.impl.Milk;
import decorator.decoratingobj.impl.Whip;

public class DecoratorPatternSim {
    public static void main(String[] args) {
        Beverage roastCoffee = new RoastCoffee();
        // add milk on top of roastCoffee
        Beverage rCWithMilk = new Milk(roastCoffee);
        // add whip on top
        Beverage rCMWithWhip = new Whip(rCWithMilk);

        System.out.println(rCMWithWhip.description());
    }
}
