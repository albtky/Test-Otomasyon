import org.example.HesapMakinesi;
import org.junit.jupiter.api.*;

public class HesapMakinesiTests {

    HesapMakinesi hesapMakinesi;


    @BeforeAll
    public static void setupClass(){
        System.out.println("Setup Class metodu çalışıtırldı");
    }



    @BeforeEach
    public  void setUp(){
        hesapMakinesi = new HesapMakinesi();
        System.out.println("Setup metodu çalıştırıldı");
    }

   @Test
    public void toplamaTesti(){
        double toplama_sonucu = hesapMakinesi.toplama(1.2,2.3);
        Assertions.assertEquals(3.5,toplama_sonucu);
    }
    @Test
    public void çıkarmaTesti(){
        double çıkarma_sonucu = hesapMakinesi.çıkarma(3,1);
        Assertions.assertEquals(2,çıkarma_sonucu);
    }
    @Test
    public void çarpmaTesti(){
        double çarpma_sonucu = hesapMakinesi.çarpma(2,3);
        Assertions.assertEquals(6,çarpma_sonucu);
    }

    @AfterEach
    public void tearDown(){
        System.out.println("teardown metodu çalıştıdlır.");
    }
    @AfterAll
    public static void tearDownClass(){
        System.out.println("teaaddownclass metodu çalıştırıldı.");
    }
}
