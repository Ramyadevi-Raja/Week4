package week4.Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.auth.AuthProtocolState;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Learntables_01 {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://html.com/tags/table/");
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	WebElement tabledata = driver.findElement(By.xpath("//table[@class='attributes-list']"));
	List<WebElement> rows = tabledata.findElements(By.tagName("tr"));
	System.out.println(rows.size());
	WebElement rowdata = null;
	for(int i=1;i<rows.size();i++) {
		rowdata = rows.get(i);
		}
		List<WebElement> cols = rowdata.findElements(By.tagName("td"));
		System.out.println(cols.size());
	}
}
