package aq.koptev.level1.lesson6;

public class DefaultDogSwimBehaviour implements SwimBehaviour {

    @Override
    public void doSwim(int requireDistanceSwim, int maxDistanceSwim) {

        if(requireDistanceSwim > maxDistanceSwim) {

            System.out.println("I can't swim more " + maxDistanceSwim + " meters ):");
        } else {

            System.out.println("I swim " + requireDistanceSwim + " meters! Wooof! (:");
        }
    }
}
