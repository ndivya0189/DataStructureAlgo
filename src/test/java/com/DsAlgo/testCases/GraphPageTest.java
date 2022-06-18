

package com.DsAlgo.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.DsAlgo.Pages.GetStartedPage;
import com.DsAlgo.Pages.GraphPage;
import com.DsAlgo.Pages.HomePage;
import com.DsAlgo.Pages.SignInPage;
import com.DsAlgo.base.TestBase;
import com.DsAlgo.util.ExcelUtil;
import com.DsAlgo.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Listeners({AllureListener.class})
public class GraphPageTest extends TestBase{  
	
	public GraphPageTest()
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
		graphPg = new GraphPage();
		
		GetStartedPg.clickGetStarted();
		homePg.clickSignIn();
		String[][] data = getData();
		String userName = data[0][0];
		String password = data[0][1];
		signInPg.sendUserName(userName);
		signInPg.sendPassword(password);
		signInPg.clickLogin();
		graphPg = homePg.clickGraphPage();
		
	}
	
	public String[][] getData()
	{
		String [][] data = ExcelUtil.getSheetData(TestUtil.XLPath,"SignIn_Valid");
		return data;
	}
	
	@Test(priority=0)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description -When The user clicks the \"Getting Started\" button in Graph Pane, The user should be directed to \"Graph\" Page")
	public void graphPageLoadTest()
	{
		
		Assert.assertEquals(driver.getTitle(),TestUtil.graphPgTitle);	
	}
	
	@Test(priority=1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description -The user clicks \"Graph\" button	The user should be directed to \"Graph\" Page")
	public void graphTopicPageLoadTest()
	{
		graphPg.clickGraph();
		Assert.assertEquals("",TestUtil.graphTopicPgTitle);	
	}
	
	@Test(priority=2)
	@Severity(SeverityLevel.NORMAL)
	@Description("The user clicks \"Graph Representations\" button	The user should be directed to \"Graph Representations\" Page")
	public void graphRepPageLoadTest1()
	{
		graphPg.clickGraphRep();
		Assert.assertEquals(driver.getTitle(),TestUtil.graphRepPgTitle);	
	}
	
	@Test(priority=3)
	@Severity(SeverityLevel.NORMAL)
	@Description("The user clicks \"Try Here\" button	The user should be redirected to a page having an tryEditor with a Run button to test")
	public void graphRepPageTryTest()
	{
		graphPg.clickGraphRep();
		graphPg.clickTryHere();
		graphPg.query();
		graphPg.clickRun();
		Assert.assertEquals(graphPg.getOutput(),TestUtil.getTryHereOutput());	
	}
	
	@Test(priority=4)
	@Severity(SeverityLevel.NORMAL)
	@Description("The user clicks \"Try Here\" button	The user should be redirected to a page having an tryEditor with a Run button to test")
	public void graphTopicPageTryTest()
	{
		graphPg.clickGraphRep();
		graphPg.clickTryHere();
		graphPg.query();
		graphPg.clickRun();
		Assert.assertEquals(graphPg.getOutput(),TestUtil.getTryHereOutput());	
	}
	
	
	@AfterMethod
	public void tearDown()
	{
	  driver.quit();
	}
	
	
}