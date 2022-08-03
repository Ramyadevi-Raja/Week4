package week4.Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class redbus {
public static void main(String[] args) throws InterruptedException {
	
	/*****opening the website******/
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.redbus.in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	/******Entering the details *******/
	driver.findElement(By.xpath("//input[@data-message='Please enter a source city']")).sendKeys("Madiwala Bangalore");
	driver.findElement(By.xpath("//li[@select-id='results[0]']")).click();
	
	//driver.findElement(By.xpath("//body/section[@id='rh_main']/div[@id='mBWrapper']/main[1]/section[1]/div[1]/div[2]/section[1]/div[1]/div[1]/div[1]/ul[1]/li[1]")).click();
	driver.findElement(By.xpath("//input[@data-message='Please enter a destination city']")).sendKeys("Koyambedu Chennai");
	driver.findElement(By.xpath("//body/section[@id='rh_main']/div[@id='mBWrapper']/main[1]/section[1]/div[1]/div[2]/section[1]/div[1]/div[2]/div[1]/ul[1]/li[1]")).click();
	
	driver.findElement(By.xpath("(//input[@class='db'])[3]")).click();
	driver.findElement(By.xpath("//td[text()='30']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[text()='Search Buses']")).click();
	
	
	/*******bus options ******/
	driver.findElement(By.xpath("//input[@id='dtAfter 6 pm']/following-sibling::label[1]")).click();
	driver.findElement(By.xpath("//input[@id='bt_SLEEPER']/following-sibling::label[1]")).click();
	driver.findElement(By.xpath("//ul[@class='tileContainer clearfix']//li[1]")).click();
	String text = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
	System.out.println("No of buses available - " +text);
	driver.findElement(By.xpath("//div[@id='root']/div[1]/div[2]/div[2]/div[3]/div[6]/a[1]")).click();
	List<WebElement> Busfare = driver.findElements(By.xpath("//div[@class='fare d-block']//span"));
	System.out.println("Bus fare in ascending - ");
	for (WebElement price : Busfare) {
	String text2 = price.getText();
	System.out.println(text2);
	}
	driver.close();
}
}
