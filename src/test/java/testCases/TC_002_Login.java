package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

@Test(groups={"sanity","master"})
public class TC_002_Login extends BaseClass
{
	
	public void test_login()
	{
		logger.info("Starting TC_002_Login");
	
	try
	{
		driver.get(rb.getString("appURL"));
		logger.info("Home Page Displayed ");
		
		driver.manage().window().maximize();
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account ");
		hp.clickLogin();
		logger.info("Clicked on Login ");
		
		LoginPage lp= new LoginPage(driver);
		
		lp.setEmail(rb.getString("email"));
		logger.info("Provided Email ");
		
		lp.setPassword(rb.getString("password"));
		logger.info("Provided Password ");
		
		lp.clickLogin();
		logger.info("Clicked on Login");
		
		
		boolean targetpage=lp.isMessageHeaderExists();
		
		if(targetpage)
		{
			logger.info("Login Success ");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Login Failed ");
			captureScreen(driver, "test_Login"); //Capturing screenshot
			Assert.assertTrue(false);
		}
	}	
	catch(Exception e)
	{
		logger.fatal("Login Failed ");
		Assert.fail();
	}
	
	logger.info(" Finished TC_002_Login ");
	
}
}

