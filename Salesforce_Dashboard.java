package week4.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce_Dashboard {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://login.salesforce.com/");
	driver.get("https://quadrantresource3-dev-ed.lightning.force.com/lightning/setup/SetupOneHome/home");
	driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
	driver.findElement(By.id("password")).sendKeys("Password$123");
	driver.findElement(By.id("Login")).click();
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--disable-notifications");
	driver.findElement(By.xpath("(//div[@data-aura-class='uiTooltip']//div)[3]")).click();
	driver.findElement(By.xpath("//lightning-button[@class='slds-button slds-p-horizontal--small']//button[1]")).click();
	driver.findElement(By.xpath("(//input[@type='search'])[3]")).sendKeys("Dashboards" , Keys.ENTER);
	driver.findElement(By.xpath("//p[@class='slds-truncate']//mark[1]")).click();
	driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();
	//WebElement frameElement =driver.findElement(By.xpath("(//iframe[@title='dashboard'])[2]"));
	//WebElement Element = driver.findElement(By.xpath("//body/div[4]/div[1]/section[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/iframe[1]"));
	driver.switchTo().frame(4);
	driver.findElement(By.id("dashboardNameInput")).sendKeys("Salesforce Automation by Ramya");
	driver.findElement(By.xpath("//button[text()='Create']")).click();
	driver.switchTo().defaultContent();
	driver.findElement(By.xpath("//button[text()='Save']")).click();
	driver.switchTo().alert();
	
}
}
