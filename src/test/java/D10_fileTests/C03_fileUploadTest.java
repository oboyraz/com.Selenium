package D10_fileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.testBase;

public class C03_fileUploadTest extends testBase {
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement upload = driver.findElement(By.id("file-upload"));

        String pathFile = System.getProperty("user.home") + "\\OneDrive\\Masaüstü\\scrum.rtf";

        upload.sendKeys(pathFile);

        ReusableMethods.delay(3);

        driver.findElement(By.id("file-submit")).click();

        ReusableMethods.delay(3);

        Assert.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed());
    }
}
