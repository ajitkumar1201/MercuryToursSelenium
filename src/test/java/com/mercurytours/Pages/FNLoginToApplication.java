package com.mercurytours.Pages;
import pkgGenericLib.ReporterLog;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;



public class FNLoginToApplication
{
	private WebDriver driver;

	//Constructor to initialize all the Page Objects  
	public FNLoginToApplication(WebDriver driver) 
	{           
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	//Objects for SignIn Page
	 @FindBy(name= "userName") private WebElement UserName;
	 @FindBy(name= "password") private WebElement Password;
	 @FindBy(name= "login") private WebElement Login;

	 //Login to Application
	  public FNLoginToApplication userLogin(String userName, String userPassword) throws InterruptedException 
	  {
		  if(UserName.isDisplayed())
		  {
			  WebDriverWait wait = new WebDriverWait(driver, 10);      
			
			  ReporterLog.info("");
			  UserName.sendKeys(userName);
			  Password.sendKeys(userPassword);
			  Login.click();
			    Thread.sleep(18000);
		  }
		  return new FNLoginToApplication(driver);
	  }
	  /*public String getPageTitle(){
			String title = driver.getTitle();
			return title;
		}
		
		public boolean verifyBasePageTitle() 
		{
			String expectedPageTitle=null;
			return getPageTitle().contains(expectedPageTitle);
		}*/
}
