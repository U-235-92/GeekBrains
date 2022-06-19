package aq.koptev.level2.lesson1;

public abstract class Obstacle {

    private ObstacleCharacteristic obstacleCharacteristic;

    public Obstacle(ObstacleCharacteristic obstacleCharacteristic) {
        this.obstacleCharacteristic = obstacleCharacteristic;
    }

    public final int getSize() {
        return  obstacleCharacteristic.getSize();
    }

    public void printInfo() {
        System.out.println(this);
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + obstacleCharacteristic;
    }
}
