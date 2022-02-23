package Services;

import Data.Fitting;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


public class EReader {
    public static void read(String way, List<Fitting> line, int j) throws IOException {
        FileInputStream fis = new FileInputStream(way);
        Workbook wb = new HSSFWorkbook(fis);
        for (int i = 0; i < 1000; i++) {
            try {
                String s = wb.getSheetAt(j).getRow(i - 1).getCell(1).getStringCellValue();
                String secondName = wb.getSheetAt(j).getRow(i - 1).getCell(2).getStringCellValue();
                int count = (int) wb.getSheetAt(j).getRow(i - 1).getCell(6).getNumericCellValue();
                line.add(new Fitting(s, secondName, count));
            } catch (Exception ignored) {

            }
        }
    }
}