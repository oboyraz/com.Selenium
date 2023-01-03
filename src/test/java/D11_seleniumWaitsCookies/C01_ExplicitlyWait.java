package D11_seleniumWaitsCookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C01_ExplicitlyWait {
    protected WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @After
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void implicitlyWaitTest(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[@autocomplete='off']")).click();
        //String actData = driver.findElement(By.xpath("//p[@id='message']")).getText();
        //String expData = "It's gone!";
        //Assert.assertEquals(expData,actData);
        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).isDisplayed());

        driver.findElement(By.xpath("//button[text()='Add']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//p[@id='message']")).isDisplayed());

    }


    @Test
    public void explicitlyWaitTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[@autocomplete='off']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //String actData = driver.findElement(By.xpath("//p[@id='message']")).getText();
        //String expData = "It's gone!";
        //Assert.assertEquals(expData,actData);

        WebElement itsGoneElementi = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message"))));

        Assert.assertTrue(itsGoneElementi.isDisplayed());

        driver.findElement(By.xpath("//button[text()='Add']")).click();

        WebElement itsBack = wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message"))));

        Assert.assertTrue(itsBack.isDisplayed());
    }
}

