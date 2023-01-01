package D10_fileTests;

import org.junit.Test;
import utilities.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_fileInputStream extends testBase {

    @Test
    public void test01() throws FileNotFoundException {
        String filePath = System.getProperty("user.home") + "\\OneDrive\\Masaüstü\\scrum.rtf";
        FileInputStream fis = new FileInputStream(filePath);
    }
}
