package aq.koptev.level1.lesson7;

public class FoodFish extends Food {

    public FoodFish() {
        super();
    }

    public FoodFish(int nutritionValue) {
        super(nutritionValue);
    }

    @Override
    public String toString() {
        return "Рыбка, " + super.toString();
    }
}
