package D06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClassAfterClass {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
    }

    @Test
    public void test02(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella" + Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']")).getText().contains("Nutella"));
    }

    @Test
    public void test03(){
        Assert.assertTrue(Integer.parseInt(driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']")).getText().split(" ")[2])>50);
    }
}
