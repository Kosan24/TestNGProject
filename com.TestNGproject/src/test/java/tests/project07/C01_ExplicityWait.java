package tests.project07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicityWait extends TestBase {

    @Test
    public void implicityWaitTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //Appuyez le touche 'Remove'
        driver.findElement(By.xpath("//button[.='Remove']")).click();
        WebElement itsGoneElement = driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElement.isDisplayed());
        Thread.sleep(3000);

        //Appuyez le touche 'Add'
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        WebElement itsBackElement = driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBackElement.isDisplayed());
        Thread.sleep(3000);

    }

    @Test
    public void explicityWaitTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        driver.findElement(By.xpath("//button[.='Remove']")).click();
        //WebElement itsGoneElement = driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        //wait.until(ExpectedConditions.visibilityOf(itsGoneElement));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
        WebElement itsGoneElement = driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElement.isDisplayed());
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[text()='Add']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));
        WebElement itsBackElement = driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBackElement.isDisplayed());



    }
}
