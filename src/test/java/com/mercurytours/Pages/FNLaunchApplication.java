package com.mercurytours.Pages;

import pkgGenericLib.ReporterLog;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class FNLaunchApplication
{
	private WebDriver driver;

	//Constructor to initialize all the Page Objects  
	public FNLaunchApplication(WebDriver driver) 
	{           
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	 //Launch  Application
	  public FNLaunchApplication LaunchApp(String appURL) throws InterruptedException 
	  {
		  driver.navigate().to(appURL);
		  
		  return new FNLaunchApplication(driver);
	  }
	 
		
		public void VerifyBasePageTitle(String ExpectedPageTitle) 
		{
			String ActualPageTitle = driver.getTitle();
			ReporterLog.info("Verifying for Page Title after Login." + ActualPageTitle);
			Assert.assertEquals(ExpectedPageTitle, ActualPageTitle);
			
		}
}
