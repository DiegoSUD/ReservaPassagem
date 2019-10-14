package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import service.DriverFactory;

public class Utils {

	
	/**
	 * @param tempo
	 * 		Metodo de sleep passano um parâmetro do tipo long
	 */
	public static void sleep(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (Exception e) {
			Thread.currentThread();
		}
	}
	
	
	/**
	 * @param elemento
	 * 		Metodo quer retorna um elemento de uma pagina 
	 * @return
	 * 		um WebElement
	 */
	public  static WebElement retornarElemento(By elemento) {
		return DriverFactory.getDriver().findElement(elemento);
	}

	
	/**
	 * @param elemento
	 * 		Metodo que clica em um elemento da pagina
	 */
	public static void clicar(By elemento) {
		retornarElemento(elemento).click();
	}

	/**
	 * @param elemento
	 * 		Metodo que encontra o elemento
	 * @param texto
	 * 		escreve um texto 
	 */
	public static void escrever(By elemento, String texto) {
		retornarElemento(elemento).sendKeys(texto);
	}
	
	/**
	 * @param elemento
	 * 		Metodo que passa um elemento By como parâmentro 
	 * @param num
	 * 		 para escreve um num
	 */
	public static void escreverNum(By elemento, Integer num) {
		retornarElemento(elemento).sendKeys(num.toString());
	}

	/**
	 * @param elemento
	 * 		Metodo de dar Scroll na pagina passando um parâmentro By
	 */
	public static void scroll(By elemento) {
		JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getDriver();
		jse.executeScript("arguments[0].scrollIntoView();", DriverFactory.getDriver().findElement(elemento));
	}
	
	/**
	 * @param elemento
	 * 		Metodo de selecionar um combobox passando como parâmetro um By e um texto
	 * @param texto
	 */
	public static void selecionarComboBox(By elemento, String texto) {
		WebElement nome = retornarElemento(elemento);
		Select combo = new Select(nome);
		combo.selectByVisibleText(texto);
		
	}
	

	/**
	 * @param status
	 * 		Metrodo de tirar screenshots e salvar na devida basta, passando dois parametros String
	 * @param nome
	 */
	public void screenshots(String status, String nome) {
		TakesScreenshot screen = (TakesScreenshot)DriverFactory.getDriver();
		File arquivo = screen.getScreenshotAs(OutputType.FILE);
		try {
			
			FileUtils.copyFile(arquivo , new File("target" + File.separator + "screenshots" + File.separator + status + File.separator +
					nome +".jpg"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		

			
	
	
	
}
