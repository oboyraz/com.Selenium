package D02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_driverMethods {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        // page source
        String pageSource = driver.getPageSource();
        String expectedWord = "tabsearchtextbox";

        if (pageSource.contains(expectedWord)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }

        Thread.sleep(3000);

        driver.close();

    }
}
