package fazerUmaReservaAerea;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import service.DriverFactory;
import utils.Utils;

public class ReservarUmTicketPageObject extends DriverFactory {

	WebDriverWait wait;
	private By inputUserName = By.name("userName");
	private By inputPassaword = By.name("password");
	private By botaoSingIN = By.xpath("//*[@name= 'login']");
	private By ComboBoxCidadeOrigem = By.name("fromPort");
	private By botaoContinue = By.name("findFlights");
	private By ComboBoxCidadeDestino = By.name("toPort");
	private By comboBoxOnMes = By.name("fromMonth");
	private By comboBoxOnDia = By.name("fromDay");
	private By comboBoxReturningToDia = By.name("toDay");
	private By comboBoxRuturningToMonth = By.name("toMonth");
	private By RadioButton = By.name("servClass");
	private By passengers = By.name("passCount");
	private By botaoContinuar = By.name("findFlights");
	private By subTituloDepart = By.xpath("(//*[contains(text(), 'DEPART')])[1]");
	private By selecionarVooIda = By.xpath("(//input[@name = 'outFlight'])[3]");
	private By selecionarVooRetorno = By.xpath("(//input[@name = 'inFlight'])[2]");
	private By apareceuTextFirstName = By.xpath("//*[contains(text(), 'First Name:')]");
	private By firstName = By.name("passFirst0");
	private By lastName = By.name("passLast0");
	private By botaoContinuarTelaSelecionarVoo = By.name("reserveFlights");
	private By tipoCartao = By.name("creditCard");
	private By numCartaoCredito = By.name("creditnumber");
	private By diaExpiraCartao = By.name("cc_exp_dt_mn");
	private By anoExpiraCartao = By.name("cc_exp_dt_yr");
	private By name = By.name("cc_frst_name");
	private By middleName = By.name("cc_mid_name");
	private By lastNome = By.name("cc_last_name");
	private By botaoSecurePurcharse = By.name("buyFlights");
	private By mensagem = By.xpath("((//tr[@valign ='top' ])[2]//..//img)[1]");
	

	public ReservarUmTicketPageObject() {
		this.wait = new WebDriverWait(DriverFactory.getDriver(), 30);
	}

	public void userNameLogin(String username) {
		Utils.escrever(this.inputUserName, username);

	}

	public void passwordLogin(String password) {
		Utils.escrever(this.inputPassaword, password);
		Utils.screenshots();
		
	}

	public void clicarBotaoSingIn() {
		Utils.clicar(this.botaoSingIN);

	}

	public void selecionarCidadeDeOrigem() {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(this.botaoContinue));
		Utils.selecionarComboBoxIndex(this.ComboBoxCidadeOrigem, 2);
		Utils.sleep(300);
	}

	public void selecionarCidadeDeDestino() {
		Utils.selecionarComboBoxIndex(this.ComboBoxCidadeDestino, 4);
		Utils.sleep(300);

	}

	public void selecioneData() {

		Utils.diaEmbarque(this.comboBoxOnDia, this.comboBoxOnMes);
		Utils.diaRetorno(this.comboBoxReturningToDia, this.comboBoxRuturningToMonth);
		Utils.sleep(300);
	}

	public void escolherClasse() {
		Utils.clicar(this.RadioButton);
		Utils.sleep(300);

	}

	public void escolherQuantidadePassageiros(String quantidade) {
		Utils.selecionarComboBoxByValue(this.passengers, quantidade);
		Utils.sleep(300);
		Utils.screenshots();
	}

	public void clicarBotaoContinuar() {
		try {
			Utils.scroll(botaoContinuar);
			Utils.clicar(this.botaoContinuar);
			Utils.sleep(300);
			Utils.screenshots();
		} catch (Exception e) {
			Utils.scroll(botaoContinuarTelaSelecionarVoo);
			Utils.clicar(this.botaoContinuarTelaSelecionarVoo);
			Utils.sleep(300);
			Utils.screenshots();
		}
		Utils.sleep(300);
	}

	public void selecionarVoo() {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(this.subTituloDepart));
		Utils.clicar(this.selecionarVooIda);
		Utils.sleep(300);
		Utils.clicar(this.selecionarVooRetorno);
		Utils.sleep(300);
		Utils.screenshots();
		Utils.sleep(300);
	}

	public void preencherSumario(String nome, String sobrenome) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(this.apareceuTextFirstName));
		Utils.escrever(this.firstName, nome);
		Utils.sleep(300);
		Utils.escrever(this.lastName, sobrenome);
	}

	public void preencherCartaoCredito() {
		
		Utils.selecionarComboBoxByValue(this.tipoCartao, "IK");
		Utils.sleep(300);
		Utils.escrever(this.numCartaoCredito, "123456789123456" );
		Utils.sleep(300);
		Utils.selecionarComboBoxIndex(this.diaExpiraCartao, 5);
		Utils.sleep(300);
		Utils.selecionarComboBoxIndex(this.anoExpiraCartao, 7);
		Utils.sleep(300);
	}

	public void preencherDados(String nome, String nomeMeio, String ultimoNome) {
		Utils.escrever(this.name, nome);
		Utils.sleep(300);
		Utils.escrever(this.middleName, nomeMeio);
		Utils.sleep(300);
		Utils.escrever(this.lastNome, ultimoNome);
		Utils.sleep(300);
		Utils.screenshots();
		Utils.sleep(300);
		
	}

	public void clicarBotaoSecure() {
		Utils.scroll(this.botaoSecurePurcharse);
		Utils.clicar(this.botaoSecurePurcharse);
		
	}

	public void validarReserva() {
		Utils.estaVisivel(this.mensagem);
		System.out.println("Reserva feita com sucesso!!!!");
		Utils.screenshots();
		Utils.sleep(300);
		
	}

}
