package aq.koptev.level3.lesson7.test;

import aq.koptev.level3.lesson7.annotations.AfterSuite;
import aq.koptev.level3.lesson7.annotations.BeforeSuite;
import aq.koptev.level3.lesson7.annotations.Test;

public class TestDemo {

    @BeforeSuite
    public void before() {
        System.out.println("Before");
    }

    @AfterSuite
    public void after() {
        System.out.println("After");
    }

    @Test
    public int getAngleCountTest() {
        System.out.println("getAngleCountTest()");
        return 3;
    }

    @Test(priority = 9)
    public int getTest() {
        System.out.println("getTest()");
        return 3;
    }

    @Test(priority = 0)
    public int getTest2() {
        System.out.println("getTest2()");
        return 3;
    }

    @Test
    public int getTest3() {
        System.out.println("getTest3()");
        return 3;
    }
}
