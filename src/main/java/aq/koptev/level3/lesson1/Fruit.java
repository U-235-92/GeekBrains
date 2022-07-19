package aq.koptev.level3.lesson1;

public class Fruit {

    private double weight;

    public Fruit(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", getClass().getSimpleName(), weight);
    }
}
