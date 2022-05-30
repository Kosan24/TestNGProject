package tests.projet01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C02_HandleDropdown {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void dropdownTest() throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement dropdownElément=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropdownElément);
        select.selectByIndex(10);
        System.out.println(select.getFirstSelectedOption().getText());

        Thread.sleep(3000);
        select.selectByVisibleText("Deals");
        Thread.sleep(3000);
        select.selectByValue("search-alias=computers-intl-ship");
        List<WebElement> optionList = select.getOptions();
        for (WebElement each: optionList
             ) {
            System.out.println(each.getText());
         }


    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }
}
