package tests.project05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_MouseActions extends TestBase {

    @Test
    public void amazonList() throws InterruptedException {
        driver.get("https://www.amazon.com");

        Actions action = new Actions(driver);
        WebElement elementHello = driver.findElement(By.xpath("//*[@class='nav-line-1-container']"));
        action.moveToElement(elementHello).perform();
        Thread.sleep(3000);

        WebElement listElement = driver.findElement(By.xpath("//span[text()='Create a List']"));
        action.click(listElement).perform();

        String actualTitle=driver.getTitle();
        String textCherche="Your List";
        Assert.assertTrue(actualTitle.contains(textCherche));


    }
}
