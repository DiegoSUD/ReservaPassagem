package service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	public DriverFactory() {

	}

	public static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Automa-oCompra\\INMETRICS\\Desafios_Inmetrics\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		return driver;
	}

	public static void encerraDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	public void setUrl(String url) {
		getDriver().get(url);
	}

}
