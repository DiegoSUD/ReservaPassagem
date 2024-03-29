package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import service.DriverFactory;

public class Utils{
	
	private static int contador = 1;

	/**
	 * @param tempo Metodo de sleep passano um par�metro do tipo long
	 */
	public static void sleep(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (Exception e) {
			Thread.currentThread();
		}
	}

	/**
	 * @param elemento Metodo quer retorna um elemento de uma pagina
	 * @return um WebElement
	 */
	public static WebElement retornarElemento(By elemento) {
		return DriverFactory.getDriver().findElement(elemento);
	}

	/**
	 * @param elemento Metodo que clica em um elemento da pagina
	 */
	public static void clicar(By elemento) {
		retornarElemento(elemento).click();
	}
	
	/**
	 * @param elemento Metodo que verifica se o elemento está visivel na pagina
	 * @return 
	 */
	public static boolean estaVisivel(By elemento) {
		return retornarElemento(elemento).isDisplayed();
	}

	/**
	 * @param elemento Metodo que encontra o elemento
	 * @param texto    escreve um texto
	 */
	public static void escrever(By elemento, String texto) {
		retornarElemento(elemento).sendKeys(texto);
	}

	/**
	 * @param elemento Metodo que passa um elemento By como par�mentro
	 * @param num      para escreve um num
	 */
	public static void escreverNum(By elemento, Integer num) {
		retornarElemento(elemento).sendKeys(num.toString());
	}

	/**
	 * @param elemento Metodo de dar Scroll na pagina passando um par�mentro By
	 */
	public static void scroll(By elemento) {
		JavascriptExecutor jse = (JavascriptExecutor) DriverFactory.getDriver();
		jse.executeScript("arguments[0].scrollIntoView();", DriverFactory.getDriver().findElement(elemento));
	}

	/**
	 * @param elemento Metodo de selecionar um combobox passando como par�metro um
	 *                 By e um valor
	 * @param texto
	 */
	public static void selecionarComboBoxByValue(By elemento, String texto) {
		WebElement nome = retornarElemento(elemento);
		Select combo = new Select(nome);
		combo.selectByValue(texto);

	}
	
	/**
	 * @param elemento Metodo de selecionar um combobox passando como par�metro um
	 *                 By e um texto
	 * @param texto
	 */
	public static void selecionarComboBoxByVisibleText(By elemento, String texto) {
		WebElement nome = retornarElemento(elemento);
		Select combo = new Select(nome);
		combo.selectByVisibleText(texto);

	}

	/**
	 * @param elemento Metodo de selecionar um combobox passando como par�metro um
	 *                 By e um index
	 * @param texto
	 */
	public static void selecionarComboBoxIndex(By elemento, int index) {
		WebElement nome = retornarElemento(elemento);
		Select combo = new Select(nome);
		combo.selectByIndex(index);

	}

	/**
	 * @param status Metrodo de tirar screenshots e salvar na devida basta, passando
	 *               dois parametros String
	 * @param nome
	 */
	
	
	private static String caminhoArq;
	
	public static void setCaminhoArq(String nome) {
		caminhoArq = nome;
		contador = 0;
	}
	
	public static void screenshots() {
		TakesScreenshot screen = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = screen.getScreenshotAs(OutputType.FILE);
		
		try {
			
			FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshots" + File.separator + caminhoArq + contador++ +".png"));

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public static void diaEmbarque(By elementoDia, By elementoMes) {

		LocalDate dia = LocalDate.now();
		LocalDate diaMaior = LocalDate.now().plusDays(1);

		if (dia.getDayOfMonth() < diaMaior.getDayOfMonth()) {
			dia = diaMaior;

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
			String formattedStringDia = dia.format(formatter);

			WebElement nome = retornarElemento(elementoDia);
			Select combo = new Select(nome);
			combo.selectByValue(formattedStringDia);
			

		} else if (dia.getDayOfMonth() > diaMaior.getDayOfMonth()) {
			dia = diaMaior;

			int dias = dia.getDayOfMonth();

			DateTimeFormatter formatteMes = DateTimeFormatter.ofPattern("MM");
			String formattedStringMes = dia.format(formatteMes);

			WebElement nomeDia = retornarElemento(elementoDia);
			Select comboDia = new Select(nomeDia);
			comboDia.selectByIndex(dias - 1);

			sleep(400);

			WebElement nomeMes = retornarElemento(elementoMes);
			Select comboMes = new Select(nomeMes);
			comboMes.selectByValue(formattedStringMes);

			
		}
	}
	
	public static void diaRetorno(By elementoDia, By elementoMes) {

		LocalDate dia = LocalDate.now();
		LocalDate diaMaior = LocalDate.now().plusDays(1);

		if (dia.getDayOfMonth() < diaMaior.getDayOfMonth()) {
			dia =diaMaior;
			
			int dias = dia.getDayOfMonth() + 1;
			WebElement nome = retornarElemento(elementoDia);
			Select combo = new Select(nome);
			combo.selectByIndex(dias -1);
			

		} else if (dia.getDayOfMonth() > diaMaior.getDayOfMonth()) {
			dia = diaMaior;

			int dias = dia.getDayOfMonth();

			DateTimeFormatter formatteMes = DateTimeFormatter.ofPattern("MM");
			String formattedStringMes = dia.format(formatteMes);

			WebElement nomeDia = retornarElemento(elementoDia);
			Select comboDia = new Select(nomeDia);
			comboDia.selectByIndex(dias - 1);

			sleep(400);

			WebElement nomeMes = retornarElemento(elementoMes);
			Select comboMes = new Select(nomeMes);
			comboMes.selectByValue(formattedStringMes);
		}
	}

	public static void diaRetornoComMassa(By comboBoxReturningToDia, By comboBoxRuturningToMonth) {
		
		
	}	
}
