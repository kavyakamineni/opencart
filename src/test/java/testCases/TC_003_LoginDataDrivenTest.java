package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class ,groups= {"datadriven"})
	public void testloginDDT(String email,String pwd,String exp) {
		
		logger.info("****String Tc_003**********");

		try{//Homepage login Myaccountpage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		//login page
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		//check my account label exists
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExists();
		if(exp.equals("Valid"))
		{if(targetpage==true)
		{
			macc.clicklogout();
			Assert.assertTrue(true);
		}
		else {Assert.fail();}
		}
		if(exp.equals("Invalid"))
		{if(targetpage==true)
		{
			macc.clicklogout();
			Assert.fail();
		}
		else {Assert.assertTrue(true);}
		}}
		 catch(Exception e) {Assert.fail();}
	
		
		logger.info("****Tc_003 completed****");
	}}
