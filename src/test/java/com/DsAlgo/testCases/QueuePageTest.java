package com.DsAlgo.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.DsAlgo.Pages.GetStartedPage;
import com.DsAlgo.Pages.HomePage;
import com.DsAlgo.Pages.QueuePage;
import com.DsAlgo.Pages.SignInPage;
import com.DsAlgo.base.TestBase;
import com.DsAlgo.util.ExcelUtil;
import com.DsAlgo.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class QueuePageTest extends TestBase{
	
	public QueuePageTest()
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
		queuePg = new QueuePage();
		
		GetStartedPg.clickGetStarted();
		homePg.clickSignIn();
		String[][] data = getData();
		String userName = data[0][0];
		String password = data[0][1];
		signInPg.sendUserName(userName);
		signInPg.sendPassword(password);
		signInPg.clickLogin();
		homePg.clickQueuePage();
			
	}
	
	public String[][] getData()
	{
		String [][] data = ExcelUtil.getSheetData(TestUtil.XLPath,"SignIn_Valid");
		return data;
	}
	
	@Test(priority=0)
	@Description("TestDescription: Check - The user should be directed to Queue Page")
	@Severity(SeverityLevel.NORMAL)
	public void queuePageLoadTest()
	{
		Assert.assertEquals(driver.getTitle(),TestUtil.queuePageTitle);
	}
	
	@Test(priority=1)
	@Description("TestDescription: check -The user clicks \"Implementation of Queue in Python\" button,The user should be directed to \"Implementation of Queue in Python\" Page")
	@Severity(SeverityLevel.NORMAL)
	public void queueImplmntPageLoadTest()
	{
		queuePg.clickQueueImplmnt();
		Assert.assertEquals(driver.getTitle(), TestUtil.queueImplmntPageTitle);
	}
	
	@Test(priority=2)
	@Description("TestDescription: check -The user clicks \"Implementation using Array\" button, The user should be directed to \"Implementation using Array\" Page")
	@Severity(SeverityLevel.NORMAL)
	public void Queue_arraysImplmntPageLoadTest()
	{
		queuePg.clickArraysImplmnt();
		Assert.assertEquals(driver.getTitle(), TestUtil.Queue_arraysImplmntPageTitle);
	}
	
	@Test(priority=3)
	@Description("TestDescription: check -The user clicks \"Implementation using Collections.deque\" button, The user should be directed to \"Implementation using Collections.deque\" Page")
	@Severity(SeverityLevel.NORMAL)
	public void Queue_dequeueImplmntPageLoadTest()
	{
		queuePg.clickDequeueImplmnt();
		Assert.assertEquals(driver.getTitle(), TestUtil.Queue_dequeueImplmntPageTitle);
	}
	
	
	@Test(priority=4)
	@Description("TestDescription: check -The user clicks \"Queue Operations\" button, The user should be directed to \"Queue Operations\" Page")
	@Severity(SeverityLevel.NORMAL)
	public void Queue_queueOpsPageLoadTest()
	{
		queuePg.clickQueueOps();
		Assert.assertEquals(driver.getTitle(), TestUtil.Queue_queueOpsPageTitle);
	}
	
	@Test(priority=5)
	@Description("TestDescription: check - The user clicks \"Try Here\" button,The user should be redirected to a page having an tryEditor with a Run button to test")
	@Severity(SeverityLevel.NORMAL)
	public void QueueImplmnt_clickTryTest()
	{
		queuePg.clickQueueImplmnt();
		queuePg.clickTryHere();
		queuePg.query();
		queuePg.clickRun();
		Assert.assertEquals(queuePg.getOutput(), TestUtil.getTryHereOutput());
	}
	
	@Test(priority=6)
	@Description("TestDescription: check - The user clicks \"Try Here\" button,The user should be redirected to a page having an tryEditor with a Run button to test")
	@Severity(SeverityLevel.NORMAL)
	public void dequeueImplmntPg_clickTryTest()
	{
		queuePg.clickDequeueImplmnt();
		queuePg.clickTryHere();
		queuePg.query();
		queuePg.clickRun();
		Assert.assertEquals(queuePg.getOutput(), TestUtil.getTryHereOutput());
	}
	
	@Test(priority=7)
	@Description("TestDescription: check - The user clicks \"Try Here\" button,The user should be redirected to a page having an tryEditor with a Run button to test")
	@Severity(SeverityLevel.NORMAL)
	public void arraysImplmntPg_clickTryTest()
	{
		queuePg.clickArraysImplmnt();
		queuePg.clickTryHere();
		queuePg.query();
		queuePg.clickRun();
		Assert.assertEquals(queuePg.getOutput(),TestUtil.getTryHereOutput());
	}
	
	@Test(priority=8)
	@Description("TestDescription: check - The user clicks \"Try Here\" button,The user should be redirected to a page having an tryEditor with a Run button to test")
	@Severity(SeverityLevel.NORMAL)
	public void queueOpsPg_clickTryTest()
	{
		queuePg.clickQueueOps();
		queuePg.clickTryHere();
		queuePg.query();
		queuePg.clickRun();
		Assert.assertEquals(queuePg.getOutput(),TestUtil.getTryHereOutput());
	}
	
	@Test(priority=9)
	@Description("TestDescription: check - When user click Practise questions ,The user should be redirected to \"Practice\" page")
	@Severity(SeverityLevel.NORMAL)
	public void apps_clickPractise()
	{
		queuePg.clickQueueOps();
		queuePg.clickPractice();
		Assert.assertEquals(driver.getTitle(), TestUtil.PractisePgTitle);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
