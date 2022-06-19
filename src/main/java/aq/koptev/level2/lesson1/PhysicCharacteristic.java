package aq.koptev.level2.lesson1;

public class PhysicCharacteristic {

    private int maxRunDistance;
    private int maxJumpHeight;

    public PhysicCharacteristic(int maxRunDistance, int maxJumpHeight) {
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }
}
