package tests.project04;

import org.testng.annotations.Test;
import utilities.TestBase;

public class TestBaseTest1 extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
    }
}
