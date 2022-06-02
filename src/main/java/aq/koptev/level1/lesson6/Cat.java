package aq.koptev.level1.lesson6;

public class Cat extends Animal {

    public static final int MAX_DEFAULT_RUN_DISTANCE = 200;
    public static final int MAX_DEFAULT_SWIM_DISTANCE = 0;

    public Cat() {

        super();
    }

    public Cat(String name) {

        super(name);
    }

    public Cat(String name, int maxSwimDistance, int maxRunDistance) {

        super(name, maxSwimDistance, maxRunDistance);
    }

    @Override
    public void setMaxSwimDistance(int maxSwimDistance) {

        if(maxSwimDistance < 0) {

            setMaxSwimDistance(MAX_DEFAULT_SWIM_DISTANCE);
        }
    }

    @Override
    public void setMaxRunDistance(int maxRunDistance) {

        if(maxRunDistance < 0) {

            setMaxRunDistance(MAX_DEFAULT_RUN_DISTANCE);
        }
    }

    @Override
    public void initialBehaviour() {

        setRunBehaviour(new DefaultCatRunBehaviour());
        setSwimBehaviour(new DefaultCatSwimBehaviour());
    }
}
