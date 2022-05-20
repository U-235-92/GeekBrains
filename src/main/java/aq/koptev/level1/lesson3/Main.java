package aq.koptev.level1.lesson3;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        swapNumbers();
        fillArray();
        multiplyArray();
        printDiagonal();
        printArray(10, 5);
        minMax();
        System.out.println(checkArray(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
        shift(new int[]{1, 2, 3, 4, 5}, 2);
    }

    public static void swapNumbers() {

        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        System.out.println("swapNumbers(): ");
        System.out.println("Before swap: " + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 1) {

                arr[i] = 0;
            } else {

                arr[i] = 1;
            }
        }

        System.out.println("After swap: " + Arrays.toString(arr) + "\n");
    }

    public static void fillArray() {

        int[] arr = new int[100];

        for(int i = 0; i < arr.length; i++) {

            arr[i] = i + 1;
        }

        System.out.println("fillArray(): " + Arrays.toString(arr) + "\n");
    }

    public static void multiplyArray() {

        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("multiplyArray(): ");
        System.out.println("Before: " + Arrays.toString(arr));

        for(int i = 0; i < arr.length; i++) {

            arr[i] = arr[i] > 6 ? arr[i] * 2 : arr[i];
        }

        System.out.println("After: " + Arrays.toString(arr) + "\n");
    }

    public static void printDiagonal() {

        System.out.println("printDiagonal(): ");
        int size = 5;
        int[][] matrix = new int[size][size];

        for(int i = 0; i < matrix.length; i++) {

            for(int j = 0; j < matrix[i].length; j++) {

                if(i == j || i + j + 1 == size) {

                    matrix[i][j] = 1;
                } else {

                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {

            for(int j = 0; j < matrix[i].length; j++) {

                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }

    public static void printArray(int length, int value) {

        int[] arr = new int[length];

        for(int i = 0; i < arr.length; i++) {

            arr[i] = value;
        }

        System.out.println("printArray(): " + Arrays.toString(arr));
    }

    public static void minMax() {

        System.out.println("minMax():");

        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, -9, 1};

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {

            if(arr[i] > max) {

                max = arr[i];
            }

            if(arr[i] < min) {

                min = arr[i];
            }
        }

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Max value = " + max);
        System.out.println("Min value = " + min);
    }

    public static boolean checkArray(int[] array) {

        int rightBorder = array.length >= 3 ? 2 : (array.length == 2 ? 1 : array.length);
        int sumRight = 0, sumLeft = 0;

        for(int i = 0; i < array.length - rightBorder; i++) {

            sumLeft += array[i];
        }

        for(int i = array.length - rightBorder; i < array.length; i++) {

            sumRight += array[i];
        }


        return sumLeft == sumRight;
    }

    public static void shift(int[] array, int shift) {

        if(shift == 0) {

            System.out.println("Shift is 0, return array: "  + Arrays.toString(array));
        } else if(shift > 0) {

            if(shift > array.length) {

                while(shift >= array.length) {

                    shift = shift - array.length;
                }
            }

            swap(array, 0, array.length - 1 - shift);
            swap(array, array.length - shift, array.length - 1);
            swap(array, 0, array.length - 1);

            System.out.println("Shift to right on " + shift + " elements: " + Arrays.toString(array));

        } else {

            shift *= -1;

            if(shift > array.length) {

                while(shift >= array.length) {

                    shift = shift - array.length;
                }
            }

            swap(array, 0, (array.length - (array.length - shift)) - 1);
            swap(array, (array.length - (array.length - shift)), array.length - 1);
            swap(array, 0, array.length - 1);

            System.out.println("Shift to left on " + Math.abs(shift) + " elements: " + Arrays.toString(array));
        }
    }

    private static void swap(int[] array, int leftBorder, int rightBorder) {

        int i = leftBorder, j = rightBorder;

        while (i <= j) {

            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            i++; j--;
        }
    }
}
