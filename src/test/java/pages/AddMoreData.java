package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddMoreData {
	private WebDriver driver;
	public AddMoreData(WebDriver driver) {
		this.driver = driver;
	}
	public AddMoreData typeContactEmail(String type) {
		WebElement campoType = driver.findElement(By.name("type"));
		new Select(campoType).selectByVisibleText(type);
		return this;
	}
	public AddMoreData typeContactNum(String numero) {
		driver.findElement(By.name("contact")).sendKeys(numero);
		return this;
	}
	public AddMoreData clickSave() {
		driver.findElement(By.xpath("//a[@class='modal-action waves-effect waves-green btn-flat']")).click();
		return this;
	}
	
}
