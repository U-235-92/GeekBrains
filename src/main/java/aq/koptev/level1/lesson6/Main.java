package aq.koptev.level1.lesson6;

public class Main {

    public static void main(String[] args) {

        Animal dogJuchka = new Dog("Жучка", Dog.MAX_DEFAULT_SWIM_DISTANCE, Dog.MAX_DEFAULT_RUN_DISTANCE);
        Animal catDarsy = new Cat("Дарсик", Cat.MAX_DEFAULT_SWIM_DISTANCE, Cat.MAX_DEFAULT_RUN_DISTANCE);
        Animal catMursik = new Cat("Мурзик", 10, 400);

        dogJuchka.doRun(2000);
        catDarsy.doSwim(0);
        catMursik.doRun(400);
        catMursik.doSwim(10);

        System.out.println("Count created animals: " + Animal.getCreatedAnimalCount());

    }
}
