package aq.koptev.level3.lesson5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    private Semaphore tunnelSemaphore;
    public Tunnel(Semaphore tunnelSemaphore) {
        this.tunnelSemaphore = tunnelSemaphore;
        this.length = 80;
        this.description = "Tunnel " + length + " meters";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " prepare to stage(wait): " + description);
                tunnelSemaphore.acquire();
                System.out.println(c.getName() + " start stage: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " end stage: " + description);
                tunnelSemaphore.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
