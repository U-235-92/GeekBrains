package aq.koptev.level2.lesson1;

public class ActiveStatus {

    private boolean isActive = true;

    public ActiveStatus() {
    }

    public ActiveStatus(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public void enableActivity() {
        isActive = true;
    }

    public void disableActivity() {
        isActive = false;
    }
}
