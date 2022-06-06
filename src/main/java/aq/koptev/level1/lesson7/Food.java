package aq.koptev.level1.lesson7;

public abstract class Food {

    private int nutritionValue;

    public Food() {
        this(10);
    }

    public Food(int nutritionValue) {
        this.nutritionValue = nutritionValue;
    }

    public int getNutritionValue() {
        return nutritionValue;
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "питательность: " + nutritionValue + " ед.";
    }
}
