import org.junit.jupiter.api.*;

public class PruebasJunit {

    //Se ejecuta antes de cada test
    @BeforeEach
    public void setUp() {
        System.out.println("Before each");
    }

    //Todos los metodos 'BeforeAll' y 'AfterAll' deben ser estaticos
    @BeforeAll
    public static void antesDeTodo() {
        System.out.println("Before All");
    }

    //Los metodos deben ser publicos y no devolver nada
    //El nombre del metodo debe iniciar en 'test'
    @Test
    public void testJunit5() {
        System.out.println("Probando con JUnit 5");
    }

    @Test
    public void testJunit5_1() {
        System.out.println("Probando con JUnit 5");
    }

    //Se ejecuta despues de cada test
    @AfterEach
    public void resetAll() {
        System.out.println("Reset after each");
    }

    @AfterAll
    public static void despuesDeTodo() {
        System.out.println("After All");
    }
}
