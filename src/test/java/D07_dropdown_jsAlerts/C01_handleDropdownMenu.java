package D07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_handleDropdownMenu {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");

        // select "book" from dropdown menu
        WebElement dropDownMenu = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDownMenu);
        select.selectByVisibleText("Books");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);

        Assert.assertTrue((driver.getTitle().contains("Java")));

        Thread.sleep(3000);
        // to overcome stale element exception
        dropDownMenu = driver.findElement(By.id("searchDropdownBox"));
        select = new Select(dropDownMenu);
        select.selectByVisibleText("Books");

        String actualSelectedOption = select.getFirstSelectedOption().getText();
        String expectedSelectOption = "Books";
        Assert.assertEquals(expectedSelectOption,actualSelectedOption);
        Thread.sleep(3000);


        // Test if the number of options in the menu is 24

        int optionsActual = select.getOptions().size();
        int optionsExpected = 28;
        Assert.assertEquals(optionsExpected,optionsActual);

    }
}
