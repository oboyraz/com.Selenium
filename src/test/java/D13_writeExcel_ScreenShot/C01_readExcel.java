package D13_writeExcel_ScreenShot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_readExcel {

    @Test
    public void test01() throws IOException {
        String filePath = "src/test/java/D12_webTablesExcel/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(1));

        printExcelData(20,3);



    }

    private void printExcelData(int row, int cell) throws IOException {
        String filePath = "src/test/java/D12_webTablesExcel/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(row).getCell(cell));

    }


}
