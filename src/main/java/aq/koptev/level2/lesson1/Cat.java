package aq.koptev.level2.lesson1;

public class Cat implements Activable {

    private String name;
    private PhysicCharacteristic physicCharacteristic;
    private ActiveStatus activeStatus;


    public Cat(String name, PhysicCharacteristic physicCharacteristic, ActiveStatus activeStatus) {
        this.name = name;
        this.physicCharacteristic = physicCharacteristic;
        this.activeStatus = activeStatus;
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Котик " + name + "; " + "Может прыгнуть на: " + physicCharacteristic.getMaxJumpHeight() + " см." +
                " Может пробежать на " + physicCharacteristic.getMaxRunDistance() + "м.";
    }

    @Override
    public void run() {
        runMessage();
    }

    private void runMessage() {
        System.out.println(name + " бежит!");
    }

    @Override
    public void jump() {
        jumpMessage();
    }

    private void jumpMessage() {
        System.out.println(name + " прыгает!");
    }

    @Override
    public boolean canJump(int height) {
        if(activeStatus.isActive()) {
            if(height > physicCharacteristic.getMaxJumpHeight()) {
                catDoNotCanJumpMessage(height);
                activeStatus.disableActivity();
                return false;
            } else {
                catCanJumpMessage(height);
                return true;
            }
        } else {
            return false;
        }
    }

    private void catDoNotCanJumpMessage(int height) {
        System.out.println("Котик " + name + " не может прыгнуть на указанню высоту (" + height + ")");
        System.out.println("Котик " + name + " сходит с полосы препятсвий!");
    }

    private void catCanJumpMessage(int height) {
        System.out.println("Котик " + name + " готовится к прыжку на высоту " + height + " cм!");
    }

    @Override
    public boolean canRun(int distance) {
        if(activeStatus.isActive()) {
            if(distance > physicCharacteristic.getMaxRunDistance()) {
                catDoNotCanRunMessage(distance);
                activeStatus.disableActivity();
                return false;
            } else {
                catCanRunMessage(distance);
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean isCanActive() {
        return activeStatus.isActive();
    }

    private void catDoNotCanRunMessage(int distance) {
        System.out.println("Котик " + name + " не может пробежать на указанную дистанцию (" + distance + ")");
        System.out.println("Котик " + name + " сходит с полосы препятсвий!");
    }

    private void catCanRunMessage(int distance) {
        System.out.println("Котик " + name + " готовится к забегу на дистанцию " + distance + " м!");
    }
}
