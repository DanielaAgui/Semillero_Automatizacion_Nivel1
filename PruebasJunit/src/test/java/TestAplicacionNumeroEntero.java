import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAplicacionNumeroEntero {
    private AplicacionNumeroEntero numeroEntero;

    @BeforeEach
    public void setUp() {
        numeroEntero = new AplicacionNumeroEntero();
    }

    @Test
    public void testMultiploTres() {
        String resultado = numeroEntero.multiploDeTres(3);
        Assertions.assertEquals("tres", resultado);
    }

    @Test
    public void testMultiploCinco() {
        String resultado = numeroEntero.multiploDeCinco(5);
        Assertions.assertEquals("cinco", resultado);
    }

    @Test
    public void testMultiploQuince() {
        String resultado = numeroEntero.multiploDeQuince(15);
        Assertions.assertEquals("unoCinco", resultado);
    }
}
