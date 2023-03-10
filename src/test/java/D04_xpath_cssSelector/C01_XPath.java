package D04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_XPath {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // go to page > https://the-internet.herokuapp.com/add_remove_elements/
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(1500);

        // click on Add Element Button
        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElement.click();

        // Test that the Delete button is visible
        WebElement deleteButton = driver.findElement(By.xpath("//button[@class='added-manually']"));

        if (deleteButton.isDisplayed()){
            System.out.println("Delete button PASSED");
        }else {
            System.out.println("Delete button FAILED");
        }

        Thread.sleep(1500);

        // Press the Delete button and test that "Add/Remove Elements" is visible
        deleteButton.click();

        WebElement addRemoveButton = driver.findElement(By.xpath("//h3[text()='Add/Remove Elements']"));

        if (addRemoveButton.isDisplayed()){
            System.out.println("addRemoveButton button PASSED");
        }else{
            System.out.println("addRemoveButton button FAILED");
        }

        Thread.sleep(3000);
        driver.close();

    }
}
