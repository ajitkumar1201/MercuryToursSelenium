package com.mercurytours.Test;

import pkgGenericLib.GetWebDriverInstance;

import pkgGenericLib.DatabaseFunction;
import com.mercurytours.Pages.FNLaunchApplication;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TCLaunchApplication 
{
	
	public WebDriver driver;
	private String colVal;
	List<String> rtnListValue;
	@Test(groups="TCLaunchApplication")
	@Parameters({"browser"})
	
  public void LaunchApplication(String browser) throws InterruptedException, MalformedURLException 
  {
		driver= GetWebDriverInstance.getBrowser(browser);
		FNLaunchApplication objLaunchApplication = new FNLaunchApplication(driver);
		DatabaseFunction db = new DatabaseFunction();
		
	    rtnListValue=  db.fnExecuteSql("Select * from TCLaunchApplication","Input","appURL");
	    
	    if (rtnListValue.size() == 1)
	    {
			for(String item:rtnListValue)
			{
				colVal=item;
		    }
	    }
	    
		

		objLaunchApplication.LaunchApp(colVal);
		rtnListValue.clear();
		rtnListValue=  db.fnExecuteSql("Select * from TCLaunchApplication","Input", "pageTitle");
		
	    if (rtnListValue.size() == 1)
	    {
			for(String item:rtnListValue)
			{
				colVal=item;
		    }
	    }
		objLaunchApplication.VerifyBasePageTitle(colVal);
		rtnListValue.clear();
	  	
     
  }
}
