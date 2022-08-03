package week4.Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement frame1 = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(frame1);
		WebElement frameinner = driver.findElement(By.id("frame3"));
		driver.switchTo().frame(frameinner);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		boolean selected = driver.findElement(By.xpath("//input[@type='checkbox']")).isSelected();
		if(selected) {
			System.out.println("Nested framed is accessed successfully");
		}
		else {
			System.out.println("Nested frame is not accessed");
		}
		driver.switchTo().defaultContent();
		WebElement frame2 = driver.findElement(By.id("frame2"));
		driver.switchTo().frame(frame2);
		WebElement dropdown = driver.findElement(By.id("animals"));
		Select items = new Select(dropdown);
		items.selectByIndex(3);
		boolean selected2 = driver.findElement(By.xpath("//b[text()='Animals :']/following-sibling::select")).isSelected();
		if(selected2) {
			System.out.println("frame2 is accessed successfully");
		}
		else {
			System.out.println("frame2 is not accessed");
		}

	}


}
