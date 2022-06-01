package tests.project01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class C03_Dropdown {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void dropdownTest(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropdownElement);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        List<WebElement> optionList = select.getOptions();
        for (WebElement each: optionList
             ) {
            System.out.println(each.getText());
        }
        //Trouvez la taille de la liste déroulante.
        //Testez qu'il y en a 4 dans Dropdown
        int actualsize = optionList.size();
        int expectedSize = 4;

        Assert.assertEquals(actualsize,expectedSize,"Le nombre d'options ne répond pas aux attentes");
    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }
}
