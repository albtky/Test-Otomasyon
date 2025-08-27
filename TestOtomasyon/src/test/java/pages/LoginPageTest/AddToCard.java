package pages.LoginPageTest;

import com.thoughtworks.gauge.Step;
import core.Config;
import core.DriverManager;
import org.openqa.selenium.WebDriver;
import utils.LoginLocatorFactory;
import utils.Waits;

public class AddToCard {
    WebDriver driver = DriverManager.get();

    @Step("Sepete ekleme otomasyonu")
    public void searchBoxInput() {
        System.out.println("Sepete Ekleme Özelliği Kontrol Ediliyor AŞAMASI");

    }
}
