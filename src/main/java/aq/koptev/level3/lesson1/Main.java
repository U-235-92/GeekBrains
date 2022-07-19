package aq.koptev.level3.lesson1;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> integers = GenRunner.convertToArrayList(new Integer[]{1, 2, 3, 4, 5});
        String[] arr = {"first",  "second", "third", "fourth", "fifth"};
        GenRunner.print(arr);
        GenRunner.swapPosition(arr, 0, arr.length - 1);
        GenRunner.print(arr);

        Box<Orange> orangeBox = new Box<>(new Orange[]{new Orange(1.0), new Orange(2.0), new Orange(3.5)});
        Box<Orange> orangeBox2 = new Box<>();
        Box<Apple> appleBox = new Box<>(new Apple[]{new Apple(0.5), new Apple(3.2), new Apple(2.3), new Apple(1.5)});
        orangeBox.add(new Orange(10));
        appleBox.add(new Apple(9));
        System.out.println("Orange Box weight = " + orangeBox.getWeight());
        System.out.println("Apple Box weight = " + appleBox.getWeight());
        System.out.println("OrangeBox compare AppleBox = " + orangeBox.compare(appleBox));
        System.out.println("Weight before put = " + orangeBox2.getWeight());
        orangeBox2.put(orangeBox);
        System.out.println("Weight after put = " + orangeBox2.getWeight());
    }

}
