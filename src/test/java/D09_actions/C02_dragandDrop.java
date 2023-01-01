package D09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.testBase;

import static org.junit.Assert.assertEquals;

public class C02_dragandDrop extends testBase {

    @Test
    public void test01(){
        driver.get("https://demoqa.com/droppable");
        WebElement dragMe = driver.findElement(By.id("draggable"));
        WebElement dropMe = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);

        actions.dragAndDrop(dragMe,dropMe).perform();
        String actData = driver.findElement(By.xpath("//div[@id='droppable']")).getText();
        String expData = "Dropped!";

        assertEquals(expData,actData);
        ReusableMethods.delay(3);
    }
}
