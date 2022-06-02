package aq.koptev.level1.lesson6;

public class DefaultDogRunBehaviour implements RunBehaviour {

    @Override
    public void doRun(int requireDistanceRun, int maxDistanceRun) {

        if(requireDistanceRun > maxDistanceRun) {

            System.out.println("I can't rum more " + maxDistanceRun + " meters ):");
        } else {

            System.out.println("I run " + requireDistanceRun + " meters! Wooof! (:");
        }
    }
}
