package tests.project07;

import com.beust.ah.A;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.security.Key;

public class C02_Faker extends TestBase {

    @Test
    public void facebookTest() throws InterruptedException {
        driver.get("https://facebook.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Autoriser les cookies essentiels et optionnels']")).click();
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement boitePrenom=driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        actions.click(boitePrenom).
                sendKeys(faker.name().name())

                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())

                .sendKeys(Keys.TAB)
                .sendKeys(email)

                .sendKeys(Keys.TAB)
                .sendKeys(email)

                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())


                .sendKeys(Keys.TAB)
                .sendKeys("jan")

                .sendKeys(Keys.TAB)
                .sendKeys("22")

                .sendKeys(Keys.TAB)
                .sendKeys("1984")



                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT) //Choisir sex
                .sendKeys(Keys.TAB).
                perform();

        WebElement choisirHomme = driver.findElement(By.xpath("//input[@value='2']"));
        Assert.assertFalse(choisirHomme.isSelected());

        Thread.sleep(1000);






    }
}
