package week5.homeassignement;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToData 
{
	public static String[][] excelSheet() throws IOException 
	{

		XSSFWorkbook wb=new XSSFWorkbook("./Excel Folder/W3_TestNG_week5.xlsx");
		XSSFSheet sheet=wb.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();		
		int cellcount = sheet.getRow(1).getLastCellNum();

       String[][] data=new String[rowcount][cellcount];

       for (int i = 1; i <=rowcount; i++) 
       {	   
    	   for (int j = 0; j < cellcount; j++) 
    	   {			
    		   String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
    		   data[i-1][j]=stringCellValue;
			}
		}
		
  wb.close();
		return data;
	}

}
