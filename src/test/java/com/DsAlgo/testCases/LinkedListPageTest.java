package com.DsAlgo.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.DsAlgo.Pages.GetStartedPage;
import com.DsAlgo.Pages.HomePage;
import com.DsAlgo.Pages.LinkedListPage;
import com.DsAlgo.Pages.SignInPage;
import com.DsAlgo.base.TestBase;

import com.DsAlgo.util.TestUtil;
import com.DsAlgo.util.ExcelUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LinkedListPageTest extends TestBase {
	
	public LinkedListPageTest()
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
		LinkedListPg = new LinkedListPage();
		
		GetStartedPg.clickGetStarted();
		homePg.clickSignIn();
		String[][] data = getData();
		String userName = data[0][0];
		String password = data[0][1];
		signInPg.sendUserName(userName);
		signInPg.sendPassword(password);
		signInPg.clickLogin();
		homePg.clickLinkedListPage();
		
	}
	
	public String[][] getData()
	{
		String [][] data = ExcelUtil.getSheetData(TestUtil.XLPath,"SignIn_Valid");
		System.out.println("inside dataprovider");
		return data;
	}
	
	@Test(priority=0)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks the \"Getting Started\" button in Linked List Pane, The user should be directed to \"Linked List \" Page")
	public void LinkedListPageLoadTest()
	{
		Assert.assertEquals(driver.getTitle(), TestUtil.LinkedListTitle);
	}
	
	@Test(priority=1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks \"Introduction\" button, The user should be directed to \"Introduction\" of Linked List Page")
	public void LlIntroPageLoadTest()
	{
		LinkedListPg.clickIntro();
		Assert.assertEquals(driver.getTitle(),TestUtil.IntroPageTitle);
	}
	
	@Test(priority=2)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks the \"Creating a Linked List\" button,The user should be directed to \"Creating Linked List\" Page")
	public void LlCreatePageLoadTest()
	{
		LinkedListPg.clickCreate();
		Assert.assertEquals(driver.getTitle(),TestUtil.CreatePageTitle);
	}
	
	@Test(priority=3)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks the \"Types of Linked List\" button,The user should be directed to \"Types of Linked List\" Page")
	public void LlTypePageLoadTest()
	{
		LinkedListPg.clickTypes();
		Assert.assertEquals(driver.getTitle(),TestUtil.TypesPageTitle);
	}
	
	@Test(priority=4)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks the \"Implement Linked List in Python\" button	The user should be directed to \"Implement Linked List in Python\" Page")
	public void LlImplementPageLoadTest()
	{
		LinkedListPg.clickImplement();
		Assert.assertEquals(driver.getTitle(),TestUtil.ImplementTitle);
	}
	
	@Test(priority=5)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks the \"Traversal\" button	The user should be directed to \"Traversal\" Page")
	public void LlTraversePageLoadTest()
	{
		LinkedListPg.clickTraverse();
		Assert.assertEquals(driver.getTitle(),TestUtil.TraverseTitle);
	}
	
	@Test(priority=6)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks the \"Insertion\" button	The user should be directed to \"Insertion\" Page")
	public void LlInsertPageLoadTest()
	{
		LinkedListPg.clickInsert();
		Assert.assertEquals(driver.getTitle(),TestUtil.InsertTitle);
	}
	
	@Test(priority=7)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks the \"Deletion\" button	The user should be directed to \"Deletion\" Page")
	public void LlDeletePageLoadTest()
	{
		LinkedListPg.clickDelete();
		Assert.assertEquals(driver.getTitle(),TestUtil.DeleteTitle);
	}
	
	@Test(priority=8)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks \"Practice Questions\" button	The user should be redirected to \"Practice\" page")
	public void LlPracticePageLoadTest()
	{
		LinkedListPg.clickIntro();
		LinkedListPg.clickPractice();
		Assert.assertEquals(driver.getTitle(), TestUtil.PractisePgTitle);
	}
	
	@Test(priority=9)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks \"Try Here\" button")
	public void LlTryHerePageLoadTest()
	{
		LinkedListPg.clickIntro();
		LinkedListPg.clickTryHere();
		Assert.assertEquals(driver.getTitle(),TestUtil.dtcTryHereTitle);
	}
	
	@Test(priority=10)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks \"Try Here\" button	The user should be redirected to a page having an tryEditor with a Run button to test")
	public void LlIntoTryHereTest()
	{
		LinkedListPg.clickIntro();
		LinkedListPg.clickTryHere();
		LinkedListPg.query();
		LinkedListPg.clickRun();
		Assert.assertEquals(LinkedListPg.getOutput(),TestUtil.getTryHereOutput());
		
	}
	
	@Test(priority=11)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks \"Try Here\" button	The user should be redirected to a page having an tryEditor with a Run button to test")
	public void LlCreateTryHereTest()
	{
		LinkedListPg.clickCreate();
		LinkedListPg.clickTryHere();
		LinkedListPg.query();
		LinkedListPg.clickRun();
		Assert.assertEquals(LinkedListPg.getOutput(),TestUtil.getTryHereOutput());
		
	}
	
	@Test(priority=12)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks \"Try Here\" button	The user should be redirected to a page having an tryEditor with a Run button to test")
	public void LlTypesTryHereTest()
	{
		LinkedListPg.clickTypes();
		LinkedListPg.clickTryHere();
		LinkedListPg.query();
		LinkedListPg.clickRun();
		Assert.assertEquals(LinkedListPg.getOutput(),TestUtil.getTryHereOutput());
		
	}

	
	@Test(priority=13)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks \"Try Here\" button	The user should be redirected to a page having an tryEditor with a Run button to test")
	public void LlImplmntTryHereTest()
	{
		LinkedListPg.clickImplement();
		LinkedListPg.clickTryHere();
		LinkedListPg.query();
		LinkedListPg.clickRun();
		Assert.assertEquals(LinkedListPg.getOutput(),TestUtil.getTryHereOutput());
		
	}
	
	@Test(priority=14)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description:The user clicks \"Try Here\" button	The user should be redirected to a page having an tryEditor with a Run button to test")
	public void LlTraverseTryHereTest()
	{
		LinkedListPg.clickTraverse();
		LinkedListPg.clickTryHere();
		LinkedListPg.query();
		LinkedListPg.clickRun();
		Assert.assertEquals(LinkedListPg.getOutput(),TestUtil.getTryHereOutput());
	}
	
	@Test(priority=15)
	@Severity(SeverityLevel.NORMAL)
	@Description("The user clicks \"Try Here\" button	The user should be redirected to a page having an tryEditor with a Run button to test")
	public void LlInsertTryHereTest()
	{
		LinkedListPg.clickInsert();
		LinkedListPg.clickTryHere();
		LinkedListPg.query();
		LinkedListPg.clickRun();
		Assert.assertEquals(LinkedListPg.getOutput(),TestUtil.getTryHereOutput());
	}
	
	@Test(priority=16)
	@Severity(SeverityLevel.NORMAL)
	@Description("The user clicks \"Try Here\" button	The user should be redirected to a page having an tryEditor with a Run button to test")
	public void LlDeleteTryHereTest()
	{
		LinkedListPg.clickDelete();
		LinkedListPg.clickTryHere();
		LinkedListPg.query();
		LinkedListPg.clickRun();
		Assert.assertEquals(LinkedListPg.getOutput(),TestUtil.getTryHereOutput());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}