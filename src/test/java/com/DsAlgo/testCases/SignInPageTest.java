package com.DsAlgo.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.DsAlgo.Pages.GetStartedPage;
import com.DsAlgo.Pages.HomePage;
import com.DsAlgo.Pages.SignInPage;
import com.DsAlgo.base.TestBase;
import com.DsAlgo.util.ExcelUtil;
import com.DsAlgo.util.TestUtil;
//import com.beust.jcommander.Parameters;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class SignInPageTest extends TestBase{
	
	public SignInPageTest()
	{
		super();
	}
	
	
	//@Parameters("browserName")
	@BeforeMethod
	@Parameters("browserName")
	public void setUp(String browserName)
	{
		initialize(browserName);
		GetStartedPg = new GetStartedPage();
		homePg = new HomePage();
		signInPg = new SignInPage();
		
		GetStartedPg.clickGetStarted();
		homePg.clickSignIn();
				
	}
	
	@Test(priority=0)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks \"Sign in\", The user should be redirected to Sign in page")
	public void signInPageLoadTest()
	{
		String title = signInPg.PageLoad();
		Assert.assertEquals(title,TestUtil.signInPageTitle);
	}
	
	@Test(dataProvider="getData",priority=1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:User enters valid userName and password, The user should be redirected to Home Page with the message \"You are logged in\"")
	public void signInTest(String UserName, String Password)
	{
		signInPg.sendUserName(UserName);
		signInPg.sendPassword(Password);
		signInPg.clickLogin();
		Assert.assertEquals(true, homePg.getloginSuccess());
		homePg.getloginSuccess();
	}
	
	@Test(dataProvider="getData",priority=2) 
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks \"Sign out\"")
	public void signoutTest(String UserName, String Password) throws IOException
	{
		signInPg.sendUserName(UserName);
		signInPg.sendPassword(Password);
		signInPg.clickLogin();
		Assert.assertEquals(true, homePg.getloginSuccess());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@DataProvider(name = "getData")
	public String[][] getData()
	{
		String [][] data = ExcelUtil.getSheetData(TestUtil.XLPath,"SignIn_Valid");
		System.out.println("inside dataprovider");
		return data;
	}

}

	
	