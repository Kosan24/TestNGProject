package tests.project06;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_KeyboardActions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        driver.get(" https://html.com/tags/iframe/");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        WebElement elementIframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(elementIframe);

        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();


        WebElement buttonPause=driver.findElement(By.xpath("//button[@title='Pause (k)']"));
        Assert.assertTrue(buttonPause.isEnabled());

        Thread.sleep(5000);


    }
}

