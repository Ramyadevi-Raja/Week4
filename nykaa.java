package week4.Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class nykaa {

public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	/*driver.get("https://www.nykaa.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	WebElement brand = driver.findElement(By.xpath("(//a[@class='css-1mavm7h'])[2]"));
	Actions action = new Actions(driver);
	action.moveToElement(brand).perform();
	driver.findElement(By.xpath("//img[@src='https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png']")).click();
	String title = driver.getTitle();
	System.out.println(title);
	driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
	driver.findElement(By.xpath("(//div[@class='control-indicator radio '])[3]")).click();
	driver.findElement(By.xpath("//span[text()='Category']")).click();
	driver.findElement(By.xpath("(//div[@class=' css-b5p5ep']//span)[3]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("(//div[@class=' css-b5p5ep']//span)[1]")).click();
	driver.findElement(By.xpath("(//label[@for='checkbox_Shampoo_316']//div)[2]")).click();
	driver.findElement(By.xpath("//span[text()='Concern']")).click();
	driver.findElement(By.xpath("(//label[@for='checkbox_Color Protection_10764']//div)[2]")).click();
	//driver.findElement(By.xpath("(//label[@for='checkbox_Dry & Frizzy Hair_91638']//div)[2]")).click();
	//driver.findElement(By.xpath("(//label[@for='checkbox_Split Ends_10732']//div)[2]")).click();
	List<WebElement> selected = driver.findElements(By.className("css-1emjbq5"));
	for (WebElement selecteditems : selected) {
		String text = selecteditems.getText();
		System.out.println(text);
	}
	driver.findElement(By.xpath("(//div[@class='css-1rd7vky']//div)[1]")).click();
	Set<String> windowHandles = driver.getWindowHandles();
	System.out.println(windowHandles);
	List<String> list = new ArrayList<String>(windowHandles);
	driver.switchTo().window(list.get(1));*/
	driver.get("https://www.nykaa.com/l-oreal-paris-color-protect-shampoo/p/6282?productId=6282&pps=1&skuId=3103");
	driver.findElement(By.xpath("//span[@class=' css-ieawrs']")).click();
	String price = driver.findElement(By.xpath("//span[@class='css-1jczs19']")).getText();
	System.out.println(price);
	
	driver.findElement(By.xpath("//button[@class=' css-12z4fj0']")).click();
	driver.findElement(By.xpath("//header/div[@id='header_id']/div[2]/div[1]/div[2]/div[2]/button[1]")).click();
	
	/*WebElement frames = driver.findElement(By.className("css-acpm4k"));
	driver.switchTo().frame(frames);*/
	
	String totalprice = driver.findElement(By.xpath("(//p[@class='css-mye8g1 eka6zu20'])[2]")).getText();
	System.out.println(totalprice);
}
}
