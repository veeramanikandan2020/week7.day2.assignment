package steps;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC_007CreateNewOpportunity extends BaseClass {
	
	@Given("Login to salesforce.com")
	public void login() {
		
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		
		driver.findElement(By.id("Login")).click();	
	}
	
	@Then("Click on toggle menu button from the left corner")
	public void toggleMenu() {
		
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-icon-waffle')]")).click();

	}
	@And("Click view All and click Sales from App Launcher")
	public void viewAll() {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String>handles = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(handles.get(0)); //1
		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		System.out.println(driver.getTitle());

	}
	@And("Click on Opportunities tab")
	public void clickOpportunities() throws InterruptedException {
		WebElement opportunities = driver.findElement(By.xpath("(//a[@class='slds-context-bar__label-action dndItem'])[2]"));

		driver.executeScript("arguments[0].click()", opportunities);
		
		Thread.sleep(2000);
	}
	@And("Click on New button")
	public void clickNewButton() {
		driver.findElement(By.xpath("//div[text()='New']")).click();
	}
	@Given("Enter Opportunity name as Salesforce Automation by Your Name")
	public void enterYourName() {
		Set<String> windowHandles2 = driver.getWindowHandles();
		
		List<String> handles2 = new ArrayList<String>(windowHandles2);
		
		driver.switchTo().window(handles2.get(0));//1
		
		driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).sendKeys("Salesforce Automation by Veeramanikandan");
		
		String text = driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).getText();
		
		System.out.println(text);
		
	}
	@Then("Choose close date as Today")
	public void closeDate() {
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys("6/14/2023");
		
		driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds')]")).click();
	}
	@When("Select Stage as Needs Analysis")
	public void stage() {
		driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds')]")).click();
		
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();

	}
	@Then("click Save and Verify Opportunity Name")
	public void saveAndVerify() {
		
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		String text2 = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
		
		System.out.println(text2);
		
		if(text2.contains("Veeramanikandan"))
			System.out.println("Verified Oppurtunity Name");
		else
			System.out.println("Oppurtunity name is not verified");
	}
	
}
