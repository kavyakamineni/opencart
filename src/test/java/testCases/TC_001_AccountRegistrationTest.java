package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
		@Test(groups= {"Regression","Master"})
		public void test_account_Registration()
		{
			logger.info("****starting test case*******");
			logger.trace("capturing tracing logs");
			logger.debug("capturing debug logs");
			try
			{
			HomePage hp=new HomePage(driver);
			logger.info("clicking on my account link");
			hp.clickMyAccount();
			logger.info("clicking on register link");
			hp.clickRegister();
			
			AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
			logger.info("providing customer details");
			regpage.setFirstName(randomeString().toUpperCase());
			regpage.setLastName(randomeString().toUpperCase());
			regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
			regpage.setTelephone(randomeNumber());
			
			String password=randomAlphaNumeric();
			regpage.setPassword(password);
			regpage.setConfirmPassword(password);
			
			regpage.setPrivacyPolicy();
			logger.info("clicking on continue");
			regpage.clickContinue();
			
			String confmsg=regpage.getConfirmationMsg();
			logger.info("verifiyng customer registration");
			if(confmsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			logger.info("test passed");
				}
			else {logger.warn("regestration not successful");
				logger.error("test failed");
				Assert.assertTrue(false);}}
	
			//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
			
			catch(Exception e)
			{
				Assert.fail();
			}
			logger.info("****ending test case*****");
		}

}
