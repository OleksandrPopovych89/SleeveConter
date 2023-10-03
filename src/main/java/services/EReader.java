package services;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import pipedetails.Fitting;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


public final class EReader {
    private EReader() {
    }

    public static void read(String way, List<Fitting> line, int j) throws IOException {

        try (FileInputStream fis = new FileInputStream(way);
             Workbook wb = new HSSFWorkbook(fis)) {
            mapping(line, j, wb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void mapping(List<Fitting> line, int j, Workbook wb) {
        Sheet sheet = wb.getSheetAt(j);
        if (sheet == null) {
            System.out.println("Sheet is null");
            return;
        }

        for (int i = 0; i < 1000; i++) {
            try {
                Row row = sheet.getRow(i - 1);
                if (row == null) {
                    continue;
                }

                Cell firstNameCell = row.getCell(1);
                Cell secondNameCell = row.getCell(2);
                Cell vendorCell = row.getCell(4);
                Cell countCell = row.getCell(6);

                if (firstNameCell == null || secondNameCell == null || vendorCell == null || countCell == null) {
                    continue;
                }

                String firstName = cellToString(firstNameCell);
                String secondName = cellToString(secondNameCell);
                String vendor = cellToString(vendorCell);
                int count = (int) countCell.getNumericCellValue();

                line.add(new Fitting(firstName, secondName, vendor, count));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String cellToString(Cell cell) {
        if (cell == null) {
            return null;
        }
        String cellValue = null;

        switch (cell.getCellType()) {
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case NUMERIC:
                cellValue = Double.toString(cell.getNumericCellValue());
                break;
            default:
        }
        return cellValue;
    }

}