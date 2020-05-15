package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage {
	private WebDriver driver;
	
	public LoginFormPage(WebDriver driver) {
		this.driver = driver;
	}
	public LoginFormPage typeLogin(String login) {
		driver.findElement(By.xpath("//h4[contains(text(),'Sign in')]")).findElement
		(By.xpath("//input[@placeholder='Please, tell us your login']")).sendKeys(login);
		return this;
	}
	public LoginFormPage typeSenha(String senha) {
		driver.findElement(By.xpath("//input[@placeholder='Excuse me, can you tell us a secret?']")).sendKeys(senha);
		return this;
	}
	public LoginFormPage clickSignIn(WebDriver driver) {
		driver.findElement(By.xpath("//a[@class='modal-action waves-effect waves-green btn-flat'][contains(text(),'Sign in')]")).click();
		return this;
	}
	public InicialPage clickHiJulio() {
		driver.findElement(By.xpath("//ul[@class='right hide-on-med-and-down']//a[@class='me'][contains(text(),'Hi, Julio')]")).click();
		return new InicialPage(driver);
	}
	
}
