package core;

import org.openqa.selenium.WebDriver;

public class DriverManager {
     private static WebDriver driver;
     public static void set(WebDriver d) {
         driver = d;
     }

     public static WebDriver get() throws IllegalStateException {
         if(driver == null){
             throw new IllegalStateException("Driver henüz oluşturulmadı! Check Hooks");
         }
         return driver;
     }
     public static void quit()
     {
         if(driver!=null){
             driver.quit();
             driver=null;
         }
     }
}
