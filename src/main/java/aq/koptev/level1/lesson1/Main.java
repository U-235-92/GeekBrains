package aq.koptev.level1.lesson1;

public class Main {

    public static void main(String[] args) {

        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {

        System.out.println("Call printThreeWords():");
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple\n");
    }

    public static void checkSumSign() {

        System.out.println("Call checkSumSign():");

        int a = 5;
        int b = 9;

        if(a + b >= 0) {

            System.out.println("Сумма положительная\n");
        } else {

            System.out.println("Сумма отрицательная\n");
        }
    }

    public static void printColor() {

        System.out.println("Call printColor():");
        int value = 10;

        if(value <= 0) {

            System.out.println("Красный\n");
        } else if(value > 0 && value <= 100) {

            System.out.println("Желтый\n");
        } else {

            System.out.println("Зеленый\n");
        }
    }

    public static void compareNumbers() {

        System.out.println("Call compareNumbers():");
        int a = 4;
        int b = 8;

        if (a >= b) {

            System.out.println("a >= b\n");
        } else {

            System.out.println("a < b\n");
        }
    }
}
