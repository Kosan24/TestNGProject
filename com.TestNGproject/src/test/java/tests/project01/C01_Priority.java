package tests.project01;

import org.testng.annotations.Test;

public class C01_Priority {

    @Test(priority = 9)
    public void youtubeTest(){
        System.out.println("le test Youtube a fonctionn√©");
    }

    @Test(priority = 8)
    public void amazonTest(){
        System.out.println("le test Amazon a fonctionn√©");
    }

    @Test(priority = 5)
    public void bestbuyTest(){
        System.out.println("le test Bestbuy a fonctionn√©");
    }
}

