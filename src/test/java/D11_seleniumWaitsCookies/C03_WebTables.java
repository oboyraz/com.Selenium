package D11_seleniumWaitsCookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.testBase;

import java.util.List;
import java.util.Set;

public class C03_WebTables extends testBase {

    @Test
    public void test01(){

        driver.get("https://www.amazon.com");

        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.END).perform();

        WebElement table = driver.findElement(By.xpath("//table[@class='navFooterMoreOnAmazon']"));

        System.out.println(table.getText());

        List<WebElement> tableRows = driver.findElements(By.xpath("//*[@id='navFooter']/div[4]/table/tbody/tr"));


        Assert.assertEquals(9,tableRows.size());

        for (WebElement eachRow:tableRows) {
            System.out.println(eachRow.getText());
        }

        List<WebElement> tableColumn = driver.findElements(By.xpath("//*[@id='navFooter']/div[4]/table/tbody/tr[1]/td"));

        Assert.assertEquals(13,tableColumn.size());

        List<WebElement> fifthColumn = driver.findElements(By.xpath("//*[@id='navFooter']/div[4]/table/tbody/tr/td[5]"));

        System.out.println("*".repeat(100));
        for (WebElement fiftColumnValue:fifthColumn) {
            System.out.println(fiftColumnValue.getText());
        }

        System.out.println("*".repeat(100));

        String rowColumnValues = getRowandColumnValue(5,3);
        System.out.println(rowColumnValues);
        ReusableMethods.delay(3);
    }

    private String getRowandColumnValue(int row, int column) {

        String rowColumnValue = driver.findElement(By.xpath("//*[@id='navFooter']/div[4]/table/tbody/tr" + "["+row+"]" + "/td" +"["+column+"]" )).getText();

        return rowColumnValue;
    }
}
