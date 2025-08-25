import com.thoughtworks.gauge.Step;

public class ExampleSteps {

    @Step("Merhaba yazdır")
    public void merhabaYazdir() {
        System.out.println("Merhaba Gauge!");
    }
}
