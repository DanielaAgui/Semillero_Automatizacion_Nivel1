import org.junit.jupiter.api.*;

//Para ejecutar los test en paralelo, se debe establecer primero la configuracion del sistema en 'build.gradle'
public class Paralelismo {

    @BeforeEach
    public void setUp() {
        System.out.println("Before each");
    }

    @BeforeAll
    public static void antesDeTodo() {
        System.out.println("Before All");
    }

    @Test
    public void prueba1() {
        System.out.println("Test 1");
    }

    @Test
    public void prueba2() {
        System.out.println("Test 2");
    }

    @AfterEach
    public void resetAll() {
        System.out.println("Reset after each");
    }

    @AfterAll
    public static void despuesDeTodo() {
        System.out.println("After All");
    }
}
