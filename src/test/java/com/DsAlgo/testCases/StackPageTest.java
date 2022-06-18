package com.DsAlgo.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.DsAlgo.Pages.GetStartedPage;
import com.DsAlgo.Pages.HomePage;
import com.DsAlgo.Pages.SignInPage;
import com.DsAlgo.Pages.StackPage;
import com.DsAlgo.base.TestBase;
import com.DsAlgo.util.ExcelUtil;
import com.DsAlgo.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class StackPageTest extends TestBase
{
	
	public StackPageTest()
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
		signInPg = new SignInPage();
		StackPg = new StackPage();
		GetStartedPg.clickGetStarted();
		homePg.clickSignIn();
		String[][] data = getData();
		String userName = data[0][0];
		String password = data[0][1];
		signInPg.sendUserName(userName);
		signInPg.sendPassword(password);
		signInPg.clickLogin();
		homePg.clickStackPage();
	}

	public String[][] getData()
	{
		String [][] data = ExcelUtil.getSheetData(TestUtil.XLPath,"SignIn_Valid");
		return data;
	}
	
	@Test(priority=0)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description: The user clicks the \"Getting Started\" button in Stack Pane, The user should be directed to \"Stack\" Page")
	public void stackPageLoadTest()
	{
		Assert.assertEquals(driver.getTitle(),TestUtil.StackPageTitle);
	
	}
	
	@Test(priority=1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks \"Operations in Stack\" button	The user should be directed to \"Operations in Stack\" Page")
	public void Stack_opsInStackPageLoadTest()
	{
		StackPg.clickopsInStack();
		Assert.assertEquals(driver.getTitle(),TestUtil.OpsInStackPageTitle);
	}

	@Test(priority=2)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks \"Implementation\" button	The user should be directed to \"Implementation\" Page")
	public void Stack_ImplmntPageLoadTest()
	{
		StackPg.clickImplementation();
		Assert.assertEquals(driver.getTitle(),TestUtil.ImplmntPageTitle);
	}

	
	@Test(priority=3)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks \"Applications\" button	The user should be directed to \"Applications\" Page")
	public void Stack_appsPageLoadTest()
	{
		StackPg.clickApps();
		Assert.assertEquals(driver.getTitle(),TestUtil.appsPageTitle);
	}
	
	@Test(priority=4)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks \"Try Here\" button	The user should be redirected to a page having an tryEditor with a Run button to test")
	public void OpsInStack_clickTryTest()
	{
		StackPg.clickopsInStack();
		StackPg.clickTryHere();
		StackPg.query();
		StackPg.clickRun();
		Assert.assertEquals(StackPg.getOutput(),TestUtil.getTryHereOutput());
	}
	
	@Test(priority=5)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks \"Try Here\" button	The user should be redirected to a page having an tryEditor with a Run button to test")
	public void Implmnt_clickTryTest()
	{
		StackPg.clickImplementation();
		StackPg.clickTryHere();
		StackPg.query();
		StackPg.clickRun();
		Assert.assertEquals(StackPg.getOutput(), TestUtil.getTryHereOutput());
	}
	
	@Test(priority=6)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks \"Try Here\" button	The user should be redirected to a page having an tryEditor with a Run button to test")
	public void apps_clickTryTest()
	{
		StackPg.clickApps();
		StackPg.clickTryHere();
		StackPg.query();
		StackPg.clickRun();
		Assert.assertEquals(StackPg.getOutput(),TestUtil.getTryHereOutput());
	}
	
	@Test(priority=7)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks \"Practice Questions\" button	The user should be redirected to \"Practice\" page")
	public void apps_clickPractise()
	{
		StackPg.clickApps();
		StackPg.clickPractice();
		Assert.assertEquals(driver.getTitle(),TestUtil.PractisePgTitle);
	}

	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
