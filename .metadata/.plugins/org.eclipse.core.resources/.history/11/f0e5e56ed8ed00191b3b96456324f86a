package comprarProdutoComApenasUmClick;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import service.DriverFactory;

import utils.Utils;

public class ComprarProdutoPageObject extends DriverFactory {

	private WebDriverWait wait;
	private By produtoCamiseta = By.xpath("(//*[@class = 'ty-grid-list__image'])[1]");
	private By fechar = By.id("bp_off_bottom_panel");
	private By color = By.xpath("(//*[@data-ca-target-id='product_detail_page'])[1]");
	private By size = By.xpath("(//*[@data-ca-target-id='product_detail_page'])[2]");
	private By buttonQuantidade = By.xpath("(//*[@class = 'ty-center ty-value-changer cm-value-changer']//a)[1]");
	private By botao = By.xpath("//span[contains(text(),'Buy now with 1-click')]");
	private By availability = By.xpath("(//*[contains(text(),'Availability:')])/../span[text()='Out of stock']");
	private By yourName = By.xpath("//label[contains(text(), 'Your name')]");
	private By userName = By.xpath("(//div[@class = 'ty-control-group'])[2]//input");
	private By phone = By.xpath("(//div[@class = 'ty-control-group'])[3]//input");
	private By submit = By.xpath("//*[contains(text(),'Submit')]");
	private By mail = By.xpath("(//div[@class = 'ty-control-group'])[4]//input");
	private By corProduto = By.xpath("//label[contains(text(), 'Color:')]");
	private By mensagem = By.xpath("//*[@class = 'cm-notification-container notification-container']//strong");

	public ComprarProdutoPageObject() {
		this.wait = new WebDriverWait(DriverFactory.getDriver(), 30);

	}

	public void clicarNoProdutoCamisetaBranca() {
		System.out.println("clicou no produto camiseta");
		Utils.scroll(produtoCamiseta);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(produtoCamiseta));
		Utils.clicar(produtoCamiseta);

	}

	public void fecharRodape() {
		Utils.clicar(fechar);
	}

	public void escolherCorETamanho(String cor, String tamanho) {
		System.out.println("Escolhendo cor e tamanho do produto");
		Utils.scroll(corProduto);
		Utils.selecionarComboBox(color, cor);
		Utils.scroll(corProduto);
		Utils.sleep(3000);
		Utils.selecionarComboBox(size, tamanho);
		Utils.scroll(corProduto);
		Utils.sleep(3000);

		try {
			if (Utils.retornarElemento(availability).isDisplayed()) {
				System.out.println("Não possui item no estoque!!");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			System.out.println("Aumentando a quantidade");
			Utils.clicar(buttonQuantidade);
			Utils.sleep(3000);
		}
	}

	public void clicarNoBotaoComprarComUmClick() {
		System.out.println("Clicando no botão buy");
		Utils.clicar(botao);
	}

	public void preencherCamposPessoais(String nome, String tel, String email) {
		System.out.println("Preencher dados pessoais");
		wait.until(ExpectedConditions.elementToBeClickable(yourName));
		Utils.escrever(userName, nome);
		Utils.escrever(phone, tel);
		Utils.escrever(mail, email);
		Utils.sleep(3000);
	}

	public void clicarBotaoSubmit() {
		System.out.println("Clicando no botão submit");
		Utils.clicar(submit);

	}

	public void validarMensagem() {
		try {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(mensagem));
			System.out.println("validando Tela");

		} catch (Exception e) {
			System.out.println("Erro ao validar tela");
			Assert.assertTrue(false);
		}
	}

}
