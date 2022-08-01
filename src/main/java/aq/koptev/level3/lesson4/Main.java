package aq.koptev.level3.lesson4;

public class Main {

    public static void main(String[] args) {
        Object syncObj = new Object();
        Printer a = new A(syncObj, true);
        Printer b = new B(syncObj, false);
        Printer c = new C(syncObj, false);
        a.setNextPrinter(b);
        b.setNextPrinter(c);
        c.setNextPrinter(a);
        Thread thA = new Thread(a);
        Thread thB = new Thread(b);
        Thread thC = new Thread(c);
        thA.start();
        thB.start();
        thC.start();
    }
}
