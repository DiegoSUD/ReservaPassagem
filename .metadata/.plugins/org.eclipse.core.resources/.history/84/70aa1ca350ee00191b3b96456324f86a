package comprarProdutoComApenasUmClick;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import service.InicializarDriver;

public class Steps {
	
	private ComprarProdutoPageObject pageObject;
	
	public Steps() {
		pageObject = new ComprarProdutoPageObject();
	}
	
	@Given("^que logo no site$")
	public void que_logo_no_site() throws Throwable {
		InicializarDriver.inicializaBrowser();
	}

	@When("^que eu seleciono um produto$")
	public void que_eu_seleciono_um_produto() throws Throwable {
		pageObject.fecharRodape();
		pageObject.clicarNoProdutoCamisetaBranca();
	   
	}

	@When("^escolho as opcoes de cor \"([^\"]*)\" e tamanho \"([^\"]*)\"$")
	public void escolho_as_opcoes_de_cor_e_tamanho(String cor, String tamanho) throws Throwable {
		pageObject.escolherCorETamanho(cor, tamanho);
	}

	@When("^clico no botao Comprar$")
	public void clico_no_botao_Comprar() throws Throwable {
	    pageObject.clicarNoBotaoComprarComUmClick();
	}

	@When("^informo meu nome \"([^\"]*)\" e telefone \"([^\"]*)\" ou e-mail \"([^\"]*)\"$")
	public void informo_meu_nome_e_telefone_ou_e_mail(String nome, String tel, String email) throws Throwable {
	    pageObject.preencherCamposPessoais(nome, tel, email);
	}

	@When("^clico em submit para enviar as informacoes minhas$")
	public void clico_em_submit_para_enviar_as_informacoes_minhas() throws Throwable {
	  pageObject.clicarBotaoSubmit();
	}

	@Then("^valido a compra do produto$")
	public void valido_a_compra_do_produto() throws Throwable {
	    pageObject.validarMensagem();
	}

}
