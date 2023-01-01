package D09_actions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.testBase;

public class C05_fillForm extends testBase {

    @Test
    public void test01(){
        driver.get("https://www.facebook.com");
        Actions actions = new Actions(driver);
        Faker faker = new Faker();
        WebElement createAccount = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        actions.click(createAccount).perform();

        WebElement name = driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        String mailAdress = faker.internet().emailAddress();
        actions
                .click(name)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(mailAdress)
                .sendKeys(Keys.TAB)
                .sendKeys(mailAdress)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("23")
                .sendKeys(Keys.TAB)
                .sendKeys("Ara")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT).perform();


        driver.findElement(By.xpath("//button[@class='_6j mvm _6wk _6wl _58mi _6o _6v']")).click();

        ReusableMethods.delay(30);

    }
}
