package aq.koptev.level3.lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {
        System.out.println("IMPORTANT NOTIFY >>> Preparing!!!");
        CountDownLatch prepareCarCDL = new CountDownLatch(CARS_COUNT);
        CyclicBarrier endRaceBarrier = new CyclicBarrier(CARS_COUNT, () -> System.out.println("IMPORTANT NOTIFY >>> End race!!!"));
        Semaphore tunnelSemaphore = new Semaphore(CARS_COUNT / 2);
        Race race = new Race(new Road(60), new Tunnel(tunnelSemaphore), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(prepareCarCDL, endRaceBarrier, race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            prepareCarCDL.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("IMPORTANT NOTIFY >>> Start race!!!");
    }
}
