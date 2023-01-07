package D12_webTablesExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C03_readExcel {
    @Test
    public void test01() throws IOException {
        String filePath = "C:\\Users\\AIVISIONTECH\\OneDrive\\Masaüstü\\com.Selenium\\src\\test\\java\\D12_webTablesExcel\\ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sayfa1").getRow(0).getCell(1));

        String data = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println(data);

        String actCap = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        String expCap = "Kabil";

        Assert.assertEquals(expCap,actCap);

        // find number of rows

        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum()+1);

        // find number of rows which are used in Sayfa2

        System.out.println(workbook.getSheet("Sayfa2").getLastRowNum());
        System.out.println(workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());

        // let's save english country names and capitals as a map

        Map<String,String> countriesMap = new TreeMap<>();
        int numberOfRows = workbook.getSheet("Sayfa1").getLastRowNum();
        String key = "";
        String value= "";
        for (int i = 0; i <=numberOfRows ; i++) {
            key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ", " +
                    workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + ", " +
                    workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            countriesMap.put(key,value);
        }

        System.out.println(countriesMap);

    }
}
