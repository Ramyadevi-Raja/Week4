package week4.Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce_EditDashboard {
	public static void main(String[] args) throws InterruptedException {
		// Starting Chromedriver

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 1. Login to https://login.salesforce.com

		driver.get("https://login.salesforce.com/");
		driver.get("https://quadrantresource3-dev-ed.lightning.force.com/lightning/setup/SetupOneHome/home");
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");
		driver.findElement(By.id("Login")).click();

		// Notification Handling
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		// 2. Click on the toggle menu button from the left corner

		driver.findElement(By.xpath("(//div[@data-aura-class='uiTooltip']//div)[3]")).click();

		// 3. Click View All and click Dashboards from App Launcher

		driver.findElement(By.xpath("//lightning-button[@class='slds-button slds-p-horizontal--small']//button[1]"))
		.click();

		// Search and select dashboard in search box

		driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Dashboards", Keys.ENTER);
		driver.findElement(By.xpath("//p[@class='slds-truncate']//mark[1]")).click();

		// 5. Search the Dashboard 'Salesforce Automation by Your Name'

		driver.findElement(By.xpath("//input[contains(@class,'search-text-field slds-input')]")).sendKeys("Ramya",Keys.ENTER);
		Thread.sleep(1000);

		/*
		 * // Handling Tables
		 * 
		 * 
		 * WebElement table = driver.findElement(By.
		 * xpath("//table[contains(@class,'slds-table slds-table_header-fixed')]"));
		 * List<WebElement> rows = table.findElements(By.tagName("tr"));
		 * rows.get(0).findElement(By.
		 * xpath("(//a[@title='Salesforce Automation by Ramya'])[1]")).click();
		 * 
		 * //driver.findElement(By.
		 * xpath("(//a[@title='Salesforce Automation by Ramya'])[1]")).click();
		 */
		// 6. Click on the Dropdown icon and Select Edit
		driver.findElement(By.xpath("(//button[contains(@class,'slds-button slds-button_icon-border')]//lightning-primitive-icon)[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//lightning-menu-item[@role='presentation']//span)[2]")).click();

		// Notification Handling
		ChromeOptions option1 = new ChromeOptions();
		option1.addArguments("--disable-notifications");
		
		//Handling the frame
		WebElement framehandling = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(framehandling);
		
		//7.Click on the Edit Dashboard Properties icon
		driver.findElement(By.xpath("//button[@title='Edit Dashboard Properties']")).click();
		
		//8. Enter Description as 'SalesForce' and click on save.
		String text = "Automation script";
		driver.findElement(By.id("dashboardDescriptionInput")).sendKeys(text);
		driver.findElement(By.xpath("//span[text()='Me']")).click();
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		
		//9. Click on Done and  Click on save in the popup window displayed.
		driver.findElement(By.xpath("//div[@class='actionRibbon']/following-sibling::button[1]")).click();
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		
		//10. Verify the Description.
		String verifytext = driver.findElement(By.xpath("//p[@class='slds-page-header__info']")).getText();
		System.out.println(verifytext);
		if(text.equalsIgnoreCase(verifytext)) {
			System.out.println("Verified the Description");
		}
		else {
			System.out.println("Verification failed");
		}

		


	}
}
