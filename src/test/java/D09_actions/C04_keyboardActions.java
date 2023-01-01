package D09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.testBase;

public class C04_keyboardActions extends testBase {
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        Actions actions = new Actions(driver);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        actions
                .click(searchBox)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();

        ReusableMethods.delay(3);

        String actData = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        String expData = "Samsung A71";

        Assert.assertTrue(actData.contains(expData));

        ReusableMethods.delay(3);
    }
}
