package fazerUmaReservaAerea;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import service.InicializarDriver;
import utils.Utils;

public class Steps {

	private ReservarUmTicketPageObject reservaPageObject;

	public Steps() {
		reservaPageObject = new ReservarUmTicketPageObject();
	}

	@Given("^que acesso o site$")
	public void que_acesso_o_site() throws Throwable {
		InicializarDriver.inicializaBrowser();

	}

	@And("^digito o nome de usuario \"([^\"]*)\"$")
	public void digito_o_nome_de_usuario(String username) throws Throwable {
		reservaPageObject.userNameLogin(username);

	}

	@And("^digito o a senha de usuario \"([^\"]*)\"$")
	public void digito_o_a_senha_de_usuario(String password) throws Throwable {
		reservaPageObject.passwordLogin(password);
		
		
	}

	@And("^clico no botao SingIn$")
	public void clico_no_botao_SingIn() throws Throwable {
		reservaPageObject.clicarBotaoSingIn();

	}

	@And("^seleciono a cidade de origem$")
	public void seleciono_a_cidade_de_origem() throws Throwable {
		reservaPageObject.selecionarCidadeDeOrigem();

	}

	@And("^seleciono a cidade de destino$")
	public void seleciono_a_cidade_de_destino() throws Throwable {
		reservaPageObject.selecionarCidadeDeDestino();
	}

	@And("^seleciono a data$")
	public void seleciono_a_data() throws Throwable {
		reservaPageObject.selecioneData();

	}

	@And("^seleciono a classe$")
	public void seleciono_a_classe() throws Throwable {
		reservaPageObject.escolherClasse();

	}

	@And("^seleciono a quantidade de passageiros$")
	public void seleciono_a_quantidade_de_passageiros() throws Throwable {
		reservaPageObject.escolherQuantidadePassageiros("1");
		
		
	}

	@And("^clico no botao continuar$")
	public void clico_no_botao_continuar() throws Throwable {
		reservaPageObject.clicarBotaoContinuar();
	

	}

	@And("^seleciono o voo$")
	public void seleciono_o_voo() throws Throwable {
		reservaPageObject.selecionarVoo();
		
		

	}

	@And("^infomo o nome \"([^\"]*)\" e sobrenome \"([^\"]*)\"$")
	public void infomo_o_nome_e_sobrenome(String nome, String sobrenome) throws Throwable {
		reservaPageObject.preencherSumario(nome, sobrenome);
	}

	@And("^preencho o numero do cartao$")
	public void preencho_o_numero_do_cartao() throws Throwable {
		reservaPageObject.preencherCartaoCredito();
	}

	@And("^preencho o nome do passageiro \"([^\"]*)\" , nome do meio \"([^\"]*)\" e ultimo nome \"([^\"]*)\"$")
	public void preencho_o_nome_do_passageiro_nome_do_meio_e_ultimo_nome(String nome, String nomeMeio, String ultimoNome) throws Throwable {
	    reservaPageObject.preencherDados(nome,nomeMeio,ultimoNome);

	}

	@Then("^realizo a compra segura$")
	public void realizo_a_compra_segura() throws Throwable {
		reservaPageObject.clicarBotaoSecure();
		reservaPageObject.validarReserva();
	
		

	}

}
