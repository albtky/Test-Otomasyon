import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class LoginTests {
    WebDriver driver;
    @BeforeEach
    public void beforeEach() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("start-maximized");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/139 Safari/537.36");

        driver = new ChromeDriver(options); // önce driver başlat
        driver.manage().window().maximize(); // sonra tam ekran yap

    }
    @Test
     void hbLoginTest() throws InterruptedException {
        HelperMethods helpers = new HelperMethods(driver); // 🔁 driver geçildi

        helpers.driverGet("https://www.hepsiburada.com");

        helpers.clickWhenClickable(By.id("myAccount"));
        helpers.sleep(6000);

        helpers.clickWhenClickable(By.id("login"));
        helpers.sleep(2000);

        helpers.clickWhenClickable(By.id("txtUserName"));
        helpers.txtInput(By.id("txtUserName"), "alperen.tky06@gmail.com");
        helpers.sleep(2000);

        helpers.clickWhenClickable(By.id("txtPassword"));
        helpers.txtInput(By.id("txtPassword"), "Tek1getir1");
        helpers.sleep(2000);

        helpers.clickWhenClickable(By.id("btnLogin"));
        helpers.sleep(2000);

        helpers.clickWhenClickable(By.id("myAccount"));
        helpers.sleep(2000);

        helpers.clickWhenClickable(By.xpath("//div[@class='sf-OldMyAccount-IMCbeURaRPyXfubeWCC7']//a[.='Siparişlerim']"));
        helpers.sleep(2000);

        helpers.clickWhenClickable(By.xpath("//small[.='Sipariş no:452 525 812 5']"));
        helpers.sleep(2000);

        helpers.clickWhenClickable(By.xpath("//a[.='Zippo Benzin']"));
        helpers.sleep(2000);

        helpers.clickWhenClickable(By.xpath("//button[@class='sf-Axjyr hWFMEy satldmja8yv z8QiDixMPSOOi87wSJ1D']/i[1]"));
        helpers.sleep(2000);

        helpers.clickWhenClickable(By.xpath("//button[.='Sepete git']"));
        helpers.sleep(2000);

        helpers.clickWhenClickable(By.cssSelector("[aria-label='Ürünü Azalt'] > [width='32']"));
        //Ürünü sepetten çıkartmak istediğinize emin misiniz uyarısı !!
        helpers.clickWhenClickable(By.cssSelector("[aria-label='Ürünü Azalt'] > [width='32']"));
        helpers.sleep(6000);

        helpers.clickWhenClickable(By.id("continue_step_btn"));
        helpers.sleep(2000);

        String successHtml = "<html><body style='display:flex;justify-content:center;align-items:center;height:100vh;background:white;font-family:sans-serif;'>" +
                "<h1 style='color:green;'>:))))) All of the test is successfully resulted in success</h1>" +
                "</body></html>";

        driver.get("data:text/html," + successHtml);
        helpers.sleep(8000);

    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }
}
