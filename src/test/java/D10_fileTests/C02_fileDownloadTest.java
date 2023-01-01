package D10_fileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.testBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class C02_fileDownloadTest extends testBase {
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//*[text()='Picture2.png']")).click();
        ReusableMethods.delay(5);

        String filePath = System.getProperty("user.home") + "\\Downloads\\Picture2.png";

        assertTrue(Files.exists(Paths.get(filePath)));
    }

    @Test
    public void test02(){
        String filePath = System.getProperty("user.home") + "\\OneDrive\\Masaüstü\\scrum.rtf";
        assertTrue(Files.exists(Paths.get(filePath)));
    }
}
