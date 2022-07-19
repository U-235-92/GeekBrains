package aq.koptev.level3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box <T extends Fruit> {

    private List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public Box(T[] fruits) {
        this.fruits = new ArrayList(Arrays.asList(fruits));
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public void clear() {
        fruits.removeAll(fruits);
    }

    public double getWeight() {
        double weight = 0;
        for(Fruit fruit : fruits) {
           weight += fruit.getWeight();
        }
        return weight;
    }

    public List<T> getFruits() {
        return fruits;
    }

    public boolean compare(Box o) {
        return Math.abs(o.getWeight() - getWeight()) < 0.01;
    }

    public void put(Box<T> box) {
        fruits.addAll(box.getFruits());
        box.clear();
    }

    @Override
    public String toString() {
        return String.format("%s %.2f". getClass().getSimpleName(), getWeight());
    }
}
