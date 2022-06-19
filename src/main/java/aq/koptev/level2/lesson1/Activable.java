package aq.koptev.level2.lesson1;

public interface Activable {

    void run();
    void jump();
    boolean canJump(int height);
    boolean canRun(int distance);

    boolean isCanActive();
}
