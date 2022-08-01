package aq.koptev.level3.lesson4;

public class C implements Printer {

    private boolean canPrint;
    private Printer nextPrinter;
    private Object syncObj;

    public C(Object syncObj, boolean canPrint) {
        this.canPrint = canPrint;
        this.syncObj = syncObj;
    }

    @Override
    public void print() {
        synchronized (syncObj) {
            while (!canPrint) {
                try {
                    syncObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("C");
            disable();
            nextPrinter.enable();
            syncObj.notify();
        }
    }

    @Override
    public void enable() {
        synchronized(syncObj) {
            canPrint = true;
        }
    }

    @Override
    public void disable() {
        synchronized(syncObj) {
            canPrint = false;
        }
    }

    @Override
    public void setNextPrinter(Printer printer) {
        this.nextPrinter = printer;
    }

    @Override
    public boolean canPrint() {
        synchronized (syncObj) {
            return canPrint;
        }
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            print();
        }
    }
}
