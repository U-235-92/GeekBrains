package aq.koptev.level3.lesson4;

public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runner());
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End");
    }
}
