package aq.koptev.level2.lesson4;

public class Main {

    public static void main(String[] args) {
        MathNumerator mathNumerator = new MathNumerator();
        mathNumerator.calculateNoThread();
        mathNumerator.calculateWithThread();
    }
}
