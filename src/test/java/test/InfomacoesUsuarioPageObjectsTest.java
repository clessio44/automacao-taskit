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

import automationDetails.Driver;
import pages.AddMoreData;
import pages.InicialPage;
import pages.LoginPage;

public class InfomacoesUsuarioPageObjectsTest {
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
			.clickMoreData()
			.addNewContact();
	
		WebElement moreData = driver.findElement(By.xpath("//h4[contains(text(),'Add more data about me')]"));
		String moreText = "Add more data about me";
		Assert.assertEquals(moreText, moreData.getText());
		
		new AddMoreData(driver)
			.typeContactEmail("Phone")
			.typeContactNum("+551100100010")
			.clickSave();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/AdicionarContato.png"));
		
		WebElement mensagempop = driver.findElement(By.id("toast-container"));
		String msgpop = mensagempop.getText();
		Assert.assertEquals("Your contact has been added!", msgpop);
			
	}
	@AfterEach
	public void tearDown() {
		driver.quit();
	}
}
