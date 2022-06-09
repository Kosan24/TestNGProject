package tests.project07;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        Set<Cookie> cookieSet = driver.manage().getCookies();
        System.out.println(cookieSet);

        int compteur =1;
        for (Cookie each: cookieSet
             ) {
            System.out.println(compteur + ". cookie : " + each);
            compteur++;

        }
        Assert.assertTrue(cookieSet.size()>5);
        Cookie cookiesi18n = driver.manage().getCookieNamed("i18n-prefs");
        System.out.println("valeur de cookiesi18n : " + cookiesi18n);
        Assert.assertTrue(driver.manage().getCookieNamed("i18n-prefs").getValue().equals("USD"));
    }
}
