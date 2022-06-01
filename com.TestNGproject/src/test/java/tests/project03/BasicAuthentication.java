package tests.project03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.time.Duration;

public class BasicAuthentication {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void authenticationTest(){
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        WebElement congratElementMessage =driver.findElement(By.tagName("p"));
        Assert.assertTrue(congratElementMessage.isDisplayed());
    }

    @AfterClass
    public void teardown(){
        driver.close();
    }
}
