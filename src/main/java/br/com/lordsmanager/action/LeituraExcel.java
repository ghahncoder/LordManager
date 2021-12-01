package br.com.lordsmanager.action;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class LeituraExcel {

    public static void main(String[] args) throws IOException
    {
        String filePath = "C:\\git\\Projetos\\LordsManager\\resources\\gbw.xlsx";
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        System.out.println("DataSheet.xlsx file opened successfully");

        // Call getSheet() method to read the sheet name inside the workbook. The getSheet() method will return the sheet name.
        // Since the return type of getSheet method is an XSSFSheet. Therefore, we will store the returning value by using variable 'sheet' with type XSSFSheet.
        XSSFSheet sheet = wb.getSheet("Sheet");

        // Call iterator method to iterate row of the sheet.
        Iterator<Row> rows = sheet.rowIterator();
        rows.next(); // It will start to iterate from the second row.
        while (rows.hasNext())
        {
            Row r = rows.next();
            XSSFRow row = (XSSFRow)r; // Typecasting.

            // OR In one line:
            //XSSFRow row = (XSSFRow)rows.next();

// Iterating all cells of the current row.
            Iterator<Cell> cells = row.cellIterator();
            while (cells.hasNext())
            {
                Cell c = cells.next();
                XSSFCell cell = (XSSFCell)c;

                // OR In one line of code:
                //XSSFCell cell = (XSSFCell)cells.next();

                // Call getCellType() method to compare value of cell type using if-else statement.
                if (cell.getCellType() == CellType.STRING)
                {
                    String stringData = cell.getStringCellValue();
                    System.out.println("Celula " + c.getAddress().toString() + " " + stringData + " ");
                }
                else if (cell.getCellType() == CellType.NUMERIC) {
                    double numericData = cell.getNumericCellValue(); // Returns numeric value.
                    System.out.println("Celula " + c.getAddress().toString() + " " + numericData + " ");
                }
                else if (cell.getCellType() == CellType.BOOLEAN) {
                    System.out.println("Celula " + c.getAddress().toString() + " " + cell.getBooleanCellValue() + " ");
                } else {
                    // Here if require, we can also add below methods to
                    System.out.print("outro tipo");
                    // Read the cell content
                    // XSSFCell.CELL_TYPE_BLANK
                    // XSSFCell.CELL_TYPE_FORMULA
                    // XSSFCell.CELL_TYPE_ERROR
                }
            }
            System.out.println();
            try {
                // Close the fileinputstream.
                fis.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}