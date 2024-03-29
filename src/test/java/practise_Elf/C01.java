package practise_Elf;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01 {
    // ...Exercise1...
    // BeforeClass ile driver olusturun ve class icinde static yapin
    // Maximize yapin 15sn bekletin
    // http://www.google.com/ adresine gidin
    // Arama kutusuna "Green Mile" yazip cikan sonuc sayisini yazdirin
    // Arama kutusuna "Premonition" yazip,cikan sonuc sayisini yazdirin
    // Arama kutusuna  "The Curious Case of Benjamin Button" yazip, cikan sonuc sayisini yazdirin
    // AfterClass ile kapatin
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions co=new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown() {
       //driver.close();
    }
    @Before
    public void testtenOnce() {
     driver.get("https://google.com");
    }
    @After
    public void testtenSonra() {
        System.out.println("sonuc yazisi :"+driver.findElement(By.xpath("//div[@id='result-stats']")).getText());
    }
    @Test
    public void test1(){
       driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Green Mile", Keys.ENTER);
    }
    @Test
    public void test2(){
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Premonition", Keys.ENTER);
    }
    @Test
    public void test3(){
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("The Curious Case of Benjamin Button", Keys.ENTER);
    }
}
