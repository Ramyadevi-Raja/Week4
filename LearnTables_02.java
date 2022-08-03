package week4.Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnTables_02 {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://html.com/tags/table/");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	WebElement tabledata = driver.findElement(By.xpath("//table[@class='attributes-list']"));
	List<WebElement> rows = tabledata.findElements(By.tagName("tr"));
	System.out.println(rows.size());
	for(int i=1;i<rows.size();i++) {
		WebElement rowdata = rows.get(i);
		List<WebElement> cols = rowdata.findElements(By.tagName("td"));
		for(int j=0;j<cols.size();j++) {
			System.out.println(cols.get(j).getText());
		}
		
	}
}
}
