package D05_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_MavenTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.saucedemo.com");
        Thread.sleep(1500);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(1500);
        driver.findElement(By.id("login-button")).click();

        String data = driver.findElement(By.xpath("//div[@class='inventory_item_name'][1]")).getText();
        driver.findElement(By.xpath("//div[@class='inventory_item_name'][1]")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();
        Thread.sleep(1500);
        String dataControl = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();

        if (data.equals(dataControl)){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }
        Thread.sleep(1500);
        driver.close();


    }
}
