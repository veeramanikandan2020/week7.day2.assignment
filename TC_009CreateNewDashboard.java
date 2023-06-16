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

public class TC_009CreateNewDashboard extends BaseClass {

	@Given("Login salesforce application")
	public void loginSales() {

		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");

		driver.findElement(By.id("password")).sendKeys("Leaf@1234");

		driver.findElement(By.id("Login")).click();

		// To switch to lighting app - use when it redirect to updated page

		// driver.findElement(By.xpath("//a[@class='switch-to-lightning']")).click();

	}

	@Then("Click toggle menu button from left corner")
	public void clickToggleMenu() {
		driver.findElement(By.xpath("//button[contains(@class,'slds-button slds-icon-waffle')]")).click();
	}

	@And("Click view All click Dashboards from App Launcher")
	public void clickDashboard() {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
	}

	@And("Click on the New Dashboard option")
	public void newDashboard() {

		Set<String> windowHandles = driver.getWindowHandles();

		List<String> handles = new ArrayList<String>(windowHandles);

		driver.switchTo().window(handles.get(0));//1

		WebElement scrollToDashboard = driver.findElement(By.xpath("//p[text()='Dashboards']"));

		Actions builder = new Actions(driver);

		builder.scrollToElement(scrollToDashboard).perform();

		driver.findElement(By.xpath("//p[text()='Dashboards']")).click();

		driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();

		System.out.println("DashBoard Title:" + driver.getTitle());

		Set<String> windowHandles2 = driver.getWindowHandles();

		List<String> handles2 = new ArrayList<String>(windowHandles2);

		driver.switchTo().window(handles2.get(0));//1

	}

	@Given("Enter your Name Click on Create")
	public void clickCreate() throws InterruptedException {

		Thread.sleep(2000);

		WebElement frame = driver.findElement(By.xpath("//iframe[@title='dashboard']"));

		driver.switchTo().frame(frame);

		driver.findElement(By.id("dashboardNameInput")).sendKeys("Salesforce Automation by Veeramanikandan");

	}

	@Then("Save Verify the Dashboard Name")
	public void verifyDashboardName() {
		
		driver.findElement(By.id("submitBtn")).click();

		String text = driver.findElement(By.xpath("//div[contains(@class,'slds-form-element__control')]/span"))
				.getText();

		System.out.println(text);

		if (text.contains("Veeramanikandan"))
			System.out.println("Dashboard Verified");
		else
			System.out.println("Dashboard not Verified");

	}

}
