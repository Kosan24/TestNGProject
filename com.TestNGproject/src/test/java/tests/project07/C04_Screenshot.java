package tests.project07;

import org.openqa.selenium.*;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;

public class C04_Screenshot extends TestBase {

    @Test
    public void screenTest(){
        driver.get("https://www.google.be");
        driver.findElement(By.xpath("//div[text()='Tout accepter']")).click();

        TakesScreenshot tss = (TakesScreenshot) driver;

       // File pageScreenshot = new File("src//pageFileScreenShot.png");

        //pageScreenshot = tss.getScreenshotAs(OutputType.FILE);

        WebElement elementLogo = driver.findElement(By.xpath("(//img[@alt='Google'])[1]"));

        File imageLogo = new File("src/logo.png");
        imageLogo = elementLogo.getScreenshotAs(OutputType.FILE);



    }

}
