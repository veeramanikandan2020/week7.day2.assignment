package steps;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HookTest extends BaseClass {
	
	@Before
	public void preCondition() {
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(options);
		
		driver.get("https://login.salesforce.com");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	
	@After
	public void postCondition() {
		
		driver.close();
		

	}

}
