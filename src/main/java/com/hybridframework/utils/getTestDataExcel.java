package com.hybridframework.utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getTestDataExcel {

    public static Object[][] getTestData(String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet " + sheetName + " not found in " + filePath);
            }

            int rows = sheet.getPhysicalNumberOfRows();
            if (rows <= 1) {
                return new Object[0][0]; // no data
            }

            int cols = sheet.getRow(0).getLastCellNum();
            Object[][] data = new Object[rows - 1][cols];
            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i < rows; i++) {
                Row row = sheet.getRow(i);
                if (row == null) {  // skip empty rows
                    continue;
                }
                for (int j = 0; j < cols; j++) {
                    Cell cell = row.getCell(j);
                    data[i - 1][j] = formatter.formatCellValue(cell); // empty string if null
                }
            }
            return data;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to read test data from Excel", e);
        }
    }
}
