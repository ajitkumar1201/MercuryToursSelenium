package com.mercurytours.Test;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pkgGenericLib.GetWebDriverInstance;
import com.mercurytours.Pages.FNLoginToApplication;

public class TCLoginToApplication 
{
	
	public WebDriver driver;
	
	@Test(groups="TCLoginToApplication")
	@Parameters({"browser","appURL","userID","password"})
 
  public void Login(String browser,String appURL, String userID, String password) throws InterruptedException, MalformedURLException 
  {
	  
		driver=GetWebDriverInstance.getBrowser(browser);
		
	  	driver.navigate().to(appURL);
	  	FNLoginToApplication objLoginToApplication = new FNLoginToApplication(driver);
	  	objLoginToApplication.userLogin(userID, password);
	  	
     
  }
}
