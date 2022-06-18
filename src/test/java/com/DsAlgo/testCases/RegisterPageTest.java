package com.DsAlgo.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.DsAlgo.Pages.GetStartedPage;
import com.DsAlgo.Pages.HomePage;
import com.DsAlgo.Pages.RegisterPage;
import com.DsAlgo.base.TestBase;
import com.DsAlgo.util.ExcelUtil;
import com.DsAlgo.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class RegisterPageTest extends TestBase{
	
	public RegisterPageTest()
	{
		super();
	}
	
	@Parameters("browserName")
	@BeforeMethod
	public void setUp(String browserName)
	{
		initialize(browserName);
		GetStartedPg = new GetStartedPage();
		homePg = new HomePage();
		registerPg = new RegisterPage();
		
		GetStartedPg.clickGetStarted();
		homePg.clickRegister();
		
	}
	
	@Test(priority=0)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description = The user clicks register, the user should be redirected to register page")
	public void registerPageLoadTest()
	{
		String title = registerPg.PageLoad();
		Assert.assertEquals(title,TestUtil.registerPageTitle);
	}
	
	
	@Test(dataProvider = "getData",priority=1)
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Description = The user enters userName and password, The user should be redirected to Homepage with the message New Account Created.")
	public void registerTest(String userName, String password) throws InterruptedException
	{
		registerPg.sendUserName(userName);
		registerPg.sendPassword(password);
		registerPg.confirmPwd(password);
		registerPg.clickRegister();
		String Msg = homePg.getSuccessMsg();
		Assert.assertEquals(Msg, TestUtil.getSuccessMsg());
	}
	
	@Test(priority=2)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Description:The user clicks \"Sign-in\" 	It should display an error \"Please fill out this field\" below Username textbox")
	public void emptyFieldsTest()  
	{
		String popUpMsg = registerPg.clickEmptyRegister();
		Assert.assertEquals(popUpMsg, TestUtil.getPopUpError());
		
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