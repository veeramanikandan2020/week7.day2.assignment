package steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC010_CreateAccounts extends BaseClass {
	
	@Given("Login salesforce app")
	public void loginSalesapp() {
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		
		driver.findElement(By.id("Login")).click();
		
		// To switch to lighting app 
		//driver.findElement(By.xpath("//a[@class='switch-to-lightning']")).click();
	}
	@Then("Click toggle menu button")
	public void clickmenu() {
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-icon-waffle')]")).click();

	}
	@And("Click view All click Sales App Launcher")
	public void viewAllClickSales() {
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String>handles = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(handles.get(0));//1
		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
	}
	@And("Click on Accounts tab")
	public void clickAccountTab() throws InterruptedException {
		Thread.sleep(2000);
		
		WebElement findElement = driver.findElement(By.xpath("//a[@href='/lightning/o/Account/home']"));

		driver.executeScript("arguments[0].click()", findElement); 
		
		Thread.sleep(2000);

	}
	@And("ClickNewbutton")
	public void clickNewButton() {
		driver.findElement(By.xpath("//div[text()='New']")).click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();

		List<String> handles2 = new ArrayList<String>(windowHandles2);
		
		driver.switchTo().window(handles2.get(0));//1

	}
	@Given("Enter your Name as account name")
	public void enterAccountName() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Veeramanikandan");
		
		WebElement scrollToOwnership = driver.findElement(By.xpath("//label[text()='Ownership']")); 
		
		Actions builder = new Actions(driver);
		
		builder.scrollToElement(scrollToOwnership).perform();
		
		Thread.sleep(2000);	

	}
	@Then("Select Ownership as Public")
	public void selectPublic() {
		WebElement ownership = driver.findElement(By.xpath("//button[@aria-label='Ownership, --None--']"));
		
		driver.executeScript("arguments[0].click()", ownership);
		
		driver.findElement(By.xpath("//span[@title='Public']")).click();

	}
	@When("ClickSave")
	public void clickSave() {
		driver.findElement(By.xpath("//button[text()='Save']")).click();

	}
	@Then("Verify the Account Name")
	public void verifyAccountName() {
		
		String accountName = driver.findElement(By.xpath("//lightning-formatted-text[@class='custom-truncate']")).getText();
		
		System.out.println(accountName);
		
		if(accountName.contains("Veeramanikandan"))
			System.out.println("Create Account is Verified");
		else
			System.out.println("Create Account is not verified");

	}

}
