package week4.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce_CreateDashboard {
public static void main(String[] args) {
	
	//Starting Chromedriver
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	//1. Login to https://login.salesforce.com

	driver.get("https://login.salesforce.com/");
	driver.get("https://quadrantresource3-dev-ed.lightning.force.com/lightning/setup/SetupOneHome/home");
	driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
	driver.findElement(By.id("password")).sendKeys("Password$123");
	driver.findElement(By.id("Login")).click();
	
	//Notification Handling
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--disable-notifications");
	
	//2. Click on the toggle menu button from the left corner

	driver.findElement(By.xpath("(//div[@data-aura-class='uiTooltip']//div)[3]")).click();
	
	//3. Click View All and click Dashboards from App Launcher

	driver.findElement(By.xpath("//lightning-button[@class='slds-button slds-p-horizontal--small']//button[1]")).click();
	
	//Search and select dashboard in search box
	
	driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Dashboards" , Keys.ENTER);
	driver.findElement(By.xpath("//p[@class='slds-truncate']//mark[1]")).click();
	
	//4. Click on the New Dashboard option 

	driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();
	String title = driver.getTitle();
	System.out.println(title);
	
	//5.Handle the frame

	WebElement frameElement =driver.findElement(By.tagName("iframe"));
	//WebElement Element = driver.findElement(By.xpath("//body/div[4]/div[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/iframe[1]"));
	driver.switchTo().frame(frameElement);
	
	//6. Enter Name as 'Salesforce Automation by Your Name ' and Click on Create.

	driver.findElement(By.id("dashboardNameInput")).sendKeys("Salesforce Automation by Ramya");
	driver.findElement(By.xpath("//button[text()='Create']")).click();
	driver.switchTo().defaultContent();
	
	//7.Click on Save and Verify Dashboard name.

	//WebElement frameElement1 =driver.findElement(By.tagName("iframe"));
	WebElement Element = driver.findElement(By.xpath("//body/div[4]/div[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/iframe[1]"));
	driver.switchTo().frame(Element);
	option.addArguments("--disable-notifications");
	String text = driver.findElement(By.xpath("//span[contains(@class,'slds-form-element__static slds-grid')]")).getText();
	System.out.println(text);
//	driver.findElement(By.xpath("(//div[@id='ijDYEQRHuv']//button)[1]")).click();
	driver.findElement(By.xpath("//button[text()='Save']")).click();
	String title1 = driver.getTitle();
	System.out.println(title1);
	
}
}
