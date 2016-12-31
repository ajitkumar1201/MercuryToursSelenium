package com.mercurytours.Pages;

import pkgGenericLib.ReporterLog;

import org.apache.log4j.PropertyConfigurator;
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
		ReporterLog objReporter= new ReporterLog();
	}
	
	 //Launch  Application
	  public FNLaunchApplication LaunchApp(String appURL) throws InterruptedException 
	  {
		  driver.navigate().to(appURL);
		  ReporterLog.info(appURL);
		  return new FNLaunchApplication(driver);
	  }
	 
		
		public void VerifyBasePageTitle(String ExpectedPageTitle) 
		{
			
			String ActualPageTitle = driver.getTitle();
			ReporterLog.info("Verifying for Page Title after Login." + ActualPageTitle);
			Assert.assertEquals(ExpectedPageTitle, ActualPageTitle);
			
		}
}
