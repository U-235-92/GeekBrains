package aq.koptev.level3.lesson7.exception;

public class NoSingleAnnotationException extends Exception {

    public NoSingleAnnotationException() {
        super();
    }

    @Override
    public String toString() {
        String clazz = this.getClass().getSimpleName();
        String msg = "No single annotation";
        return super.toString() + "\n" + String.format("%s: %s", clazz, msg);
    }
}
