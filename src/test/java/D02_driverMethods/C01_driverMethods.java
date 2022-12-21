package D02_driverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_driverMethods {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");


        // title control

        String expectedTitle = "amazon";

        String actualResult = driver.getTitle();

        if (actualResult.contains(expectedTitle)){
            System.out.println("Title test PASSED");
        }else{
            System.out.println("Title test FAILED");
        }

        // URL control

        String expectedURL = "https://www.amazon.com/";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.equals(expectedURL)){
            System.out.println("URL test PASSES");
        }else{
            System.out.println("URL test FAILED >> " + driver.getCurrentUrl());
        }
        Thread.sleep(1500);

        driver.close();

    }
}
