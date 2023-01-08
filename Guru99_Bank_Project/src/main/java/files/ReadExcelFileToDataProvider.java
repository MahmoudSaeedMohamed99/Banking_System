package files;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class ReadExcelFileToDataProvider {
    private Object[][] excelData = null;
    private String filePath = "C:\\Users\\Mahmoud Abdelhady\\IdeaProjects\\Guru99_Bank_Project\\Guru99 Login Data.xls";
    public Object[][] getExcelData() {

        Workbook workbook = null;
        try { workbook = Workbook.getWorkbook(new File(filePath)); }
        catch (IOException e) { throw new RuntimeException(e); }
        catch (BiffException e) { throw new RuntimeException(e); }

        Sheet sheet = workbook.getSheet("Data");

        Cell tableStart = sheet.findCell("TestData");
        int startRow = tableStart.getRow();
        int startCol = tableStart.getColumn();

        Cell tableEnd = sheet.findCell("TestData" , startCol + 1 , startRow + 1 , 100 , 64000 , false);
        int endRow = tableEnd.getRow();
        int endCol = tableEnd.getColumn();

        excelData = new String[endRow - 1][endCol - 1];

        for (int i = 1; i < endRow; i++) {
            for (int j = 1; j < endCol; j++) {
                excelData[i-1][j-1] = sheet.getCell(j , i).getContents();
            }
        }
        return excelData;
    }
}
