package com.mercurytours.Test;

import pkgGenericLib.GetWebDriverInstance;


import pkgGenericLib.DatabaseFunction;

import com.mercurytours.Pages.FNLaunchApplication;


import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TCLaunchApplication 
{
	
	public WebDriver driver;
	
	@Test(groups="TCLaunchApplication")
	@Parameters({"browser"})
	
  public void LaunchApplication(String browser) throws InterruptedException, MalformedURLException 
  {
		
		DatabaseFunction db = new DatabaseFunction();
		
	    String appURL=  db.fnExecuteSql("Select * from TCLaunchApplication","Input");
		driver= GetWebDriverInstance.getBrowser(browser);
		FNLaunchApplication objLaunchApplication = new FNLaunchApplication(driver);
		objLaunchApplication.LaunchApp(appURL);
		objLaunchApplication.VerifyBasePageTitle("");
	  	
	  	
     
  }
}
