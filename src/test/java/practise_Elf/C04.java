package practise_Elf;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C04 {
     /* note:
    JavaScriptExecutor  nedir?
    JavaScriptExecutor, JavaScript'i Selenium Web sürücüsü araciligiyla calistirmaya yardimci olan bir arayuzdur.
    JavaScriptExecutor, javascript'i secilen pencerede veya gecerli sayfada calistirmak icin "executescript" ve "executeAsyncScript"
    olmak uzere iki yontem sunar.

    JavaScriptExecutor'a neden ihtiyacimiz var?
    Selenium Webdriver'da, bir web sayfasindaki islemleri tanimlamak ve gerceklestirmek icin
    XPath,CSS vb. gibi konum belirliyiciler kullanilir.
    Bu konum belirliyicilerin calismamasi durumunda JavaScriptExecutor'i kullanabilirsiniz.
    Bir web ogesinde istenen bir islemi gerceklestirmek icin JavaScriptExecutor'i kullanabilirsiniz
    Selenium javaScriptExecutor'i destekler.Ekstra bir eklenti veya eklentiye gerek yoktur.
    JavaScriptExecutor kullanmak icin komut dosyasinda(org.openqa.selenium.JavascriptExecutor) ice aktarmaniz yeterlidir.

          executeScript araciligiyla sayfayi 1000 piksel kaydirin.
          Javascript yontemi ScrollBy(), web sayfasini belirli piksel sayisina kaydirir.

          ScrollBy()  yontemlerinin sozdizimi soyledir:
          executeScript("window.scrollBy(x-piksel,y-piksel)"); ya da js.executeScript("scroll(x,y);");
          x-piksel x eksenindeki sayidir,sayi pozitifse sola,sayi negatifse saga hareket eder.
          y-piksel y eksenindeki sayidir,sayi pozitifse asagidogru,sayi negatifse yukari dogru hareket eder.

          Ornek:
          js.executeScript("window.scrollBy(0,1000)");  // Dikey olarak 1000 piksel asagi kaydir.
     */
    /*=====================================================================================================================================================*/
    // ...Exercise4...
    // https://www.teknosa.com/ adresine gidiniz
    // Search box senKeys "oppo" and keys Enter
    // sonuc sayisini yazdiriniz
    // cikan ilk urune tiklayiniz
    // sepete ekleyiniz
    // sepetime git 'e tiklayiniz
    // consaol'da "Siparis Özeti" webelementinin text'ini yazdiriniz
    // Alisverisi tamamlayiniz
    // son olarak da "Teknosa'ya hos geldiniz" webelementinin text 'ini yazdiriniz
    // driver'i kapatiniz
     static WebDriver driver;
     public static void main(String[] args) {
         WebDriverManager.chromedriver().setup();

         ChromeOptions co=new ChromeOptions();
         co.addArguments("--remote-allow-origins=*");

         driver = new ChromeDriver(co);
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
         driver.get("https://www.teknosa.com/");
         driver.manage().deleteAllCookies();

      // ChromeOptions op=new ChromeOptions();
       //op.addArguments("--disable-notifications"); /* disable notification parameter */
         // Search box sendKeys "oppo" and keys Enter
         driver.findElement(By.id("search-input")).sendKeys("oppo"+ Keys.ENTER);

        // System.out.println("sonuc yazisi :" + driver.findElement(By.xpath("//div[@class='plp-info']")));

         // sonuc sayisini yazdiriniz
         WebElement sonucSayisiElementi= driver.findElement(By.xpath("//div[@class='plp-info']"));
         System.out.println(("Sonuc sayisi==> ")+sonucSayisiElementi.getText());


         // cikan ilk urune tiklayiniz
         driver.findElement(By.xpath("(//a[@class='prd-link'])[1]")).click();
         // sepete ekleyiniz
         /***********************************************************************************/
         JavascriptExecutor js= (JavascriptExecutor) driver;
         js.executeScript("scrollBy(0,200)");//===> **** Sayfayi asagi yönde 200px indirir *****
         /***********************************************************************************/
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
         driver.findElement(By.xpath("(//button[@id='addToCartButton'])[1]")).click();
         // sepetime git 'e tiklayiniz
         driver.findElement(By.xpath("//a[@class='btn btn-secondary']")).click();
         // consaol'da "Siparis Özeti" webelementinin text'ini yazdiriniz
         WebElement siparisOzeti=driver.findElement(By.xpath("//div[@class='cart-sum-body']"));
         System.out.println(siparisOzeti.getText());
         // Alisverisi tamamlayiniz
         driver.findElement(By.xpath("//span[text()='Alışverişi Tamamla']")).click();
         // son olarak da "Teknosa'ya hos geldiniz" webelementinin text 'ini yazdiriniz
         System.out.println(driver.findElement(By.xpath("//div[text()='Teknosa’ya hoş geldiniz']")).getText());
         // driver'i kapatiniz
         driver.close();
     }

}
