package tests.project06;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_FileDownload extends TestBase {

    @Test
    public void TestIsExist() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download ");
        driver.findElement(By.xpath("//a[.='BIKER POP LIKE NORMAL DAD BUT COOLER (2).png']")).click();
        Thread.sleep(5000);

    }

    @Test
    public void testDownload(){

    }
}
