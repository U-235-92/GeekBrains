package aq.koptev.level3.lesson7.util;

public enum LaunchOrder {
    BEFORE_ALL(0), QUEUE(5), AFTER_ALL(10);

    private int priority;
    LaunchOrder(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
