package tests.project07;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_JsExecutorScrollintoView extends TestBase {

    @Test
    public void scroolAction() throws InterruptedException {
        driver.get("https://www.hotelmycamp.com");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();

        driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]")).click();
        Thread.sleep(3000);

    }

    @Test
    public void scroolJsExecutor() throws InterruptedException {
        driver.get("https://www.hotelmycamp.com");
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        WebElement chambreRegard = driver.findElement(By.xpath("(//a[@class='btn-custom'])[2]"));
        jse.executeScript("arguments[0].scrollIntoView(true)",chambreRegard);
        Thread.sleep(3000);
        jse.executeScript("arguments[0].click();",chambreRegard);

    }
}
