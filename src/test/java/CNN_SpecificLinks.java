import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CNN_SpecificLinks {


	public static void main(String[] args) {
		WebDriver dr = new ChromeDriver();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.manage().window().maximize();
		dr.get("https://cnn.com");

		WebElement box =dr.findElement(By.xpath("//*[@id='intl_homepage1-zone-1']/div[2]/div/div[3]"));
		List<WebElement> links = box.findElements(By.tagName("a"));
		System.out.println("Total Links - " + links.size());   // 10 

/*	links = box.findElements(By.xpath("//a"));
	System.out.println("Total Links - " + links.size());*/  // wrong output
		 	
			for (int i = 0; i < links.size(); i++) {

			String text = links.get(i).getText();
			System.out.println("Links text - "+ text);
			links.get(i).click();
			System.out.println(dr.getTitle());
			dr.get("http://cnn.com");
			box =dr.findElement(By.xpath("//*[@id=\"intl_homepage1-zone-1\"]/div[2]/div/div[3]"));
			links = box.findElements(By.tagName("a"));
			System.out.println("----------------------------------");

		}




	}
}
