package D08_handlingWindows;

import org.junit.Test;
import utilities.ReusableMethods;
import utilities.testBase;

public class C04_testBaseFirstTest extends testBase {

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        ReusableMethods.delay(3);
    }
}
