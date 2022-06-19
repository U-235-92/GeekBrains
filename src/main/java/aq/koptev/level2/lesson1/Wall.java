package aq.koptev.level2.lesson1;

public class Wall extends Obstacle {

    public Wall(ObstacleCharacteristic obstacleCharacteristic) {
        super(obstacleCharacteristic);
    }

    @Override
    public String toString() {
        return super.toString() + " см.";
    }
}
