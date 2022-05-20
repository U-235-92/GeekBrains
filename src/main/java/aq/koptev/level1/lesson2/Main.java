package aq.koptev.level1.lesson2;

public class Main {

    public static void main(String[] args) {

        System.out.println("checkNumberRange(): " + checkNumberRange(9, 9));
        System.out.print("checkNumberSign(): ");
        checkNumberSign(10);
        System.out.println("checkNumberSign2(): " + checkNumberSign2(-8));
        System.out.println("printMessage(): ");
        printMessage(3, "Hello, World!");
        System.out.println("isLeapYear():  " + isLeapYear(2036));

    }

    public static boolean checkNumberRange(int a, int b) {

        return (a + b) >= 10 && (a + b) <= 20;
    }

    public static void checkNumberSign(int a) {

        if(a >= 0) {

            System.out.println("The number is positive\n");
        } else {

            System.out.println("The number is negative\n");
        }
    }

    public static boolean checkNumberSign2(int a) {

        if(a < 0) {

            return true;
        } else {

            return false;
        }
    }

    public static void printMessage(int count, String message) {

        for(int i = 0; i < count; i++) {

            System.out.println(message);
        }
    }

    public static boolean isLeapYear(int year) {

        if(year % 400 == 0) {

            return true;
        } else {

            if(year % 100 == 0) {

                return false;
            } else {

                if(year % 4 == 0) {

                    return true;
                } else {

                    return false;
                }
            }
        }
    }
}
