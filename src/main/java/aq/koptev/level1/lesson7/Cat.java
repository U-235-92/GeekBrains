package aq.koptev.level1.lesson7;

public class Cat {
    public static int MAX_SATE_LEVEL = 100;
    private int maxSatietyLevel = 0;
    private int currentSatietyLevel = 0;
    private boolean isSatiety = false;
    private String name;

    public Cat() {
        this("Мурзик");
    }

    public Cat(String name) {
        this.name = name;
        this.maxSatietyLevel = MAX_SATE_LEVEL;
    }

    public Cat(String name, int maxSateLevel) {
        this.name = name;
        this.maxSatietyLevel = maxSateLevel;
    }

    public int getCurrentSatietyLevel() {
        return currentSatietyLevel;
    }

    public boolean isSatiety() {
        return isSatiety;
    }

    public String getName() {
        return name;
    }

    public void printInfo() {
        System.out.println(this);
    }

    public int getMaxSatietyLevel() {
        return maxSatietyLevel;
    }

    public void haveEat(Dish dish) {
        System.out.println("Котик " + name + " подходит к миске");
        if(catCanHaveEat(dish)) {
            System.out.println("Котик " + name + " начинает кушать");

            while(currentSatietyLevel < maxSatietyLevel) {
                if(dish.isEmpty()) {
                    break;
                }
                upSateLevel(dish);
                dish.reduceCountFood();
            }

            if(currentSatietyLevel >= maxSatietyLevel) {
                getSatiety();
                System.out.println(this);
            } else {
                System.out.println(this);
            }
        } else {
            if(dish.isEmpty()) {
                System.out.println(dish);
            } else {
                if(currentSatietyLevel < maxSatietyLevel) {
                    System.out.println("Котику " + name + " не хватает еды в миске, " +
                            "котику нужно " + (maxSatietyLevel - currentSatietyLevel) + " ед.");
                } else {
                    System.out.println(this);
                }
            }
        }
        System.out.println("Котик " + name + " уходит");
        if(!dish.isEmpty()) {
            System.out.println(dish + "\n");
        }
    }

    private void getSatiety() {
        isSatiety = true;
    }

    private void upSateLevel(Dish dish) {
        currentSatietyLevel += dish.getFood().getNutritionValue();
    }

    private boolean catCanHaveEat(Dish dish) {
        return dish.getFood().getNutritionValue() * dish.getCountFood() >= maxSatietyLevel &&
                currentSatietyLevel < maxSatietyLevel;
    }

    @Override
    public String toString() {
        return "Котик " + name + (isSatiety == true ? " сыт (: " : " хочет кушать! ") +
            "Текущий уровень сытости: " + currentSatietyLevel + " из " + maxSatietyLevel +
                (currentSatietyLevel > maxSatietyLevel ? ". Кое-кто объелся (:" :
                        currentSatietyLevel == maxSatietyLevel ? "" : ". Котик не наелся ):");
    }
}
