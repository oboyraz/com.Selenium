package D08_handlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_newWindow {

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
        driver.get("https://www.amazon.com");
        Thread.sleep(3000);
        String amazonWindowHandleValue = driver.getWindowHandle();

        // new tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.trendyol.com");

        String actURL = driver.getCurrentUrl();
        String expectedURL = "trendyol";

        Assert.assertTrue(actURL.contains(expectedURL));
        Thread.sleep(3000);

        driver.switchTo().window(amazonWindowHandleValue);
        actURL = driver.getCurrentUrl();
        expectedURL = "amazon";
        Assert.assertTrue(actURL.contains(expectedURL));
        Thread.sleep(3000);


    }
}
