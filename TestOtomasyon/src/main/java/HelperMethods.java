import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class HelperMethods {
    WebDriver driver;

    public HelperMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void driverGet(String URL)
    {
        driver.get(URL);
    }
    public void clickWhenClickable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void txtInput(By locator, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);

    }

    public void sleep(int seconds) throws InterruptedException {
        Thread.sleep(seconds);
    }



    public void productCheckInList(By locator_Amount,
                                   By locator_productDetail,
                                   By locator_product_title)
    {
        //kaç tane ürün var onu string içerisinden ayrıştır
        // for döngüsüne ekle
        //tek tek ürünlerin içerisine gir ve
        // title'larında aranan (class = xeL9CQ3JILmYoQPCgDcl) isim var mı kontrol et

        WebElement productAmount =  driver.findElement(locator_Amount);

    }
}
