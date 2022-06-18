package com.DsAlgo.testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.DsAlgo.Pages.GetStartedPage;
import com.DsAlgo.Pages.HomePage;
import com.DsAlgo.Pages.SignInPage;
import com.DsAlgo.base.TestBase;
import com.DsAlgo.util.ExcelUtil;
import com.DsAlgo.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class HomePageTest extends TestBase {
	public HomePageTest()
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
		homePg = GetStartedPg.clickGetStarted();
	}
	
	@Test(priority=0)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks the \"Get Started\" button then The user should be redirected to homepage")
	public void homePageLoadTest()
	{
		String title= homePg.HomePageLoad();
		Assert.assertEquals(title,TestUtil.homePageTitle);
	}
	
	@Test(priority=1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:I shouls see 6 different data structure entries in that dropdown")
	public void dropDownTest()
	{
		int count = homePg.clickDropDown();
		Assert.assertEquals(count, TestUtil.dropDownCount);
	}
	
	
	@Test(priority=2)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user should see 6 panes with different data structures")
	public void paneCountTest()
	{
		int count = homePg.countPanes();
		Assert.assertEquals(count, TestUtil.paneCount);
	}
	
	@Test(priority=3)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks  \"Get Started\" button below dataStructures introduction then It should alert the user with a message \"You are not logged in\"")
	public void clickGetStartedTest()
	{
		homePg.clickDataStructures();
		HomePage.errormsg.isDisplayed();
	}
	
	@Test(priority=4)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user selects any data structures item from the drop down then It should alert the user with a message \"You are not logged in\"")
	public void selectDropDownTest()
	{
		homePg.selectDropDown("Arrays");
		HomePage.errormsg.isDisplayed();
	}
	
	@Test(priority=5)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks any of the \"Get Started\" buttons below the data structures and error msg is displayed")
	public void clickGetStartedDsTest()  //click get started on any data structure
	{
		homePg.clickArray();
		HomePage.errormsg.isDisplayed();
	}
	
	/*
	@Test(priority=6,dataProvider="getData")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:")
	public void clickDsGetStarted(String userName, String password)
	{
		homePg.clickSignIn();
		signInPg.sendUserName(userName);
		signInPg.sendPassword(password);
		signInPg.clickLogin();
		homePg.clickDataStructures();
		Assert.assertEquals(driver.getTitle(),ConstantsDefn.dataStructuresTitle);
	}
	*/
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
		
}