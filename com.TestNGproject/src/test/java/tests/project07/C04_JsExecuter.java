package tests.project07;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C04_JsExecuter extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        JavascriptExecutor jse =(JavascriptExecutor) driver;
        WebElement elementSell = driver.findElement(By.xpath("//a[text()='Sell']"));
        jse.executeScript("arguments[0].click();",elementSell);
        Thread.sleep(5000);
    }
}
