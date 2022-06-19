package aq.koptev.level2.lesson1;

public class Robot implements Activable {

    private String model;
    private String manufacturerName;
    private PhysicCharacteristic physicCharacteristic;
    private ActiveStatus activeStatus;
    public Robot(String model, String manufacturerName, PhysicCharacteristic physicCharacteristic, ActiveStatus activeStatus) {
        this.model = model;
        this.manufacturerName = manufacturerName;
        this.physicCharacteristic = physicCharacteristic;
        this.activeStatus = activeStatus;
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Робот, модель: " + model + ", производитель: " + manufacturerName +
                "; Может прыгнуть на: " + physicCharacteristic.getMaxJumpHeight() + " см." +
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
        System.out.println("Робот " + model + " бежит!");
    }

    @Override
    public void jump() {
        jumpMessage();
    }

    private void jumpMessage() {
        System.out.println("Робот " + model + " прыгает!");
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
        System.out.println("Робот " + model + " не может прыгнуть на указанню высоту (" + height + ")");
        System.out.println("Робот " + model + " сходит с полосы препятсвий!");
    }

    private void humanCanJumpMessage(int height) {
        System.out.println("Робот " + model + " готовится к прыжку на высоту " + height + " см!");
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
        System.out.println("Робот " + model + " не может пробежать на указанную дистанцию (" + distance + ")");
        System.out.println("Робот " + model + " сходит с полосы препятсвий!");
    }

    private void humanCanRunMessage(int distance) {
        System.out.println("Робот " + model + " готовится к забегу на дистанцию " + distance + " м!");
    }
}
