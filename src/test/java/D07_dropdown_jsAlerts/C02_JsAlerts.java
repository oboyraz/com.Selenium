package D07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_JsAlerts {
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
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "I am a JS Alert";
        Thread.sleep(3000);

        Assert.assertEquals(expectedAlertText,actualAlertText);

        // click ok
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

    }

    @Test
    public void test02() throws InterruptedException {
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        Assert.assertEquals("You clicked: Cancel",driver.findElement(By.id("result")).getText());
        Thread.sleep(3000);

    }
    @Test
    public void test03() throws InterruptedException {

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("heyyou");
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("heyyou"));
        Thread.sleep(3000);
    }
}
