package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InicialPage {
	private WebDriver driver;
	public InicialPage(WebDriver driver) {
		this.driver = driver;
	}
	public InicialPage clickMoreData() {
		driver.findElement(By.xpath("//a[contains(text(),'More data about you')]")).click();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("window.scrollBy(0, 350)", "");
	return this;
	}
	public AddMoreData addNewContact() {
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[2]/button[1]")).click();
		return new AddMoreData(driver);
	}

}
