package tests.project04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Set;

public class C02_WindowHandle {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void windowHandleTest(){
        driver.get("https://the-internet.herokuapp.com/windows ");
        WebElement elementText = driver.findElement(By.tagName("h3"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(elementText.getText(),"Opening a new window","Texte sur une page différente de celle attendue");
        softAssert.assertEquals(driver.getTitle(),"The Internet","Titre sur la page différent de celui attendu");
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        String windowHandleValeur1=driver.getWindowHandle();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> valeurHandlesSet=driver.getWindowHandles();
        String valeurHandleWindow2="";

        for (String each:valeurHandlesSet
             ) {
            if (each.equals(windowHandleValeur1)){
                valeurHandleWindow2=each;
            }

        }
        driver.switchTo().window(valeurHandleWindow2);
        softAssert.assertEquals(driver.getTitle(),"New Window","Le nouveau title de la page est différent de celui demandé");
        WebElement elementTextedPage2=driver.findElement(By.tagName("h3"));
        softAssert.assertEquals(elementTextedPage2.getText(),"New Window","Le texte de la deuxième page est différent de celui demandé");
        driver.switchTo().window(windowHandleValeur1);
        softAssert.assertEquals(driver.getTitle(),"The Internet","Le titre de la première page n'est pas celui attendu");


        softAssert.assertAll();
    }

}
