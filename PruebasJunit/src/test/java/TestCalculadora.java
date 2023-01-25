import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class TestCalculadora {
    //Instanciamos la clase
    private Calculadora calculadora;

    @BeforeEach
    //Inicializamos la clase
    public void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    public void testSumarNumerosPositivos() {
        //Verificamos que lo esperado sea igual al resultado dado
        int resultado = calculadora.suma(10, 10);
        Assertions.assertEquals(20, resultado);
    }

    @Test
    public void testSumarNumerosPositivosPersonalizado() {
        int resultado = calculadora.suma(10, 10);
        //Tambien podemos incluir un mensaje personalizado en caso de que falle el test
        Assertions.assertEquals(30, resultado, "Esperaba que la suma fuera correcta");
    }

    @Test
    public void testSumarNumerosNegativos() {
        int resultado = calculadora.suma(-10, -5);
        MatcherAssert.assertThat(-15, equalTo(resultado));
    }

    @Test
    public void testSumarNumerosNegativosPersonalizado() {
        int resultado = calculadora.suma(-10, -5);
        MatcherAssert.assertThat(-15, equalTo(resultado));
    }
}
