import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTests {


    @Test
    void hbLoginTest()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.hepsiburada.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement accountBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("myAccount")));
        accountBtn.click();


        WebElement loginBtn  = wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));
        loginBtn.click();
    }
}
