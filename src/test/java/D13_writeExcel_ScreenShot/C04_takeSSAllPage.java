package D13_writeExcel_ScreenShot;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.testBase;

import java.io.IOException;

public class C04_takeSSAllPage extends testBase {
    @Test
    public void test01(){
        driver.get("https://www.trendyol.com");

        String expUrl = "trendyol";
        String actUrl = driver.getCurrentUrl();

        Assert.assertTrue(actUrl.contains(expUrl));

        ReusableMethods.allPageSS(driver);

    }
}
