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

public class C03_windowHandle {

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
        driver.get("https://the-internet.herokuapp.com/iframe");
        Thread.sleep(2000);
        String mainPageWHV = driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();
        Set<String> SetofWHV = driver.getWindowHandles();
        Thread.sleep(2000);
        String elementalWHV = "";
        for (String each:SetofWHV) {
            if (!each.equals(mainPageWHV)){
                elementalWHV = each;
            }
        }

        driver.switchTo().window(elementalWHV);
        Thread.sleep(2000);
        String actData = driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText();
        String expData = "Elemental Selenium";

        Assert.assertEquals(expData,actData);
        driver.switchTo().window(mainPageWHV);
        Thread.sleep(2000);
        actData = driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        expData = "An iFrame containing the TinyMCE WYSIWYG Editor";

        Assert.assertEquals(expData,actData);
        Thread.sleep(2000);
    }
}
