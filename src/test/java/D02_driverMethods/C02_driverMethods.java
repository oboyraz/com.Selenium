package D02_driverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_driverMethods {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        // browser size control
        driver.manage().window().maximize(); // usually used
        System.out.println("max screen size >> " + driver.manage().window().getSize());
        System.out.println("max screen position >> " + driver.manage().window().getPosition());

        Thread.sleep(2000);

        driver.manage().window().fullscreen();
        System.out.println("full screen size >> " + driver.manage().window().getSize());
        System.out.println("full screen position >> " + driver.manage().window().getPosition());

        // browser position control
        Thread.sleep(2000);
        driver.manage().window().setPosition(new Point(100,100));
        driver.manage().window().setSize(new Dimension(700, 700));

        Thread.sleep(2000);
        driver.close(); // a browser close which is open
        driver.quit(); // all browsers close

    }

}
