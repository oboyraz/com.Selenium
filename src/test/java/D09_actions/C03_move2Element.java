package D09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.testBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C03_move2Element extends testBase {
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("nav-link-accountList"))).perform();
        driver.findElement(By.linkText("Create a List")).click();

        WebElement yourList = driver.findElement(By.id("my-lists-tab"));

        assertTrue(yourList.isDisplayed());
        ReusableMethods.delay(3);

    }
}
