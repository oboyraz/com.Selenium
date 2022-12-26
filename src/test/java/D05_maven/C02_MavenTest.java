package D05_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://zero.webappsecurity.com");
        driver.findElement(By.id("signin_button")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("pay_bills_tab")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("500");
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");
        driver.findElement(By.id("pay_saved_payees")).click();
        Thread.sleep(1500);
        String expData = "The payment was successfully submitted.";
        String actData = driver.findElement(By.id("alert_content")).getText();

        if (expData.equals(actData)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        Thread.sleep(1500);
        driver.close();

    }
}
