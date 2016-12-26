package com.mercurytours.Test;

import pkgGenericLib.GetWebDriverInstance;

import pkgGenericLib.DatabaseFunction;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TCLaunchApplication 
{
	
	public WebDriver driver;
	
	@Test(groups="TCLaunchApplication")
	@Parameters({"browser"})
	
  public void Login(String browser) throws InterruptedException, MalformedURLException 
  {
		DatabaseFunction db = new DatabaseFunction();
		char colVal=db.fnExecuteSql("Select appUrl from [TCLaunchApplication$]","Input");
		String appURL = String.valueOf(colVal);
		driver=GetWebDriverInstance.getBrowser(browser);
		
	  	driver.navigate().to(appURL);
	  	
	  	
     
  }
}
