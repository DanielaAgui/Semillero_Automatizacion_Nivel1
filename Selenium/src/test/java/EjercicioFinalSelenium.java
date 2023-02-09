import com.github.javafaker.Faker;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class EjercicioFinalSelenium {

    private WebDriver driver;
    private WebDriverWait wait;
    private ArrayList<Integer> precios = new ArrayList<>();
    private ArrayList<String> articulos = new ArrayList<>();
    private ArrayList<By> listaCarrito = new ArrayList();
    private ArrayList<String> listaCarritoString = new ArrayList<>();
    private WebElement name, country, city, creditCard, monthElement, yearElement;

    @BeforeEach
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");

        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void addProducts() {
        obtenerProducto();
        productosCarrito();
        obtenerValorTotal();
        System.out.println(sumarPrecios());
        System.out.println(obtenerValorTotal());

        Assertions.assertEquals(sumarPrecios(), obtenerValorTotal());
        System.out.println(articulos);
        System.out.println(listaCarritoString);

        Matchers.arrayContainingInAnyOrder(listaCarrito, articulos);

        ingresarInformacion();
        compararInformacion();
    }

    private void obtenerProducto() {
        Random random = new Random();

        for (int i = 0; i <= 2; i++) {
            int j = random.nextInt(9);
            if (j != 0) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='tbodyid']//div//h4[@class='card-title']//a[@href='prod.html?idp_=" + j + "']"))).click();

                String s = driver.findElement(By.xpath("//h2[@class='name']")).getText();
                articulos.add(s);

                obtenerPrecios();
                addToCartButton();
                acceptAlert();

                if (i < 2) {
                    driver.findElement(By.xpath("//*[@class='nav-item active']")).click();
                } else {
                    driver.findElement(By.id("cartur")).click();
                }

            } else {
                j = random.nextInt(9);
            }
        }
    }

    private void addToCartButton() {
        driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']")).click();
    }

    private void obtenerPrecios() {
        int precio = Integer.parseInt(driver.findElement(By.xpath("//h3[@class='price-container']")).getText()
                .replace("$", "").replace(" *includes tax", ""));
        precios.add(precio);
    }

    private void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    private int sumarPrecios() {
        int acumulador = 0;

        for (int i = 0; i < precios.size(); i++) {
            acumulador += precios.get(i);
        }
        return acumulador;
    }

    private int obtenerValorTotal() {
        String totalString = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='totalp']"))).getText();
        int total = Integer.parseInt(totalString);
        return total;
    }

    private void ingresarInformacion() {
        Faker faker = new Faker();
        LocalDate localDate = LocalDate.now();

        driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();

        name = driver.findElement(By.id("name"));
        name.sendKeys(faker.name().fullName());

        country = driver.findElement(By.id("country"));
        country.sendKeys(faker.country().name());

        city = driver.findElement(By.id("city"));
        city.sendKeys(faker.country().capital());

        creditCard = driver.findElement(By.id("card"));
        creditCard.sendKeys(faker.business().creditCardNumber());

        monthElement = driver.findElement(By.id("month"));
        String month = String.valueOf(localDate.getMonth());
        monthElement.sendKeys(month);

        yearElement = driver.findElement(By.id("year"));
        String year = String.valueOf(localDate.getYear());
        yearElement.sendKeys(year);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='purchaseOrder()']"))).click();
    }

    private void compararInformacion() {
        String texto = driver.findElement(By.xpath("//p[@class='lead text-muted ']")).getText();
        Assertions.assertTrue(texto.contains(name.getText()));
        Assertions.assertTrue(texto.contains(String.valueOf(obtenerValorTotal())));
        Assertions.assertTrue(texto.contains(creditCard.getText()));
        driver.findElement(By.xpath("//button[@class='confirm btn btn-lg btn-primary']")).click();
    }

    private void productosCarrito() {
        for (int j = 1; j <= 3; j++) {

            By prod = By.xpath("//table[1]//tbody//tr[" + j + "]//td[2]");
            if (driver.findElements(prod).size() != 0) {
                listaCarrito.add(prod);
            }
        }

        for (int i = 0; i < listaCarrito.size(); i++) {
            String productosCarrito = driver.findElement(listaCarrito.get(i)).getText();
            listaCarritoString.add(productosCarrito);
        }
    }

    @AfterEach
    public void closeWeb() {
        driver.quit();
    }
}
