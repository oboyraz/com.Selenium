package D05_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_junitFramework {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("setUP");
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        System.out.println(driver.getTitle());
        Thread.sleep(1500);
    }

    @Test
    public void test02() throws InterruptedException {
        driver.get("https://www.facebook.com");
        System.out.println(driver.getTitle());
        Thread.sleep(1500);
    }

    @Test
    public void test03() throws InterruptedException {
        driver.get("https://www.youtube.com");
        System.out.println(driver.getTitle());
        Thread.sleep(1500);
    }

    @After
    public void tearDown(){
        System.out.println("tearDown");
        driver.close();
    }

}
