package aq.koptev.level1.lesson7;

public class FoodMilk extends Food {

    public FoodMilk() {
        super();
    }

    public FoodMilk(int nutritionValue) {
        super(nutritionValue);
    }

    @Override
    public String toString() {
        return "Молоко, " + super.toString();
    }
}
