package br.com.diego.CompraPassagens;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static int[] aleatorio(int tam) {
		int[] array = new int[tam];
		Random gerador = new Random(tam);
		int num;
		for (num = 0; num < tam; num++) {
			/* Popular o array */
			array[num] = gerador.nextInt(100) + 1;
		}

		/*Retornar a Variável*/
		return array;
		
	}
	
    public static void main( String[] args )
    {
    	
    	System.out.println(aleatorio(16));
    	
    	
    	
    	
    	
    	
    	

//    	LocalDate localDate = LocalDate.now();
//    	LocalDate localDateMaior = LocalDate.now().plusDays(1);
//    	
//    	if(localDate.getDayOfMonth() < localDateMaior.getDayOfMonth()) {
//    		localDate = localDateMaior;
//    		System.out.println("Dia dMaa semana: " + localDate.getDayOfMonth());
//    		
//    	} else if(localDate.getDayOfMonth() > localDateMaior.getDayOfMonth()) {
//    		localDate = localDateMaior;
//    		System.out.println("Dia dMaa semana: " + localDate.getDayOfMonth());
//    		System.out.println("Dia dMaa semana: " + localDate.getMonth().name());
    	
//    	LocalDate dia = LocalDate.now();
//		LocalDate diaMaior = LocalDate.now().plusDays(19);
//
//		if (dia.getDayOfMonth() < diaMaior.getDayOfMonth()) {
//			dia = diaMaior;
//			
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
//			String formattedString = dia.format(formatter);
//
//			System.out.println("Dia dMaa semana: " + formattedString);
//
//    		
//    	}else if (dia.getDayOfMonth() > diaMaior.getDayOfMonth()) {
//			dia = diaMaior;
//		
//			int dias = dia.getDayOfMonth();
//			
//			System.out.println(dias);
//			
//			
//		DateTimeFormatter formatterDia = DateTimeFormatter.ofPattern("dd");
//		String formattedStringDia = dia.format(formatterDia);
//		
//		DateTimeFormatter formatteMes = DateTimeFormatter.ofPattern("MM");
//		String formattedStringMes = dia.format(formatteMes);
//		
//		System.out.println("Dia dMaa semana: " + formattedStringDia);
//		System.out.println("Dia dMaa semana: " + formattedStringMes);
//		
		
//    	}
		
		
		
		
//		else if(dia.getDayOfMonth() > diaMaior.getDayOfMonth()) {
//    		dia = diaMaior;
//    		
//    		
//    		System.out.println("Dia dMaa semana: " + localDate.getDayOfMonth());
//    		System.out.println("Dia dMaa semana: " + localDate.getMonth().name());
//    	}
    	
//    	System.out.println("Dia dMaa semana: " + localDate.getDayOfMonth());
//    	
//    	System.out.println("Dia da semana: " + localDate.plusDays(5));
//    	
//    	System.out.println("Dia da semana: " + localDate.getMonthValue());
//    	
//    	
//    	
//    	System.out.println("Dia da semana: " + localDate.getDayOfWeek().name());
//    	System.out.println("Dia da semana: " + localDate.getDayOfWeek().ordinal());
    	
    	
    	
    	
    }
    
}
