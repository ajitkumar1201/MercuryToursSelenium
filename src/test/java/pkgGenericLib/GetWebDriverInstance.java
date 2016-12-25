package pkgGenericLib;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class GetWebDriverInstance {

	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();
	//private static  WebDriver  driver= null;
 	private static String  genericPath=System.getProperty("user.dir").concat("\\src\\test\\resources\\");

	/*
	 * Factory method for getting browsers
	 */
	public static WebDriver getBrowser(String browserName) {
		WebDriver driver = null;

		switch (browserName) 
		{
			case "Firefox":
				   System.setProperty("webdriver.gecko.driver", "Q:\\AutomationFramework\\MercuryTours\\src\\test\\resources\\geckodriver.exe");
		 			String path=new File(".").getAbsolutePath();
	
				driver = drivers.get("Firefox");
				if (driver == null) 
				{
					driver = new FirefoxDriver();
					drivers.put("Firefox", driver);
				}
				break;
			case "IE":
				driver = drivers.get("IE");
				if (driver == null) 
				{
					System.setProperty("webdriver.ie.driver", genericPath+"IEDriverServer.exe");
					
					driver = new InternetExplorerDriver();
					drivers.put("IE", driver);
				}
			break;
			case "Chrome":
				driver = drivers.get("Chrome");
				if (driver == null) 
				{
					System.out.println(genericPath);
					
					System.setProperty("webdriver.chrome.driver",genericPath+"chromedriver.exe");  
					driver = new ChromeDriver();
					drivers.put("Chrome", driver);
				}
				break;
		}
		driver.manage().window().maximize();
 		//driver.manage().deleteAllCookies();
		return driver;
	}
	
	public static void closeAllDriver() {
		for (String key : drivers.keySet()) {
			drivers.get(key).close();
			drivers.get(key).quit();
		}
}}
