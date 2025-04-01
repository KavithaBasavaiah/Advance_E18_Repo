package DDT_Practice_AS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingDataToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("");
		Workbook wb = WorkbookFactory.create(fis);
		wb.createSheet("DDT2").createRow(1).createCell(2).setCellValue("Selenium");
		wb.getSheet("DDT1").createRow(2).createCell(0).setCellValue(2000);
		FileOutputStream fos = new FileOutputStream("");
		wb.write(fos);
		wb.close();
		System.out.println("Data written successfully");

	}

}
