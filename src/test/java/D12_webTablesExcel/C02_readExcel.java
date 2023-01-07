package D12_webTablesExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_readExcel {
    @Test
    public void test01() throws IOException {

    String filePath = "C:\\Users\\AIVISIONTECH\\OneDrive\\Masaüstü\\com.Selenium\\src\\test\\java\\D12_webTablesExcel\\ulkeler.xlsx";

    FileInputStream fis = new FileInputStream(filePath);

    Workbook workbook = WorkbookFactory.create(fis);

    Sheet sheet = workbook.getSheet("Sayfa1");

        // to write Angola (5. index)

    Row row = sheet.getRow(5);

    Cell cell = row.getCell(2);

    System.out.println(cell);

    }
}
