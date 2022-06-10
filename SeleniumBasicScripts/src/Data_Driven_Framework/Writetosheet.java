package Data_Driven_Framework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Writetosheet {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file=new FileOutputStream("C:\\Users\\admin\\Desktop\\Book1.xlsx");

		XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet("data");
		
		for(int i=0;i<=5;i++)
		{
			XSSFRow row=sheet.createRow(i);
			
			for(int j=0;j<3;j++)
			{
				row.createCell(j).setCellValue("welcome");
			}
		}
		
		workbook.write(file);
		
		System.out.println("Writing excel is completed");
		
	}

}
