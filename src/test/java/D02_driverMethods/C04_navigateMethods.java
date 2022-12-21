package D02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_navigateMethods {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.navigate().to("https://www.amazon.com"); // same as "driver.get()" method

        Thread.sleep(1500);
        driver.get("https://www.trendyol.com");

        // back to amazon
        driver.navigate().back();
        Thread.sleep(1500);

        // forward to trendyol
        driver.navigate().forward();

        Thread.sleep(1500);
        driver.quit();
    }
}
