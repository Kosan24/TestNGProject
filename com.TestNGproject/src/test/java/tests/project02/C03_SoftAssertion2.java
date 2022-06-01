package tests.project02;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssertion2 {

    @Test
    public void test(){
        int a=10;
        int b=20;
        int c=30;

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(a,b,"1. test échoué "); //failed
        softAssert.assertTrue(a>b,"2. test échoué"); //failed
        softAssert.assertTrue(a<c,"3. test échoué");//passed
        softAssert.assertTrue(c>b,"4. test échoué"); //passed
        softAssert.assertTrue(c<a,"5. test échoué");//failed

        softAssert.assertAll();

    }
}
