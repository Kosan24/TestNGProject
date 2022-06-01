package tests.project02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public class C02_SoftAssertion {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01(){
        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        WebElement boiteLogin=driver.findElement(By.xpath("//input[@id='user_login']"));
        boiteLogin.sendKeys("username");
        WebElement boitePassword=driver.findElement(By.xpath("//input[@id='user_password']"));
        boitePassword.sendKeys("password");
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();//appuyez sur la touche Sign in
        driver.navigate().back();
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click(); //Aller à la page PayBills
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();//appuyez sur la touche Pay Bills
        driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();//appuyez sur la touche Purchase Foreign Currency
        WebElement dropdown=driver.findElement(By.xpath("//select[@id='pc_currency']"));//Sélectionnez Zone euro dans le menu déroulant "Currency"
        Select select=new Select(dropdown);
        select.selectByValue("EUR");
        SoftAssert softAssert = new SoftAssert();
        String actualChoisir=select.getFirstSelectedOption().getText();
        String expectedChoisir="Eurozone (euro)";
        softAssert.assertEquals(actualChoisir,expectedChoisir,"Dropdown n'a pas pu être sélectionné correctement");
        List<WebElement> optionList = select.getOptions();
        String listActualOption=" ";
        for (WebElement each: optionList
             ) {
            listActualOption += "\"" + each.getText() + "\", ";
        }


        listActualOption=listActualOption.substring(0,listActualOption.length()-1);
        String expectedListString=" \"Select One\", \"Australia (dollar)\", \"Canada (dollar)\", \"Switzerland (franc)\", \"China \n" +
                "(yuan)\", \"Denmark (krone)\", \"Eurozone (euro)\", \"Great Britain (pound)\", \"Hong Kong \n" +
                "(dollar)\", \"Japan (yen)\", \"Mexico (peso)\", \"Norway (krone)\", \"New Zealand \n" +
                "(dollar)\", \"Sweden (krona)\", \"Singapore (dollar)\", \"Thailand (baht)\"";
        softAssert.assertEquals(listActualOption,expectedListString);
        softAssert.assertAll();

    }
}
