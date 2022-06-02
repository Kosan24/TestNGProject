package tests.project04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class C01_WindowHandle {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void handleWindow() throws InterruptedException {
        driver.get("https://www.amazon.com");
        String valeurWindowHandle1 = driver.getWindowHandle();
        System.out.println("Window handle de la première page : " + driver.getWindowHandle());

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        System.out.println("Window handle de la 2. page : " + driver.getWindowHandle());
        String valeurWindowHandle2 = driver.getWindowHandle();

        Set<String > valeurHandleSet = driver.getWindowHandles();
        System.out.println(valeurHandleSet);
        Thread.sleep(3000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");

        driver.switchTo().window(valeurWindowHandle1);
        WebElement boitecherhe = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        boitecherhe.sendKeys("Nutella" + Keys.ENTER);
        Thread.sleep(5000);

        driver.switchTo().window(valeurWindowHandle2);
        Assert.assertTrue(driver.getTitle().contains("bestbuy"));
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }
}





















