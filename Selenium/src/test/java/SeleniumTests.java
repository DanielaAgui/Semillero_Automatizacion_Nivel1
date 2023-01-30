import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


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
        //Localizamos el elemento web
        WebElement campoBusqueda = driver.findElement(By.name("q"));
        //Escribimos un texto en el elemento localizado
        campoBusqueda.sendKeys("WebdriverManager");

        //Obtenemos el valor del atributo del elemento localizado
        String title = campoBusqueda.getAttribute("title");
        System.out.println(title);

        //Localizamos el elemento web y le damos clic
        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input")).click();

        //Podemos dar ENTER para hacer la busqueda
        //campoBusqueda.sendKeys(Keys.ENTER);
    }

    @Test
    public void pruebaSelected() {
        //Abrimos la url
        driver.get("https://demoqa.com/radio-button");
        //Localizamos el elemento y le damos clic
        driver.findElement(By.className("custom-control-label")).click();
        //Localizamos un elemento de radio button y verificamos si esta seleccionado
        System.out.println(driver.findElement(By.id("yesRadio")).isSelected());
    }

    @Test
    public void probarSelect() {
        //Creamos un objeto de tipo WebDriverWait para que detenga la ejecucion hasta que se cumpla la condicion
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Abrimos la url
        driver.get("https://magento.softwaretestingboard.com/");
        driver.findElement(By.xpath("//img[@class='product-image-photo' and @alt='Radiant Tee']")).click();
        //Espera hasta la visibilidad del elemento y le da clic
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='M']"))).click();
        driver.findElement(By.xpath("//div[@class='swatch-option color']//following-sibling::div[2]")).click();
        driver.findElement(By.id("product-addtocart-button")).click();
        //Localizamos el elemento y obtenemos el texto
        String nombreItem = driver.findElement(By.xpath("//span[@itemprop='name']")).getText();
        String mensaje = "You added " + nombreItem + " to your shopping cart.";
        //Esperamos que el elemento localizado tenga el mensaje especificado
        wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='messages']"), mensaje));
        driver.findElement(By.xpath("//a[@class='action showcart']")).click();
        driver.findElement(By.id("top-cart-btn-checkout")).click();

        //Esperamos la visibilidad del elemento y creamos un objeto
        WebElement regionSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("region_id")));
        //Para automatizar los select, creamos un objeto de tipo 'Select' y localizamos el elemento
        Select select = new Select(regionSelect);
        select.selectByVisibleText("Alaska");
    }

    //Metodo a ejecutar despues de cada test
    @AfterEach
    public void closeWebDriver() {
        //Cerramos el driver
        driver.quit();
    }
}
