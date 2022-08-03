package week4.Assignments;


import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class snapdeal {
	public static void main(String[] args) throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("(//a[@class='menuLinks leftCategoriesProduct ']//span)[2]")).click();
		driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
		String Count_sportshoe = driver.findElement(By.xpath("/html[1]/body[1]/div[10]/div[9]/div[2]/div[2]/div[3]/span[1]")).getText();
		System.out.println("Count of sport shoe is " +Count_sportshoe);
		driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]")).click();
		driver.findElement(By.className("sort-selected")).click();
		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();
		/*WebElement startprice = driver.findElement(By.name("fromVal"));
		startprice.clear();
		startprice.sendKeys("900");
		WebElement endprice = driver.findElement(By.name("toVal"));
		endprice.clear();
		endprice.sendKeys("1200");
		driver.findElement(By.xpath("//div[text()[normalize-space()='GO']]")).click();*/
		driver.findElement(By.xpath("//label[contains(@for, 'Black')]")).click();
		Thread.sleep(1000);
		List<WebElement> trainingshoe = driver.findElements(By.xpath("//p[@class='product-title']"));
		/*for (WebElement shoedetails : trainingshoe) {
			String text = shoedetails.getText();
			System.out.println(text);}*/
		WebElement product = driver.findElement(By.xpath("//img[@title='TUFF 5005 Navy Training Shoes']"));
		Actions action = new Actions(driver);
		action.moveToElement(product).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[text()[normalize-space()='Quick View']])[1]")).click();
		String cost = driver.findElement(By.xpath("//div[contains(@class,'product-price pdp-e-i-PAY-l')]//span[1]")).getText();
		System.out.println(cost);
		String discount_per  = driver.findElement(By.xpath("(//div[contains(@class,'product-price pdp-e-i-PAY-l')]//span)[2]")).getText();
		System.out.println(discount_per);
		}

	}
