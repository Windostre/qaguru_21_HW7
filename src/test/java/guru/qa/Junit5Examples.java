package guru.qa;

import org.junit.jupiter.api.*;

public class Junit5Examples {
    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }

    @BeforeEach
    void setUp() {
        System.out.println("    beforeEach");
    }

    @AfterEach
    void tearDown() {
        System.out.println("    afterEach");
    }

    @Test
    void firstTest() {
        System.out.println("            firstTest");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void secondTest() {
        System.out.println("            secondTest");
        Assertions.assertTrue(3 > 2);
    }

    @Test
    void thirdTest() {
        System.out.println("            thirdTest");
        Assertions.assertTrue(3 > 2);
    }
}
