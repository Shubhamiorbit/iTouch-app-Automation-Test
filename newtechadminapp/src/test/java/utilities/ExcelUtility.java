package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    static String filePath = System.getProperty("user.dir")
            + "/TestData/TestData.xlsx";

    static String sheetName = "Data";

    // Fixed column mapping
    static HashMap<String, Integer> columnMap = new HashMap<>();

    static {

        columnMap.put("Doctor Code", 0);
        columnMap.put("Patient Code", 1);
        columnMap.put("Nurse Code", 2);
        columnMap.put("Device Code", 3);
        columnMap.put("Ward Code", 4);
        columnMap.put("Gateway Code", 5);
        columnMap.put("Shift Code", 6);
        columnMap.put("Bed Code", 7);
        
        
    }

    public static void writeData(String columnName, String value) {

        try {

            File folder = new File(System.getProperty("user.dir") + "/TestData");

            if (!folder.exists()) {

                folder.mkdirs();
            }

            File file = new File(filePath);

            XSSFWorkbook workbook;
            XSSFSheet sheet;

            if (file.exists()) {

                FileInputStream fis = new FileInputStream(file);

                workbook = new XSSFWorkbook(fis);

                fis.close();

            } else {

                workbook = new XSSFWorkbook();
            }

            sheet = workbook.getSheet(sheetName);

            if (sheet == null) {

                sheet = workbook.createSheet(sheetName);
            }

            // Header Row
            Row headerRow = sheet.getRow(0);

            if (headerRow == null) {

                headerRow = sheet.createRow(0);
            }

            // Data Row
            Row dataRow = sheet.getRow(1);

            if (dataRow == null) {

                dataRow = sheet.createRow(1);
            }

            // Get fixed column index
            int columnIndex = columnMap.get(columnName);

            // Write header
            headerRow.createCell(columnIndex)
                    .setCellValue(columnName);

            // Write value
            dataRow.createCell(columnIndex)
                    .setCellValue(value);

            // Save
            FileOutputStream fos = new FileOutputStream(file);

            workbook.write(fos);

            fos.close();
            workbook.close();

            System.out.println("Data written successfully");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}