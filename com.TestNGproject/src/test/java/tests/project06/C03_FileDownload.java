package tests.project06;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileDownload extends TestBase {

    @Test
    public void TestIsExist(){
        String fileExist=System.getProperty("user.home")+ "\\downloads\\FOTO2.png";
        Assert.assertTrue(Files.exists(Paths.get(fileExist)));


    }

    @Test
    public void testDownload()throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download ");
        driver.findElement(By.xpath("//a[text()='FOTO2.png']")).click();
        Thread.sleep(5000);

    }
}
