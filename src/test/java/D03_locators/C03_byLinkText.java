package D03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_byLinkText {
    public static void main(String[] args) throws InterruptedException {
        // go to amazon page
        // click Gift Cards link
        // Test if you go to the gift card page

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        //WebElement giftCards = driver.findElement(By.linkText("Gift Cards"));
        WebElement giftCards = driver.findElement(By.partialLinkText("Gift"));
        Thread.sleep(3000);
        giftCards.click();

        String expectedWord = "Gift Cards";
        String actualWord = driver.getTitle();

        if (actualWord.contains(expectedWord)){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Test FAILED");
        }

        Thread.sleep(3000);
        driver.close();
    }
}
