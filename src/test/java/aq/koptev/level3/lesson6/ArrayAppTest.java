package aq.koptev.level3.lesson6;

import org.junit.jupiter.api.*;

class ArrayAppTest {
    private static ArrayApp app;
    private int[] arr1 = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
    private int[] arr2 = new int[]{1, 7};
    private int[] arr3 = new int[]{};

    @BeforeAll
    static void initApp() {
        System.out.println("INIT");
        app = new ArrayApp();
    }

    @AfterAll
    static void afterAll() {
        System.out.println("END TEST");
    }

    @BeforeEach
    void start() {
        System.out.println("Start test");
    }

    @AfterEach
    void end() {
        System.out.println("End test");
    }

    @Test
    @DisplayName("is throws?")
    void isThrows() {
        Assertions.assertDoesNotThrow(() -> app.getSubArrayAfterVal(arr1, 4));
    }

    @Test
    @DisplayName("is same arrays?")
    void has4Or1InArr() {
        Assertions.assertArrayEquals(arr1, arr2);
    }

    @Test
    @DisplayName("is contains 1 or 4?")
    void isContains() {
        Assertions.assertTrue(app.isContain(arr3, 1, 4));
    }

    @Test
    @DisplayName("isn't contains 1 or 4?")
    void isNotContains() {
        Assertions.assertFalse(app.isContain(arr3, 1, 4));
    }
}