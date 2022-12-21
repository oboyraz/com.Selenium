package D02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_windowHandleValue {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

        System.out.println(driver.getWindowHandle());


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.trendyol.com");

        System.out.println(driver.getWindowHandle());
        Thread.sleep(1500);

        driver.quit();
    }
}
