package fazerUmaReservaAerea;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import model.ReservaPassagem;
import service.DriverFactory;
import utils.ExcelUtils;
import utils.Utils;

public class ReservarUmTicketPageObject extends DriverFactory {

	ExcelUtils excelUtils;
	WebDriverWait wait;
	ReservaPassagem rp;

	public static int j = 1;

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
	private By radioOneWay = By.xpath("//*[@name = 'tripType'][2]");
	private By RadioButtonBusiness = By.xpath("(//input[@name = 'servClass'])[2]");
	private By RadioButtonFirst = By.xpath("(//input[@name = 'servClass'])[3]");
	private By selecionarVoo360 = By.xpath("(//input[@name = 'outFlight'])[1]");
	private By selecionarVoo361 = By.xpath("(//input[@name = 'outFlight'])[2]");
	private By selecionarVoo363 = By.xpath("(//input[@name = 'outFlight'])[4]");

	private static String nome;

	@Before
	public void antes(Scenario c) {
		nome = c.getName() + File.separator + "reservarVoo";
	}

	public ReservarUmTicketPageObject() {
		this.wait = new WebDriverWait(DriverFactory.getDriver(), 30);
		excelUtils = new ExcelUtils(1);
		rp = excelUtils.entrarExcel();

	}

	public void userNameLogin(String username) {
		Utils.setCaminhoArq(nome);
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

		} catch (Exception e) {
			Utils.scroll(botaoContinuarTelaSelecionarVoo);
			Utils.clicar(this.botaoContinuarTelaSelecionarVoo);
			Utils.sleep(300);

		}
		Utils.sleep(300);
	}

	public void selecionarVoo() {
		Utils.screenshots();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(this.subTituloDepart));
		Utils.clicar(this.selecionarVooIda);
		Utils.sleep(300);
		Utils.clicar(this.selecionarVooRetorno);
		Utils.sleep(300);
		Utils.screenshots();
	}

	public void preencherSumario(String nome, String sobrenome) {
		Utils.screenshots();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(this.apareceuTextFirstName));
		Utils.escrever(this.firstName, nome);
		Utils.sleep(300);
		Utils.escrever(this.lastName, sobrenome);
	}

	public void preencherCartaoCredito() {

		Utils.selecionarComboBoxByValue(this.tipoCartao, "IK");
		Utils.sleep(300);
		Utils.escrever(this.numCartaoCredito, "123456789123456");
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
		Utils.screenshots();
	
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

	public void selecionarOneWay() {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(this.radioOneWay));
		Utils.clicar(this.radioOneWay);

	}

	public void selecionarDepartingFrom() {

		Utils.selecionarComboBoxByVisibleText(this.ComboBoxCidadeOrigem, rp.getDepartingFrom());
		Utils.sleep(300);
	}

	public void selecionarArrivingIn() {
		Utils.selecionarComboBoxByVisibleText(this.ComboBoxCidadeDestino, rp.getArrivingIn());
		Utils.sleep(300);
	}

	public void selecionarDataPartidaERetorno() {
		String[] dataPartida = rp.getOn().split("/");
		String dia = dataPartida[0];
		String mes = dataPartida[1];

		int diaRetorno = Integer.parseInt(dia) + 1;
		String diaRet = Integer.toString(diaRetorno);

		Utils.selecionarComboBoxByVisibleText(this.comboBoxOnDia, dia);
		Utils.sleep(300);
		Utils.selecionarComboBoxByValue(this.comboBoxOnMes, mes);
		Utils.sleep(300);
		Utils.selecionarComboBoxByVisibleText(this.comboBoxReturningToDia, diaRet);
		Utils.sleep(300);
		Utils.selecionarComboBoxByValue(this.comboBoxRuturningToMonth, mes);
	}

	public void selecionarFligthClass() {

		switch (rp.getFligthclass()) {
		case "Economy class":
			Utils.clicar(this.RadioButton);
			break;
		case "Business class":
			Utils.clicar(this.RadioButtonBusiness);
			break;
		case "First class":
			Utils.clicar(this.RadioButtonFirst);
			break;
		default:
			System.out.println("n�o encontrou a classe");
			break;
		}
		Utils.sleep(300);

	}

	public void quantidadePassagem() {
		Utils.selecionarComboBoxByVisibleText(this.passengers, rp.getPassengers());
		Utils.sleep(300);
		Utils.screenshots();
	}

	public void selecionarVooIdaVolta() {
		String vooIda = rp.getFlightNumber();
		switch (vooIda) {
		case "Pangaea Airlines 362":
			Utils.clicar(this.selecionarVooIda);
			break;
		case "Blue Skies Airlines 361":
			Utils.clicar(this.selecionarVoo361);
			break;
		case "First class":
			Utils.clicar(this.RadioButtonFirst);
			break;
		case "Blue Skies Airlines 360":
			Utils.clicar(this.selecionarVoo360);
			break;
		case "Unified Airlines 363":
			Utils.clicar(this.selecionarVoo363);
			break;
		default:
			System.out.println("n�o encontrou a classe");
			break;
		}
		Utils.sleep(300);
		Utils.clicar(this.selecionarVooRetorno);

	}

	public void preencheOrderNumber() throws IOException {

		excelUtils.writeExcel();

	}
}
