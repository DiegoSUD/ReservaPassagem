package br.com.diego.CompraPassagens;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.ReservaPassagem;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) throws IOException {
		
		
		
		
		
		
		
		
		
		
		
		
	}	
}
		
		
//		try {
//			File file = new File(".\\data\\SampleAppDataMassa.xlsx");
//			FileInputStream filePlanilha = new FileInputStream(file);
//			
//			XSSFWorkbook workbook = new XSSFWorkbook(filePlanilha);
//			XSSFSheet planilha = workbook.getSheetAt(0);
//
//			Iterator<Row> rowIterator = planilha.iterator();
//			
//			while(rowIterator.hasNext()) {
//				Row row = rowIterator.next();
//				
//				Iterator<Cell> cellIterator = row.iterator();
//				while(cellIterator.hasNext()) {
//					Cell cell = cellIterator.next();
//					
//					System.out.println(cell.getStringCellValue());
//				}
//			}
//			
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//		
//	

//}
