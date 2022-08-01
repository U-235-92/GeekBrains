package aq.koptev.level3.lesson4;

public interface Printer extends Runnable {

    boolean canPrint();
    void print();
    void enable();
    void disable();
    void setNextPrinter(Printer printer);
}
