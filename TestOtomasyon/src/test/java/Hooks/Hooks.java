package Hooks;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.BeforeSuite;
import core.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.LoginLocatorFactory;
// Eğer bonigarcia WebDriverManager kullanıyorsan şunu da ekle:
// import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        LoginLocatorFactory.getLocator("login_menu_button"); // var mı yok mu hızlı check
    }
    @BeforeScenario
    public void beforeScenario() {
        // Eğer bonigarcia kullanıyorsan driver setup:
        // WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("start-maximized"); // zaten max açar, isterse manage da kullanılabilir
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/139 Safari/537.36");

        // **Sınıf alanını** set et (lokal değişken yaratma!)
        driver = new ChromeDriver(options);

        // İstersen redundanta rağmen:
        driver.manage().window().maximize();

        // Driver'ı singleton yöneticine ver
        DriverManager.set(driver);
    }

    @AfterScenario
    public void afterScenario() {
        DriverManager.quit();
        driver = null;
    }
}
