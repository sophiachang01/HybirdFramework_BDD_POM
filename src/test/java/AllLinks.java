import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLinks {

	//implicit wait - dynamic wait
	//applicable to all dr.findElement commands
	public static void main(String[] args) {
		WebDriver dr = new ChromeDriver();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //dynamic wait
		dr.manage().window().maximize();
		dr.get("https://cnn.com");
		List<WebElement> links = dr.findElements(By.tagName("a"));
		System.out.println("Total links "+ links.size());
		
		WebElement tenthLinks = links.get(9);
		System.out.println(tenthLinks.getText());
		System.out.println(tenthLinks.getLocation().x);
		System.out.println(tenthLinks.getLocation().y);
		//tenthLinks.click();
		
		/*for (int i = 0; i <=links.size(); i++) {
			WebElement link = links.get(i);
			System.out.println(link.getText() + " ------ " + link.isDisplayed());
			
		}*/
		
		for (WebElement e : links) {
			System.out.println(e.getText() + " ------ " + e.isDisplayed());
		}
		
		
		
		
		
		
	
		
	
		
		
		
	}
}
