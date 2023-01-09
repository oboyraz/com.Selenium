package D13_writeExcel_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.testBase;

public class C06_JSExecutor extends testBase {

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");

        WebElement sellLink = driver.findElement(By.xpath("//a[text()='Sell']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click()",sellLink);

    }

    @Test
    public void test02(){
        driver.get("https://www.sahibinden.com");
        WebElement link = driver.findElement(By.xpath("//a[@title='Avukatlık & Hukuki Danışmanlık']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",link);
        ReusableMethods.elementSS(link);
        System.out.println(link.getText());
        ReusableMethods.delay(3);
        jse.executeScript("arguments[0].click()",link);
        ReusableMethods.delay(3);

    }
}
