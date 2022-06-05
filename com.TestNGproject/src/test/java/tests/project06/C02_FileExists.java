package tests.project06;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExists {

    @Test
    public void test01(){
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));

        // Testez que vous avez 'pom.xml' dans votre projet

        String fileExist = System.getProperty("user.dir")+"\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(fileExist)));
    }
}
