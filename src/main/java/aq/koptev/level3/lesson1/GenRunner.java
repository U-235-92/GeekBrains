package aq.koptev.level3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class GenRunner {

    public static <T> void swapPosition(T[] arr, int from, int to) {
        if(isNegativeArgs(from, to)) {
            System.out.println("Negative args!");
        } else if(isArgsMoreThanArrayLength(arr, from, to)) {
            System.out.println("Args > arr length!");
        } else {
            T tmp = arr[from];
            arr[from] = arr[to];
            arr[to] = tmp;
        }
    }

    private static boolean isNegativeArgs(int arg1, int arg2) {
        if(arg1 < 0 || arg2 < 0) {
            return true;
        }
        return false;
    }

    private static <T> boolean isArgsMoreThanArrayLength(T[] arr, int arg1, int arg2) {
        if(arg1 >= arr.length || arg2 >= arr.length) {
            return true;
        }
        return false;
    }

    public static <T> ArrayList<T> convertToArrayList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    public static <T> void print(T[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
