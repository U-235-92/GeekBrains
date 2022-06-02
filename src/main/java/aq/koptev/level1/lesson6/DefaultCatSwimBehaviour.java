package aq.koptev.level1.lesson6;

public class DefaultCatSwimBehaviour implements SwimBehaviour {

    @Override
    public void doSwim(int requireDistanceSwim, int maxDistanceSwim) {

        System.out.println("I can't swim! ):");
    }
}
