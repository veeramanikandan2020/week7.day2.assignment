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

public class TC_008CreateOpportunityWithoutMandatoryFields extends BaseClass {
	
	@Given("Login salesforce.com")
	public void login_salesforce_com() {
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		
		driver.findElement(By.id("Login")).click();
	}
	@Then("Click toggle menu button from the left corner")
	public void click_toggle_menu_button_from_the_left_corner() {
		
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-icon-waffle')]")).click();
	    
	}
	@And("Click view All click Sales from App Launcher")
	public void click_view_all_click_sales_from_app_launcher() {
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String>handles = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(handles.get(0));//1
		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		System.out.println(driver.getTitle());
	    
	}
	@And("Click Opportunities tab")
	public void click_opportunities_tab() throws InterruptedException {
		
		WebElement opportunities = driver.findElement(By.xpath("(//a[@class='slds-context-bar__label-action dndItem'])[2]"));

		driver.executeScript("arguments[0].click()", opportunities);
		
		Thread.sleep(2000);
	    
	}
	@And("Click New button")
	public void click_new_button() {
		driver.findElement(By.xpath("//div[text()='New']")).click();
	}
	
	@And("Enter opportunity name get text")
	public void enterName() {
				
				Set<String> windowHandles2 = driver.getWindowHandles();
				
				List<String> handles2 = new ArrayList<String>(windowHandles2);
				
				driver.switchTo().window(handles2.get(0));//1
				
				driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).sendKeys("Salesforce Automation by Veeramanikandan");
				
				String text = driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).getText();
				
				System.out.println(text);
	}
	
	@Then("Choose close date as Tomorrow Date")
	public void choose_close_date_as_tomorrow_date() {
		
		driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys("6/18/2023");
	    
	}
	@When("Click on save")
	public void click_on_save() {
		
		driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input slds')]")).click();
		
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
	    
	}
	@Then("Verify the Alert message")
	public void verify_the_alert_message() {
		
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		String text2 = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
		
		System.out.println(text2);
		
		if(text2.contains("Veeramanikandan"))
			System.out.println("Verified Oppurtunity Name");
		else
			System.out.println("Oppurtunity name is not verified");
	    
	}


}
