package aq.koptev.level3.lesson6;

import java.util.Arrays;

public class ArrayApp {

    public int[] getSubArrayAfterVal(int[] arr, int val) {
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] == val) {
                int[] subArr = Arrays.copyOfRange(arr, i + 1, arr.length);
                return subArr;
            }
        }
        throw new RuntimeException();
    }

    public boolean isContain(int[] arr, int val1, int val2) {
        Arrays.sort(arr);
        int hasVal1 = Arrays.binarySearch(arr, val1);
        int hasVal2 = Arrays.binarySearch(arr, val2);
        return (hasVal1 > -1) || (hasVal2 > -1);
    }
}
