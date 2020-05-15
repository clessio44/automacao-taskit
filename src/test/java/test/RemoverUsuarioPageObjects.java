package test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automationDetails.Driver;
import pages.InicialPage;
import pages.LoginPage;
import pagesRemove.RemoveContact;

public class RemoverUsuarioPageObjects {
	private WebDriver driver;
	
	@BeforeEach
	public void setUp() {
		driver = Driver.AbrirNavegador();
	}
	@Test
	public void testAdicionarUmaInformacaoDoUsuario() throws Exception {
		new LoginPage(driver)
			.clickSignIn()
			.typeLogin("julio0001")
			.typeSenha("123456")
			.clickSignIn(driver)
			.clickHiJulio();
		
		WebElement about = driver.findElement(By.className("active"));	
		String text = "ABOUT YOU";
		Assert.assertEquals(text, about.getText());
		
		new InicialPage(driver)
		.clickMoreData();
		new RemoveContact(driver)
			.remove()
			.msgremove();
		
		WebElement popup = driver.findElement(By.id("toast-container"));
		String mensagemPop = popup.getText();
		Assert.assertEquals("Rest in peace, dear phone!",mensagemPop);
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/RemoverContato.png"));
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.stalenessOf(popup));
			new RemoveContact(driver)
				.logOut();
		
	}
	@AfterEach
	public void close() {
		driver.quit();
	}
}
