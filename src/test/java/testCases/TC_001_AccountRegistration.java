package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass
{
	
	@Test(groups={"regression","master"})
	public void test_account_registration() {
		logger.info(" Starting TC_001_AccountRegistration ");
		
		try
		{
			logger.info("launching the driver....");
		driver.get(rb.getString("appURL"));		
		//driver.get("http://localhost/opencart/upload/");
		
		
		driver.manage().window().maximize();
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked the My Account");
		hp.clickRegister();
		logger.info("Clicked Register");
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

		regpage.setFirstName("Luna");
		logger.info("First Name Given");
		regpage.setLastName("Chattin");
		logger.info("Last name Given");
		regpage.setEmail(randomstring()+"@gmail.com");
		logger.info("Email given");
		//System.out.println(regpage.getEmail());
		logger.info("got the email");
		regpage.setTelephone("123456789");
		logger.info("Telephone number given");
		regpage.setPassword("abc123");
		logger.info("Password given");
		regpage.setConfirmPassword("abc123");
		logger.info("confirmed the password");
		regpage.setPrivacyPolicy();
		logger.info("Checked the privacy policy");
		regpage.clickContinue();
		logger.info("Clicked Continue ");
		
		
		
		String confmsg = regpage.getConfirmationMsg();

		if (confmsg.equals("Your Account Has Been Created!")) 
		{
			Assert.assertTrue(true);
			logger.info("Registration passed");
		} else 
		{
			logger.info("Registration Failed");
			captureScreen(driver, "test_accout_Registration"); //Capturing screenshot
			Assert.assertTrue(false);
			
		}
	}
        catch(Exception e)
		{
        	logger.fatal("Account Registration Failed ");
			Assert.fail();
		}
		logger.info(" Finished TC_001_AccountRegistration ");
	}
}
