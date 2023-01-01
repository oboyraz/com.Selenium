package D09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.testBase;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C01_mouseActions extends testBase {

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String mainPageWHV = driver.getWindowHandle();
        Actions actions = new Actions(driver);
        WebElement frame = driver.findElement(By.id("hot-spot"));
        actions.contextClick(frame).perform();
        String actData = driver.switchTo().alert().getText();
        String expData = "You selected a context menu";
        assertEquals(expData,actData);
        driver.switchTo().alert().accept();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        Set<String> setofWHV = driver.getWindowHandles();

        String elementalSeleniumWHV = "";

        for (String each:setofWHV) {
            if (!each.equals(mainPageWHV)){
                elementalSeleniumWHV = each;
            }
        }
        driver.switchTo().window(elementalSeleniumWHV);

        actData = driver.findElement(By.tagName("h1")).getText();
        expData = "Elemental Selenium";

        assertEquals(expData,actData);

        ReusableMethods.delay(3);
    }
}
