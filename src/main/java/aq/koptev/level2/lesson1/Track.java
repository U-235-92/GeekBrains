package aq.koptev.level2.lesson1;

public class Track extends  Obstacle {

    public Track(ObstacleCharacteristic obstacleCharacteristic) {
        super(obstacleCharacteristic);
    }

    @Override
    public String toString() {
        return super.toString() + " м.";
    }
}
