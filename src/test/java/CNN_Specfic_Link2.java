//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import org.apache.http.client.fluent.Request;
//import org.apache.http.client.fluent.Response;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class CNN_Specfic_Link2 {
//	static WebDriver dr= null;
//	public static void main(String[] args) {
//		dr = new ChromeDriver();
//		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		dr.manage().window().maximize();
//		//dr.get("https://cnn.com");
//		dr.navigate().to("https://cnn.com");  //remember browser history
//		String part1 = "//*[@id='intl_homepage1-zone-1']/div[2]/div/div[3]/ul/li[";
//		String part2 =" ]/article/div/div/h3/a";
//		String dynamicXpath="//*[@id='intl_homepage1-zone-1']/div[2]/div/div[3]/ul/li[%s]/article/div/div/h3/a/span[1]";
//		/*isElementPresent("//a[@id='xyz']","xpath");
//		for (int i = 2; i <=8; i++) {*/	
//		int i =2;
//		while(isElementPresent(part1+i+part2,"xpath")) {
//			String text1 = dr.findElement(By.xpath(part1+i+part2)).getText();	
//			System.out.println(text1);
//			dr.findElement(By.xpath(part1+i+part2)).click();
//			System.out.println(dr.getTitle());
//			dr.navigate().back();//back
//			i++;
//		}
//
//	}
//
//
//	//true - present
//	//false - not present
//	public static boolean isElementPresent(String locator, String locatorType) {
//		List<WebElement>  allElement = null;
//
//		if(locatorType.equals("xpath"))
//			allElement = dr.findElements(By.xpath(locator));
//		else if(locatorType.equals("cssSelector"))
//			allElement = dr.findElements(By.cssSelector(locator));
//		else if(locatorType.equals("id"))
//			allElement = dr.findElements(By.id(locator));
//		else if(locatorType.equals("name"))
//			allElement = dr.findElements(By.name(locator));
//
//		if(allElement.size()==0)
//			return false;
//		else 
//			return true;	
//
//	}
//
//	
//
//
//
//
//}
