package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	public LoginFormPage clickSignIn() {
		driver.findElement(By.xpath("//ul[@class='right hide-on-med-and-down']//a[@class='modal-trigger'][contains(text(),'Sign in')]")).click();
		return new LoginFormPage(driver);
	}
}
