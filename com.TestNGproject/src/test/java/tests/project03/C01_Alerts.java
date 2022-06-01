package tests.project03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class C01_Alerts {

    WebDriver driver;
    WebElement textResultatElement;

    @BeforeClass
    public void setUp(){

            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.get(" https://the-internet.herokuapp.com/javascript_alerts ");

        }


    @Test
    public void acceptAlertTest(){
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        textResultatElement= driver.findElement(By.xpath("//p[@id='result']"));

        String actualResultatText = textResultatElement.getText();
        String expectedResultatText = "You successfully clicked an alert";
        Assert.assertEquals(actualResultatText,expectedResultatText);

    }


    @Test
    public void dismissAlertTest(){
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();//Cancel
        textResultatElement= driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultatElement = textResultatElement.getText();
        String motIndesirable = "successfuly";

        Assert.assertFalse(actualResultatElement.contains(motIndesirable));

    }

    @Test
    public void sendKeysAlertTest() throws InterruptedException {
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("AhmetKOSAN");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        textResultatElement= driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultatElement = textResultatElement.getText();
        String lenomqueJaiecrit = "AhmetKOSAN";
        Assert.assertTrue(actualResultatElement.contains(lenomqueJaiecrit));

    }

    @AfterClass
    public void teardown(){
        driver.close();
    }
}
