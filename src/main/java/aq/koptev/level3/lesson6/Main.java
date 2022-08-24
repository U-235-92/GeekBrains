package aq.koptev.level3.lesson6;

public class Main {

    public static void main(String[] args) {
        ArrayApp app = new ArrayApp();
        int[] arr = app.getSubArrayAfterVal(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, 4);
        boolean b = app.isContain(new int[]{3, 9, 1}, 1, 4);
    }
}
