import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestConfiguracionNavegador {

    @Test
    public void probandoConfig() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.quit();
    }
}
