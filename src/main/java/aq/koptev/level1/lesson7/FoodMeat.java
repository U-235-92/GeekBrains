package aq.koptev.level1.lesson7;

public class FoodMeat extends Food {

    public FoodMeat() {
        super();
    }

    public FoodMeat(int nutritionValue) {
        super(nutritionValue);
    }

    @Override
    public String toString() {
        return "Мясо, " + super.toString();
    }
}
