package aq.koptev.level3.lesson5;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Road " + length + " meters";
    }
    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " start stage: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " end stage: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}