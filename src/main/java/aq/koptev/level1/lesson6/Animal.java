package aq.koptev.level1.lesson6;

public abstract class Animal {

    private static int createdAnimalCount = 0;
    private final String name;

    private int maxSwimDistance;
    private int maxRunDistance;

    private SwimBehaviour swimBehaviour;
    private RunBehaviour runBehaviour;

    public Animal() {

        name = getClass().getSimpleName();
        maxRunDistance = 0;
        maxSwimDistance = 0;
        createdAnimalCount++;
        initialBehaviour();
    }

    public Animal(String name) {

        this.name = name;
        maxRunDistance = 0;
        maxSwimDistance = 0;
        createdAnimalCount++;
        initialBehaviour();
    }

    public Animal(String name, int maxSwimDistance, int maxRunDistance) {

        this.name = name;
        if(maxSwimDistance < 0) {

            this.maxSwimDistance = 0;
        } else {

            this.maxSwimDistance = maxSwimDistance;
        }

        if(maxRunDistance < 0) {

            this.maxRunDistance = 0;
        } else {

            this.maxRunDistance = maxRunDistance;
        }

        createdAnimalCount++;
        initialBehaviour();
    }

    public final String getName() {

        return name;
    }

    public SwimBehaviour getSwimBehaviour() {

        return swimBehaviour;
    }

    public RunBehaviour getRunBehaviour() {

        return runBehaviour;
    }

    public void setSwimBehaviour(SwimBehaviour swimBehaviour) {

        this.swimBehaviour = swimBehaviour;
    }

    public void setRunBehaviour(RunBehaviour runBehaviour) {

        this.runBehaviour = runBehaviour;
    }

    public final int getMaxSwimDistance() {

        return maxSwimDistance;
    }

    public final int getMaxRunDistance() {

        return maxRunDistance;
    }

    @Override
    public String toString() {

        return getClass().getSimpleName() + ": " + name;
    }

    public void doRun(int requireDistanceRun) {

        System.out.print(name + ": ");
        runBehaviour.doRun(requireDistanceRun, maxRunDistance);
    }

    public void doSwim(int requireDistanceSwim) {

        System.out.print(name + ": ");
        swimBehaviour.doSwim(requireDistanceSwim, maxSwimDistance);
    }

    public void printInfo() {

        System.out.println(this);
    }

    public static int getCreatedAnimalCount() {

        return createdAnimalCount;
    }

    public abstract void setMaxSwimDistance(int maxSwimDistance);
    public abstract void setMaxRunDistance(int maxRunDistance);
    public abstract void initialBehaviour();
}
