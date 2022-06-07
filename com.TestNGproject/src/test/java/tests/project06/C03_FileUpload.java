package tests.project06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_FileUpload extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement choisirFileButton=driver.findElement(By.id("file-upload"));

        String filePng=System.getProperty("user.home") + "\\Desktop\\deneme\\FOTO2.png";
        choisirFileButton.sendKeys(filePng);
        driver.findElement(By.id("file-submit")).click();
        //"Fichier téléchargé!" Testons que le texte s'affiche.
        WebElement elemenEcrit=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(elemenEcrit.isDisplayed());

        Thread.sleep(7000);
    }
}
