package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import model.ReservaPassagem;



public class ExcelUtils {
	
	
	String caminho = ".\\data\\SampleAppDataMassa.xlsx";
	public static int j = 1;
	

	private int linhaProcura;
	
	
	
	public ExcelUtils(int linha) {		
		this.linhaProcura = linha;
	}
		
	public ReservaPassagem entrarExcel() {
		
		try {
			System.out.println("Linha procura: " + linhaProcura);
		
			FileInputStream file = new FileInputStream(new File(caminho));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet abaPlanilha = workbook.getSheetAt(0);
			
			

			for(Row linha: abaPlanilha) {
				
				if(linha.getRowNum() == linhaProcura) {
					Cell cellFlightNumber = linha.getCell(0);
					Cell cellPassengers = linha.getCell(1);
					Cell cellClass = linha.getCell(2);
					Cell cellOn = linha.getCell(3);
					Cell cellDepartingFrom = linha.getCell(4);
					Cell cellArrivingIn = linha.getCell(5);
					Cell cellOrderNumber = linha.getCell(6);
					
					
					ReservaPassagem rp = new ReservaPassagem();
					rp.setFlightNumber(cellFlightNumber.getStringCellValue());
					rp.setPassengers(cellPassengers.getStringCellValue());
					rp.setFligthclass(cellClass.getStringCellValue());
					rp.setOn(cellOn.getStringCellValue());
					rp.setDepartingFrom(cellDepartingFrom.getStringCellValue());
					rp.setArrivingIn(cellArrivingIn.getStringCellValue());
					rp.setOrderNumber(cellOrderNumber.getStringCellValue());	
					return rp;
				}	
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	
		
	}

	public void writeExcel() throws IOException {
		
		FileInputStream file = new FileInputStream(new File(caminho));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet abaPlanilha = workbook.getSheetAt(0);
		FileOutputStream fos = null;
		ReservaPassagem rp = new ReservaPassagem();
		
		try {
			
			if(rp.getOrderNumber() == null) {
				
				String i = Integer.toString(j++);
				rp.setOrderNumber(i);
				
				Row linha = abaPlanilha.getRow(linhaProcura);
				Cell celula = linha.getCell(6);
				
				celula.setCellValue(rp.getOrderNumber());
				
				fos = new FileOutputStream(caminho);
				workbook.write(fos);
				fos.close();
				System.out.println("PASSOU POR AQUI");
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
