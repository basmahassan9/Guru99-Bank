package utils;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

public class readXLFiles {

    @DataProvider(name ="loginData")
    public Object[][] getData(Method m) throws IOException {
        String sheetName = m.getName();
        File f = new File(System.getProperty("user.dir")+"/resources/testData/loginData.xlsx");
        FileInputStream fis = new FileInputStream(f);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet(sheetName);

        int totalR = sheet.getLastRowNum();
        System.out.println(totalR);
        Row rowCells = sheet.getRow(0);
        int totalC = rowCells.getLastCellNum();
        System.out.println(totalC);
        String testData[][] = new String[totalR][totalC];
        DataFormatter format = new DataFormatter();
        for(int i=1 ; i<=totalR ; i++){
            for(int j=0; j<totalC; j++){
                testData[i-1][j] = format.formatCellValue(sheet.getRow(i).getCell(j));
                System.out.println(testData[i-1][j]);
            }
        }
        return testData;

    }
}
