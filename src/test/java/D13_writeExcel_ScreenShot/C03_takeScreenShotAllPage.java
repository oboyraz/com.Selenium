package D13_writeExcel_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.testBase;

import java.io.File;
import java.io.IOException;

public class C03_takeScreenShotAllPage extends testBase {
    @Test
    public void test01() throws IOException {

        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella" + Keys.ENTER);

        WebElement searchResultElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expData = "Nutella";
        String actData = searchResultElement.getText();

        Assert.assertTrue(actData.contains(expData));

        ReusableMethods.allPageSS(driver);
        ReusableMethods.delay(3);


    }
}
