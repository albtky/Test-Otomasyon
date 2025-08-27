package pages.LoginPageTest;

import com.thoughtworks.gauge.Step;
import core.Config;
import core.DriverManager;
import org.openqa.selenium.WebDriver;
import utils.LoginLocatorFactory;
import utils.Waits;

import java.time.Duration;

public class LoginPage {
    WebDriver driver = DriverManager.get();

    @Step("Giriş ekranına doğru git")
    public void goLogin() {
        System.out.println("Giriş ekranına ilerleme adımı gerçekleşiyor.");
        // driver.get(Config.getBaseUrl()); // statikse bu kalsın
        driver.get(Config.getBaseUrl());     // instance ise bunu kullan

        Waits.untilClickable(LoginLocatorFactory.getLocator("login_menu_button")).click();
        Waits.untilClickable(LoginLocatorFactory.getLocator("login_button_in_menu")).click();
    }

    @Step("kullanıcı adı ve sifre ile giriş yapar")
    public void doLogin() {
        System.out.println("Giriş yapma adımları gerçekleşiyor.");
        System.out.println("CWD=" + new java.io.File(".").getAbsolutePath());
        System.out.println("BASE_URL=" + Config.getBaseUrl());
        System.out.println("USEREMAİL=" + Config.getUserMail());
        System.out.println("PASSWORD=" + Config.getPassword());
        System.out.println("USERNAME=" + Config.getUserName());
        // String username = Config.getUserMail(); // statikse
        String userMail = Config.getUserMail();     // instance ise
        Waits.untilVisible(LoginLocatorFactory.getLocator("user_mail_input_text")).sendKeys(userMail);
        Waits.humanPause(Duration.ofSeconds(2));
        String password = Config.getPassword();
        Waits.untilVisible(LoginLocatorFactory.getLocator("user_password_input_text")).sendKeys(password);
        Waits.humanPause(Duration.ofSeconds(1));

        Waits.untilClickable(LoginLocatorFactory.getLocator("login_btn")).click();
    }

    @Step("")
    public void checkLoginSucces() {

    }
}
