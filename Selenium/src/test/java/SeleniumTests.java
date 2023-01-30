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
import java.util.ArrayList;
import java.util.Set;


//Agregar libreria de Selenium de Maven Repository en build.gradle
public class SeleniumTests {

    //Creamos un objeto de 'ChromeDriver'
    private WebDriver driver;
    //Creamos un objeto de tipo WebDriverWait para que detenga la ejecucion hasta que se cumpla la condicion
    private WebDriverWait wait;

    //Metodo a ejecutar antes de cada test
    @BeforeEach
    public void setUp() {
        //Inicializamos el driver
        driver = new ChromeDriver();
        //Inicializamos la espera
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //Espera implicita general
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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

    @Test
    public void pruebaElementoHabilitado() {
        driver.get("https://demoqa.com/dynamic-properties");
        WebElement buttonDisabled = driver.findElement(By.id("enableAfter"));
        //Esperamos hasta que el elemento este habilitado
        wait.until(ExpectedConditions.elementToBeClickable(buttonDisabled));
        buttonDisabled.click();
    }

    @Test
    public void pruebaVariacionElemento() {
        driver.get("https://demoqa.com/dynamic-properties");
        //Esperamos que el elemento localizado contenga el atributo
        //Pasamos elemento a localizar, atributo a contener y valor del atributo
        wait.until(ExpectedConditions.attributeContains(By.id("colorChange"), "class", "text-danger"));
        //Imprime el valor del atributo
        System.out.println(driver.findElement(By.id("colorChange")).getAttribute("class"));
    }

    @Test
    public void pruebaElementoVisible() {
        driver.get("https://demoqa.com/dynamic-properties");
        //Espera de 10 segundos para todos los elementos de la pagina
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("visibleAfter")).click();
    }

    @Test
    public void pruebaNuevaVentana1() {
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id("tabButton")).click();
        //Obtenemos la pantalla en la que estamos parados y lo convertimos a string
        String idActual = driver.getWindowHandle();
        //Creamos un set y obtenemos las pantallas activas en el momento
        Set<String> pantallas = driver.getWindowHandles();
        //Removemos la pantalla actual del set de pantallas
        pantallas.remove(idActual);
        //Nos cambiamos al siguiente elemento del set de pantallas
        driver.switchTo().window(pantallas.stream().iterator().next());
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
    }

    @Test
    public void pruebaNuevaVentana2() {
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id("tabButton")).click();
        //Creamos un ArrayList y obtenemos las ventanas
        ArrayList<String> pantallas = new ArrayList<>(driver.getWindowHandles());
        //Nos cambiamos a la ventana deseada segun indice
        driver.switchTo().window(pantallas.get(0));
    }

    //Metodo a ejecutar despues de cada test
    @AfterEach
    public void closeWebDriver() {
        //Cerramos el driver
        driver.quit();
    }
}
