package aq.koptev.level2.lesson1;

public class Human implements Activable {

    private String name;
    private PhysicCharacteristic physicCharacteristic;
    private ActiveStatus activeStatus;
    private Sex sex;

    public Human(String name, Sex sex, PhysicCharacteristic physicCharacteristic, ActiveStatus activeStatus) {
        this.name = name;
        this.physicCharacteristic = physicCharacteristic;
        this.sex = sex;
        this.activeStatus = activeStatus;
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Человек, " + name + ", " + sex.getRussianTitle() + "; Может прыгнуть на: " + physicCharacteristic.getMaxJumpHeight() + " см." +
             " Может пробежать на " + physicCharacteristic.getMaxRunDistance() + "м.";
    }

    @Override
    public boolean isCanActive() {
        return activeStatus.isActive();
    }

    @Override
    public void run() {
        runMessage();
    }

    private void runMessage() {
        System.out.println("Человек " + name + " бежит!");
    }

    @Override
    public void jump() {
        jumpMessage();
    }

    private void jumpMessage() {
        System.out.println("Человек " + name + " прыгает!");
    }

    @Override
    public boolean canJump(int height) {
        if(activeStatus.isActive()) {
            if(height > physicCharacteristic.getMaxJumpHeight()) {
                humanDoNotCanJumpMessage(height);
                activeStatus.disableActivity();
                return false;
            } else {
                humanCanJumpMessage(height);
                return true;
            }
        } else {
            return false;
        }
    }

    private void humanDoNotCanJumpMessage(int height) {
        System.out.println("Человек " + name + " не может прыгнуть на указанню высоту (" + height + ")");
        System.out.println("Человек " + name + " сходит с полосы препятсвий!");
    }

    private void humanCanJumpMessage(int height) {
        System.out.println("Человек " + name + " готовится к прыжку на высоту "+ height + " см!");
    }

    @Override
    public boolean canRun(int distance) {
        if(activeStatus.isActive()) {
            if(distance > physicCharacteristic.getMaxRunDistance()) {
                humanDoNotCanRunMessage(distance);
                activeStatus.disableActivity();
                return false;
            } else {
                humanCanRunMessage(distance);
                return true;
            }
        } else {
            return false;
        }
    }

    private void humanDoNotCanRunMessage(int distance) {
        System.out.println(name + " не может пробежать на указанную дистанцию (" + distance + ")");
    }

    private void humanCanRunMessage(int distance) {
        System.out.println(name + " готовится к забегу на дистанцию " + distance + " м!");
    }
}
