package D03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;
import java.time.Duration;
import java.util.List;

public class C02_byClassName {

    // go to amazon page and search for nutella
    // find the most expensive product on first page

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("Nutella" + Keys.ENTER);

        List<WebElement> prices = driver.findElements(By.className("a-price-whole"));

        int maxPrice = 0;
        String priceStr;
        int priceInt;
        for (WebElement each : prices) {

            priceStr = each.getText();
            priceInt = Integer.parseInt(priceStr);

            if (priceInt > maxPrice) {
                maxPrice = priceInt;
            }

        }

        System.out.println("Max price on first page >> " + maxPrice);

        Thread.sleep(3000);
        driver.close();
    }


}
