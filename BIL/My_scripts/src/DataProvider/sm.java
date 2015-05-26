package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class sm {

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		String Path = "F://Read.xls";
		String s ="Read";


		FileInputStream fs = new FileInputStream(Path);
		 Workbook workbook = Workbook.getWorkbook(fs); 
		 Sheet sheet = workbook.getSheet(s); 
	
		 String c = sheet.getCell(4,3).getContents();
		 System.out.println(c);
		
	}

}
