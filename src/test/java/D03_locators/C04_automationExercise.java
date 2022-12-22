package D03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_automationExercise {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.automationexercise.com/");
        List<WebElement> linkList = driver.findElements(By.tagName("a"));

        int expectedSize = 147;
        int actualSize = linkList.size();;
        String expectedStr = "Products";

        if (expectedSize==actualSize){
            System.out.println("Number of links Test PASSED");
        }else {
            System.out.println("Number of links Test FAILED");
        }

        for (WebElement each: linkList) {
            if (each.getText().contains(expectedStr)){
                each.click();
                if (driver.findElement(By.id("sale_image")).isDisplayed()){
                    System.out.println("Special offer Test PASSED");
                    break;
                }else{
                    System.out.println("Special offer Test FAILED");
                    break;
                }
            }
        }
        Thread.sleep(3000);
        driver.close();

    }
}
