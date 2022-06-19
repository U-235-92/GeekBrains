package aq.koptev.level2.lesson1;

public abstract class ObstacleCharacteristic {

    private int obstacleSize = 0;

    public ObstacleCharacteristic(int obstacleSize) {
        this.obstacleSize = obstacleSize;
    }

    public final int getSize() {
        return obstacleSize;
    }

    @Override
    public String toString() {
        return obstacleSize + "";
    }
}
