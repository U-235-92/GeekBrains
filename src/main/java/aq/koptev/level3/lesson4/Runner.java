package aq.koptev.level3.lesson4;

public class Runner implements Runnable {

    private boolean canPrintA = true;
    private boolean canPrintB = false;
    private boolean canPrintC = false;


    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            System.out.println("Iteration: " + (i + 1));
            printA();
            printB();
            printC();
            System.out.println();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void printA() {
        while (!canPrintA) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("A");
        canPrintA = false;
        canPrintB = true;
        notifyAll();
    }

    private synchronized void printB() {
        while (!canPrintB) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("B");
        canPrintB = false;
        canPrintC = true;
        notifyAll();
    }

    private synchronized void printC() {
        while (!canPrintC) {
            try {
                wait();
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
        canPrintA = true;
        canPrintC = false;
        notifyAll();
    }
}
