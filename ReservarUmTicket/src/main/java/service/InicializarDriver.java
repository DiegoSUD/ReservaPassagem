package service;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.Utils;

public class InicializarDriver extends DriverFactory{
	
	
	@Before
	public static void inicializaBrowser() {
		System.out.println("Iniciando o teste!!!!!");
		DriverFactory.getDriver().get("http://www.newtours.demoaut.com");
	}
		
	@After
	public static void finalizarTeste(Scenario t) {
//		new Utils().screenshots(t.getStatus(), t.getName());
		System.out.println("Finalizando o Teste!!!");
		encerraDriver();
	}
	

}
