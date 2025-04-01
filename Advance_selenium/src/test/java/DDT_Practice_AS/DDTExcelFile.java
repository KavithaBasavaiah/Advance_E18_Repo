package DDT_Practice_AS;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDTExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("C:\\Users\\kavit\\eclipse-workspace\\Advance_selenium\\src\\test\\resources\\ExcelData1.xlsx"); //file location path
		Workbook wb = WorkbookFactory.create(fis);
		
		String Campaign = wb.getSheet("DDT1").getRow(1).getCell(2).getStringCellValue();
		double targetSize = wb.getSheet("ddt1").getRow(1).getCell(3).getNumericCellValue();
		System.out.println(Campaign);
		System.out.println(targetSize);

	}

}
