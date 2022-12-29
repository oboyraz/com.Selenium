package D07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement actualText = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(actualText.isEnabled());

        driver.switchTo().frame("mce_0_ifr");

        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Hello people");

        Thread.sleep(3000);

        driver.switchTo().defaultContent();

        Assert.assertTrue(driver.findElement(By.xpath("//a[@href='http://elementalselenium.com/']")).isDisplayed());

        System.out.println(driver.findElement(By.xpath("//a[@href='http://elementalselenium.com/']")).getText());

    }
}
