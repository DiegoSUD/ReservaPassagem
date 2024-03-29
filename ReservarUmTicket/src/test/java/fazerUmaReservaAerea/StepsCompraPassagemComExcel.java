package fazerUmaReservaAerea;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import utils.Utils;

public class StepsCompraPassagemComExcel {
	
	private ReservarUmTicketPageObject reserva;
	
	public StepsCompraPassagemComExcel() {
		reserva = new ReservarUmTicketPageObject();
	}
	
	@Given("^seleciono One Way$")
	public void seleciono_One_Way() throws Throwable {
		reserva.selecionarOneWay();
	   
	}

	@And("^seleciono a departing from$")
	public void seleciono_a_departing_from() throws Throwable {
	   reserva.selecionarDepartingFrom();
	}

	@And("^seleciono arriving in$")
	public void seleciono_arriving_in() throws Throwable {
	    reserva.selecionarArrivingIn();
	}

	@And("^seleciono a data on e returning$")
	public void seleciono_a_data_on_e_returning() throws Throwable {
	    reserva.selecionarDataPartidaERetorno();
	}

	@And("^seleciono a class$")
	public void seleciono_a_class() throws Throwable {
		reserva.selecionarFligthClass();
	}

	@And("^seleciono a quantidade de passengers$")
	public void seleciono_a_quantidade_de_passengers() throws Throwable {
	    reserva.quantidadePassagem();
	    
	}

	@And("^seleciono o voos ida e volta$")
	public void seleciono_o_voos_ida_e_volta() throws Throwable {
	    reserva.selecionarVooIdaVolta();
	    
	    
	}
	
	@Then("^realizo a compra segura do tickt de reserva$")
	public void realizo_a_compra_segura_do_tickt_de_reserva() throws Throwable {
		reserva.clicarBotaoSecure();
		reserva.validarReserva();
		reserva.preencheOrderNumber();
		
	}
	
	

}
