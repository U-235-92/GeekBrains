package aq.koptev.level3.lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private CountDownLatch cdl;
    private CyclicBarrier cBar;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(CountDownLatch cdl, CyclicBarrier cBar, Race race, int speed) {
        this.race = race;
        this.speed = speed;
        this.cdl = cdl;
        this.cBar = cBar;
        CARS_COUNT++;
        this.name = "Racer #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " preparing");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " ready");
            cdl.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        synchronized (race) {
            while (cdl.getCount() != 0) {
                try {
                    race.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            race.notify();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if(race.getWinner() == null) {
            race.setWinner(this);
            System.out.println(name + " WIN!!!");
        }
        try {
            cBar.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
