package D12_webTablesExcel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.testBase;

import java.util.List;

public class C01_webTables extends testBase {
    @Test
    public void test01(){

        driver.get("https://demoqa.com/webtables");

        WebElement header = driver.findElement(By.xpath("//*[@class='rt-thead -header']"));
        System.out.println(header.getText());
        System.out.println("*".repeat(100));
        List<WebElement> thirthColumn = driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));

        System.out.println("3. column name: " + thirthColumn.get(2).getText());

        // All data in table

        WebElement allData = driver.findElement(By.xpath("//div[@class='rt-table']"));
        System.out.println("body: " + allData.getText());

        //How many data is not null

        List<WebElement> notNullData = driver.findElements(By.xpath("//div[@class='rt-td']"));
        int count=0;
        for (WebElement eachData:notNullData) {
            if (!(eachData.getText().equals("") || eachData.getText().equals(" "))){
                count++;
            }
        }
        System.out.println(count);

        // number of rows in the table

        List<WebElement> numberOfRows = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("number of rows in the table" + numberOfRows.size());

        // number of columns in the table

        List<WebElement> numberOfColumns = driver.findElements(By.xpath("rt-resizable-header-content"));

        System.out.println("number of columns in the table" + numberOfColumns.size());

        List<WebElement> thirthXolumnsData = driver.findElements(By.xpath("(//div[@class='rt-tr-group'])//div[1]/div[3]"));

        for (WebElement eachData:thirthXolumnsData) {
            if (!(eachData.getText().equals("") || eachData.getText().equals(" "))){
                System.out.println(eachData.getText());
            }
        }

        List<WebElement> tableValues = driver.findElements(By.xpath("//div[@class='rt-tbody']"));

        for (int i = 0; i <tableValues.size() ; i++) {
            if (tableValues.get(i).getText().equals("Kierra")){
                System.out.println("Sallary: " + tableValues.get(i+4).getText());
            }
        }


    }
}
