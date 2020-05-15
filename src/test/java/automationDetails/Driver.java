package automationDetails;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	
	WebDriver driver = null;
	
	public static WebDriver AbrirNavegador() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.juliodelima.com.br/taskit/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
		return driver;
	}
}
