package com.mercurytours.Pages;

import pkgGenericLib.*;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FNFlightFinder 
{
	private WebDriver driver;
	//Constructor to initialize all the Page Objects  
		public FNFlightFinder(WebDriver driver) 
		{           
			this.driver = driver; 
			PageFactory.initElements(driver, this);
			
		}
//=========================================================================================================================
		//Objects for Flight Finder Page
		//Type
		 		@FindBy(name="tripType")List<WebElement> radioBtnSelectTrip;
		//Passengers
		 		@FindBy(name= "passCount") private WebElement objPassengerCount;
		//Departing From:
		 		@FindBy(name= "fromPort") private WebElement objDepartingFrom;
		 //Arriving In::
		 		@FindBy(name= "toPort") private WebElement objArrivingIn;
		//Month
		 		@FindBy(name= "fromMonth") private WebElement objOnMonth;
		//Day
		 		@FindBy(name= "fromDay") private WebElement objOnDay;	
		//Returning Month
		 		@FindBy(name= "toMonth") private WebElement objReturningMonth;
		//Returning Day
		 		@FindBy(name= "toDay") private WebElement objReturningDay;	 
		//Service Class
		 		@FindBy(name="servClass")List<WebElement> radioBtnServiceClass;
		//Continue Button
		 		@FindBy(name="findFlights")private WebElement objContinue;
		 		
//==============================================================================================================================================		
		 //Flight Booking
		  public FNFlightFinder fligtBookingDetails(String tripType,String  passengerCount,String DepartingFrom,String ArrivingIn,String OnMonth,String OnDay,String ReturningMonth,String ReturningDay,String ServiceClass) throws InterruptedException 
		  {
			  Synchronization.implicitWait(driver, 10);
			  
			  int iSize =  radioBtnSelectTrip.size();
			
				  for(int i=0; i < iSize ; i++ )
				  {
					  String sValue = radioBtnSelectTrip.get(i).getAttribute("value");
					 
					  if(tripType.equalsIgnoreCase(sValue))
					  {
						
						 if (tripType.equalsIgnoreCase("oneway"))
						 {
							 
							  radioBtnSelectTrip.get(i).click();
							  new Select(objPassengerCount).selectByVisibleText(passengerCount);
							  new Select(objDepartingFrom).selectByVisibleText(DepartingFrom);
							  new Select(objArrivingIn).selectByVisibleText(ArrivingIn);
							  new Select(objOnMonth).selectByVisibleText(OnMonth);
							  new Select(objOnDay).selectByVisibleText(OnDay);
							  break;
					 
						 }
						 else if (tripType.equalsIgnoreCase("roundtrip"))
						 {
							  radioBtnSelectTrip.get(i).click();
							  new Select(objPassengerCount).selectByVisibleText(passengerCount);
							  new Select(objDepartingFrom).selectByVisibleText(DepartingFrom);
							  new Select(objArrivingIn).selectByVisibleText(ArrivingIn);
							  new Select(objOnMonth).selectByVisibleText(OnMonth);
							  new Select(objOnDay).selectByVisibleText(OnDay);
							  new Select(objReturningMonth).selectByVisibleText(ReturningMonth);
							  new Select(objReturningDay).selectByVisibleText(ReturningDay);
							  break;
						 }
				  }
				
				  }
				   iSize =  radioBtnServiceClass.size();
				   for(int i=0; i < iSize ; i++ )
				   {
						  String sValue = radioBtnServiceClass.get(i).getAttribute("value");
						  if(ServiceClass.equalsIgnoreCase(sValue))
						  {
							  radioBtnServiceClass.get(i).click();
						  }
				   }
				   objContinue.click();
				   ReporterLog.info("Searching Flight. ");
				   ReporterLog.info("Source:"+DepartingFrom+'\n'+"Destination:"+ArrivingIn);
				   ReporterLog.info("Date:"+OnMonth+":"+OnDay+'\n'+"Service Class:"+ServiceClass);
				   ReporterLog.info("================================================");
				   
			  return new FNFlightFinder(driver);
		  }

}
