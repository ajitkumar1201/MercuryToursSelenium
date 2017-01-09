package com.mercurytours.Test;

import pkgGenericLib.DatabaseFunction;
import pkgGenericLib.GetWebDriverInstance;
import com.mercurytours.Pages.FNFlightFinder;
import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TCFlightFinder 
{
	public WebDriver driver;
	
	private  List<String> rtnListValue;
	
	@Test(groups="TCLaunchApplication")
	@Parameters({"browser"})
	 public void FlightDetails(String browser) throws InterruptedException, MalformedURLException 
	 {
		driver= GetWebDriverInstance.getBrowser(browser);
		FNFlightFinder objLaunchApplication = new FNFlightFinder(driver);
		DatabaseFunction db = new DatabaseFunction();
		
		rtnListValue = db.fnExecuteSql("Select * from TCFlightFinder","Input","*");
		System.out.println(rtnListValue.size());
	    if (rtnListValue.size() > 0)
	    {
	    	objLaunchApplication.fligtBookingDetails(rtnListValue.get(0),rtnListValue.get(1),rtnListValue.get(2),rtnListValue.get(3),rtnListValue.get(4),rtnListValue.get(5),rtnListValue.get(6),rtnListValue.get(7),rtnListValue.get(8));
	    }
		
	 }
	
}
