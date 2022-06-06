package aq.koptev.level1.lesson7;

public class Main {

    public static void main(String[] args) {

        int countFood = 50;

        Food foodMilk = new FoodMilk(10);
        Food foodMeat = new FoodMeat(27);
        Food foodFish = new FoodFish(18);

        Dish dish = new Dish(countFood, foodMeat);
        System.out.println(dish);

        Cat catDarsy = new Cat("Дарсик", 81);
        Cat catMursik = new Cat("Мурзик");
        Cat catAsya = new Cat("Ася", 151);
        Cat catSonya = new Cat("Соня");
        Cat catWasya = new Cat("Вася", 239);
        Cat catMur = new Cat("Мур", 10);

        Cat[] cats = new Cat[]{catDarsy, catMursik, catAsya, catSonya, catWasya};
        for(Cat cat : cats) {
            cat.haveEat(dish);
        }
        catDarsy.haveEat(dish);

        dish.putFoodInDish(foodMilk, 1);
        System.out.println(dish);

        catMur.haveEat(dish);
    }
}
