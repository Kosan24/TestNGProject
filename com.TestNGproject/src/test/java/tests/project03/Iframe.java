package tests.project03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Iframe {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void iFrameTest(){
        driver.get(" https://the-internet.herokuapp.com/iframe ");
        WebElement demandeTextElement =driver.findElement(By.tagName("h3"));
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(demandeTextElement.isEnabled(),"Texte iframe non visible");
        System.out.println(demandeTextElement.getText());

        WebElement iFrame = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(iFrame);

        WebElement textBox =driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("==> Bonjour tout le Monde :-) <==");

        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();


        softAssert.assertAll();
    }
}
