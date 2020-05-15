package test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "informacoesUsuarioTest.csv")

public class InformacoesUsuarioTest {

	private static WebDriver driver;
	
	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chrome/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.juliodelima.com.br/taskit/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	//@Test
//	public void captureScreenshot() throws Exception {
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File source=ts.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(source, new File("src/test/resources/print.png"));
//	}
	
	
//	@Test
//	public void testAdicionarUmaInformacaoDoUsuario() throws Exception {
//
//		driver.findElement(By.className("modal-trigger")).click();
//		
//		driver.findElement(By.xpath("//input[@placeholder='Please, tell us your login']")).sendKeys("julio0001");
//		driver.findElement(By.xpath("//input[@placeholder='Excuse me, can you tell us a secret?']")).sendKeys("123456");
//		driver.findElement(By.xpath("//a[@class='modal-action waves-effect waves-green btn-flat'][contains(text(),'Sign in')]")).click();
//		
//		WebElement element = driver.findElement(By.xpath("//ul[@class='right hide-on-med-and-down']//a[@class='me'][contains(text(),'Hi, Julio')]"));	
//		String msg = "Hi, Julio";
//		Assert.assertEquals(msg, element.getText());
//		
//		driver.findElement(By.xpath("//ul[@class='right hide-on-med-and-down']//a[@class='me'][contains(text(),'Hi, Julio')]")).click();
//		
//		WebElement about = driver.findElement(By.className("active"));	
//		String text = "ABOUT YOU";
//		Assert.assertEquals(text, about.getText());
//		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//a[contains(text(),'More data about you')]")).click();
//		
//		
//		 JavascriptExecutor js = (JavascriptExecutor) driver;
//	       js.executeScript("window.scrollBy(0, 350)", "");
//	       
//		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[2]/button[1]")).click();
//		
//		WebElement moreData = driver.findElement(By.xpath("//h4[contains(text(),'Add more data about me')]"));
//		String moreText = "Add more data about me";
//		Assert.assertEquals(moreText, moreData.getText());
//		
//		WebElement campoType = driver.findElement(By.name("type"));
//		new Select(campoType).selectByVisibleText("Phone");
//		
//		driver.findElement(By.name("contact")).sendKeys("+551100100010");
//		driver.findElement(By.xpath("//a[@class='modal-action waves-effect waves-green btn-flat']")).click();
//		
//		//tp.tirar(driver, "src/test/resources/print.png");
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File source=ts.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(source, new File("./Screenshots/AdicionarContato.png"));
//		
//		WebElement mensagempop = driver.findElement(By.id("toast-container"));
//		String msgpop = mensagempop.getText();
//		Assert.assertEquals("Your contact has been added!", msgpop);
//		
//		
//	}	
	//@Test
	public void testRemoverUmContato() throws Exception {
		
			driver.findElement(By.className("modal-trigger")).click();
			
			driver.findElement(By.xpath("//input[@placeholder='Please, tell us your login']")).sendKeys("julio0001");
			driver.findElement(By.xpath("//input[@placeholder='Excuse me, can you tell us a secret?']")).sendKeys("123456");
			driver.findElement(By.xpath("//a[@class='modal-action waves-effect waves-green btn-flat'][contains(text(),'Sign in')]")).click();
			
			WebElement element = driver.findElement(By.xpath("//ul[@class='right hide-on-med-and-down']//a[@class='me'][contains(text(),'Hi, Julio')]"));	
			String msg = "Hi, Julio";
			Assert.assertEquals(msg, element.getText());
			
			driver.findElement(By.xpath("//ul[@class='right hide-on-med-and-down']//a[@class='me'][contains(text(),'Hi, Julio')]")).click();
			
			WebElement about = driver.findElement(By.className("active"));	
			String text = "ABOUT YOU";
			Assert.assertEquals(text, about.getText());
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[contains(text(),'More data about you')]")).click();
			
			JavascriptExecutor remove = (JavascriptExecutor) driver;
			remove.executeScript("window.scrollBy(0, 300)","");
			
			driver.findElement(By.xpath("//li[420]//a[1]//i[1]")).click();
			
			driver.switchTo().alert().accept();
			
			WebElement popup = driver.findElement(By.id("toast-container"));
			String mensagemPop = popup.getText();
			Assert.assertEquals("Rest in peace, dear phone!",mensagemPop);
			
			//tirando print
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/RemoverContato.png"));
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.stalenessOf(popup));
			
			driver.findElement(By.linkText("Logout"));
	}
	


	
	@AfterEach 
	public void close() {
		driver.quit();
	}
}
