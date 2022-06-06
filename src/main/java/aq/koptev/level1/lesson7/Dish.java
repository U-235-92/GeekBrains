package aq.koptev.level1.lesson7;

public class Dish {

    private int countFood;
    private Food food;

    public Dish() {
        this(10, new FoodMilk());
    }

    public Dish(int countFood, Food food) {
        this.countFood = countFood;
        this.food = food;
    }

    public int getCountFood() {
        return countFood;
    }

    public Food getFood() {
        return food;
    }

    public void putFoodInDish(Food food, int countFood) {
        this.food = food;
        if(countFood <= 0) {
            this.countFood = 1;
        } else {
            this.countFood = countFood;
        }
    }

    public void reduceCountFood() {
        if(countFood > 0) {
            countFood--;
        }
    }

    public boolean isEmpty() {
        return countFood <= 0;
    }

    public void printEmptyDishInfo() {
        System.out.println("Еда в миске закончилась!");
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        if(countFood > 0) {
            return "Сейчас в миске: " + food.toString() + " в количестве: " + countFood + " ед.";
        } else {
            return "Миска пуста!";
        }
    }
}
