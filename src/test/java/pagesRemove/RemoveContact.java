package pagesRemove;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RemoveContact {
	private WebDriver driver;
	public RemoveContact(WebDriver driver) {
		this.driver = driver;
	}
	
	public RemoveContact remove() {
		driver.findElement(By.xpath("//li[500]//a[1]//i[1]")).click();
		return this;
	}
	public RemoveContact msgremove() {
		driver.switchTo().alert().accept();
		return this;
	}
	public RemoveContact logOut() {
		driver.findElement(By.xpath("//ul[@class='right hide-on-med-and-down']//a[contains(text(),'Logout')]")).click();
		return this;
	}

}
