package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {

    public static void delay(int second){

        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {

        }
    }


    public static void allPageSS(WebDriver driver){

        TakesScreenshot tss = (TakesScreenshot) driver;

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM_dd_HH-mm_ss");
        String date = ldt.format(dtf);
        String filePath = "target/ssPic/allPageSS_"+date+".png";

        File allPageSS = new File(filePath);

        File tempFile = tss.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(tempFile,allPageSS);
        } catch (IOException e) {

        }
    }

    public static void elementSS(WebElement searchResultElement) {

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM_dd_HH-mm_ss");
        String date = ldt.format(dtf);
        String filePath = "target/ssPic/elementSS_"+date+".png";

        File elementSS = new File(filePath);

        File tempFile = searchResultElement.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(tempFile,elementSS);
        } catch (IOException e) {

        }

    }
}
