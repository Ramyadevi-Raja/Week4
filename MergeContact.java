package week4.Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[@href='/crmsfa/control/mergeContactsForm']")).click();
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		List<String> list = new ArrayList(windowHandles);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1])[1]")).click();
		System.out.println(windowHandles);
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		System.out.println(windowHandles);
		List<String> list1 = new ArrayList(windowHandles1);
		driver.switchTo().window(list1.get(1));
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1])[2]")).click();
		driver.findElement(By.className("buttonDangerous")).click();
		driver.switchTo().alert().accept();
		driver.getTitle();
	}

}

