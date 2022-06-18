package com.DsAlgo.testCases;




import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.DsAlgo.Pages.GetStartedPage;
import com.DsAlgo.Pages.HomePage;
import com.DsAlgo.Pages.SignInPage;
import com.DsAlgo.Pages.dataStructuresPage;
import com.DsAlgo.base.TestBase;

import com.DsAlgo.util.TestUtil;
import com.DsAlgo.util.ExcelUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class dataStructuresPageTest  extends TestBase{
	
	public dataStructuresPageTest()
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
		dsPg = new dataStructuresPage();
		
		homePg = GetStartedPg.clickGetStarted();
		signInPg = homePg.clickSignIn();
		
	}
	
	@DataProvider(name="getData")
	public String[][] getData()
	{
		String [][] data = ExcelUtil.getSheetData(TestUtil.XLPath,"SignIn_Valid");
		return data;
	}
	
	@Test(priority=0,dataProvider="getData")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description: The user clicks  \"Get Started\" button then The user should be redirected to time complexity")
	public void dtcPageLoadTest(String userName, String password)
	{
		
		signInPg.sendUserName(userName);
		signInPg.sendPassword(password);
		signInPg.clickLogin();
		dsPg = homePg.clickDataStructures();
		dsPg.clickTimeComplexity();
		String title = driver.getTitle();
		Assert.assertEquals(title, TestUtil.dtcTitle);
	}
	
	@Test(priority=1,dataProvider="getData")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description: The user clicks the \"Practice Questions\" button, The user should be redirected to \"Practice Questions\" of Data structures-Introduction")
	
	public void dtcPracticeQnPageLoadTest(String userName, String password)
	{
		signInPg.sendUserName(userName);
		signInPg.sendPassword(password);
		signInPg.clickLogin();
		dsPg = homePg.clickDataStructures();
		dsPg.clickTimeComplexity();
		dsPg.clickPractice();
		String title = driver.getTitle();
		Assert.assertEquals(title, TestUtil.PractisePgTitle);
	}
	
	@Test(priority=2,dataProvider="getData")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description: The user clicks \"Try Here\" button, The user should be redirected to a page having an tryEditor with a Run button to test")
	public void dtcTryHerePageLoadTest(String userName, String password)
	{
		signInPg.sendUserName(userName);
		signInPg.sendPassword(password);
		signInPg.clickLogin();
		dsPg = homePg.clickDataStructures();
		dsPg.clickTimeComplexity();
		dsPg.clickTry();
		String title = driver.getTitle();
		Assert.assertEquals(title, TestUtil.dtcTryHereTitle);
		
	}
	
	@Test(priority=3,dataProvider="getData")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description: The user gives code in the text editor, click run, The user gets the desired output")
	public void dtcTryHereTest(String userName, String password) 
	{
		signInPg.sendUserName(userName);
		signInPg.sendPassword(password);
		signInPg.clickLogin();
		dsPg = homePg.clickDataStructures();
		dsPg.clickTimeComplexity();
		dsPg.clickTry();
		dsPg.query();
		dsPg.clickRun();
		Assert.assertEquals(dsPg.getOutput(), TestUtil.getTryHereOutput());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
