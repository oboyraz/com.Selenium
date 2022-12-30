package D08_handlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C02_windowHandles {
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
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        Thread.sleep(1500);
        String mainPageWHV = driver.getWindowHandle();
        String actText = driver.findElement(By.tagName("h3")).getText();
        String expText = "Opening a new window";
        Thread.sleep(1500);
        Assert.assertEquals(expText,actText);
        Assert.assertEquals("The Internet",driver.getTitle());
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(1500);
        Set<String> SetofWHV = driver.getWindowHandles();

        String clickHereWHV = "";
        for (String each:SetofWHV) {
            if (!each.equals(mainPageWHV)){
                clickHereWHV = each;
            }
        }

        driver.switchTo().window(clickHereWHV);
        Thread.sleep(1500);
        actText = driver.findElement(By.tagName("h3")).getText();
        expText = "New Window";
        Thread.sleep(1500);

        Assert.assertEquals(expText,actText);
        driver.switchTo().window(mainPageWHV);
        Thread.sleep(1500);
        actText = driver.getTitle();
        expText = "The Internet";
        Assert.assertEquals(expText,actText);
        Thread.sleep(1500);
    }


}
