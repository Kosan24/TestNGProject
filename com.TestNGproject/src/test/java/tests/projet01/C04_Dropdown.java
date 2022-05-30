package tests.projet01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C04_Dropdown {
    WebDriver driver;
    WebElement dropdownElement;
    Select select;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void Testdropdown1(){
        driver.get("https://www.amazon.com");
        dropdownElement = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropdownElement);
        List<WebElement> optionList = select.getOptions();
        int actualOptionNumero = optionList.size();
        int expectedOptionNumero = 45;
        Assert.assertEquals(actualOptionNumero,expectedOptionNumero);
    }




}
