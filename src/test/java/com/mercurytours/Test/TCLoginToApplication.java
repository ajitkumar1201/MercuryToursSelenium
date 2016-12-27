package com.mercurytours.Test;

import pkgGenericLib.GetWebDriverInstance;

import com.mercurytours.Pages.FNLoginToApplication;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class TCLoginToApplication 
{
	
	public WebDriver driver;
	
	@Test(groups="TCLoginToApplication")
	@Parameters({"browser","userID","password"})
 
  public void Login(String browser,String userID, String password) throws InterruptedException, MalformedURLException 
  {
	  
		driver=GetWebDriverInstance.getBrowser(browser);
	
	  	FNLoginToApplication objLoginToApplication = new FNLoginToApplication(driver);
	  	objLoginToApplication.userLogin(userID, password);
	  	
     
  }
}
