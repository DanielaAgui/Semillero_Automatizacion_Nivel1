import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


//Agregar libreria de Selenium de Maven Repository en build.gradle
public class SeleniumTests {

    //Creamos un objeto de 'ChromeDriver'
    private WebDriver driver;

    //Metodo a ejecutar antes de cada test
    @BeforeEach
    public void setUp() {
        //Inicializamos el driver
        driver = new ChromeDriver();
    }

    @Test
    public void buscarEnGoogle() {
        //Abrimos la url
        driver.get("https://google.com");
        //Buscamos un elemento web
        WebElement campoBusqueda = driver.findElement(By.name("q"));
        //Escribimos un texto en el elemento localizado
        campoBusqueda.sendKeys("WebdriverManager");
        campoBusqueda.sendKeys(Keys.ENTER);
    }

    //Metodo a ejecutar despues de cada test
    @AfterEach
    public void closeWebDriver() {
        //Cerramos el driver
        driver.quit();
    }
}
