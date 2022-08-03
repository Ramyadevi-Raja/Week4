package week4.Assignments;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittorgarh {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.chittorgarh.com/");
		driver.findElement(By.xpath("//a[@title='Stock Market']")).click();
		driver.findElement(By.xpath("//a[@href='/newportal/stock-nse-bulk-deals.asp']")).click();
		/*WebElement Elementtable = driver.findElement(By.tagName("table"));
		List<WebElement> rows = Elementtable.findElements(By.tagName("tr"));
		for(int i=0; i<rows.size();i++) {
			WebElement eachrow = rows.get(i);
			List<WebElement> cols = eachrow.findElements(By.tagName("td"));}*/
		List<WebElement> Elementtable = driver.findElements(By.xpath("//tbody/tr/td[3]"));
		List<String> list = new ArrayList();
		for (WebElement names : Elementtable) {
			list.add(names.getText());
		}
		System.out.println(list);
		for(int a=0;a<list.size()-1;a++) {
			for(int b=a+1;b<list.size(); ) {
				if(list.get(a).equalsIgnoreCase(list.get(b))){
					System.out.println(list.get(a));
				}
				break;
			}
		}
	}
}



