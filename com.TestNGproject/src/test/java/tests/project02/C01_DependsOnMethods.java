package tests.project02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_DependsOnMethods {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void logTest(){
        driver.get("https://www.amazon.com");
        WebElement logElement=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logElement.isDisplayed());
    }

    @Test (dependsOnMethods = "logTest")
    public void searchTest(){
        WebElement searchBoite=driver.findElement(By.id("twotabsearchtextbox"));
        searchBoite.sendKeys("Nutella" + Keys.ENTER);
        String actualTitle=driver.getTitle();
        String motRecherche="Nutella";

        Assert.assertTrue(actualTitle.contains(motRecherche));
    }

    @Test (dependsOnMethods = "searchTest")
    public void prixTest(){
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        WebElement elementPrixProduit =driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[2]"));
        String prixElementString=elementPrixProduit.getText();
        String prixCherche="$14.99";

        Assert.assertTrue(prixElementString.contains(prixCherche));
    }
}
