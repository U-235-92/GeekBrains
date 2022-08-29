package aq.koptev.level3.lesson7.exception;

public class PriorityTestLevelException extends Exception {

    public PriorityTestLevelException() {
        super();
    }

    @Override
    public String toString() {
        String clazz = this.getClass().getSimpleName();
        String msg = "Incorrect test priority level";
        return super.toString() + "\n" + String.format("%s: %s", clazz, msg);
    }
}
