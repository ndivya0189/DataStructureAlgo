package com.DsAlgo.testCases;



	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;
	import com.DsAlgo.Pages.ArraysPage;
    import com.DsAlgo.Pages.GetStartedPage;
    import com.DsAlgo.Pages.HomePage;
    import com.DsAlgo.Pages.SignInPage;
    import com.DsAlgo.base.TestBase;
	import com.DsAlgo.util.TestUtil;
	import com.DsAlgo.util.ExcelUtil;
	import io.qameta.allure.Description;
	import io.qameta.allure.Severity;
	import io.qameta.allure.SeverityLevel;

	public class ArraysPageTest extends TestBase {

		public ArraysPageTest()
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
			arraysPg = new ArraysPage();
			
			homePg = GetStartedPg.clickGetStarted();
			signInPg = homePg.clickSignIn();
			String[][] data = getData();
			String userName = data[0][0];
			String password = data[0][1];
			signInPg.sendUserName(userName);
			signInPg.sendPassword(password);
			signInPg.clickLogin();
			arraysPg = homePg.clickArray();

		}
		
		
		
		@Test(priority=0)
		@Severity(SeverityLevel.NORMAL)
		@Description("Test Description: The user be directed to \"ARRAY\" Data Structure Page")
		public void arraysPageLoadTest()
		{
			String title = driver.getTitle();
			Assert.assertEquals(title,TestUtil.arraysPageTitle);
		}
		
		@Test(priority=1)
		@Severity(SeverityLevel.NORMAL)
		@Description("Test Description: The user clicks \"Arrays in Python\" button, The user should be redirected to \"Arrays in Python\" page")
		public void arraysInPythonPageLoadTest()
		{	
			arraysPg.clickArraysInPython();
			String title = driver.getTitle();
			Assert.assertEquals(title,TestUtil.arraysInPythonTitle);
		}
		
		@Test(priority=2)
		@Severity(SeverityLevel.NORMAL)
		@Description("Test Description: The user clicks \"Arrays using List\" button, The user should be redirected to \"Arrays using List\" page")
		public void arraysListPageLoadTest()
		{	
			arraysPg.clickArraysList();
			String title = driver.getTitle();
			Assert.assertEquals(title,TestUtil.arraysListTitle);
		}
		
		@Test(priority=3)
		@Severity(SeverityLevel.NORMAL)
		@Description("Test Description: The user clicks \"Basic Operations in List\" button, The user should be redirected to \"Basic Operations in List\" page")
		public void arraysBasicOpsPageLoadTest()
		{	
			arraysPg.clickBasicoperations();
			String title = driver.getTitle();
			Assert.assertEquals(title,TestUtil.arraysBasicOpsTitle);
		}
		
		@Test(priority=4)
		@Severity(SeverityLevel.NORMAL)
		@Description("Test Description: The user clicks \"Applications of Array\" button, The user should be redirected to \"Applications of Array\" page")
		public void arraysAppsPageLoadTest()
		{	
			arraysPg.clickApplications();
			String title = driver.getTitle();
			Assert.assertEquals(title,TestUtil.arraysAppsTitle);
		}
		
		@Test(priority=5)
		@Severity(SeverityLevel.NORMAL)
		@Description("Test Desc: The user clicks \"Practice Questions\" button, The user should be redirected to \"Practice\" page")
		public void practiceQnsPageLoadTest()
		{
			arraysPg.clickArraysInPython();
			arraysPg.clickPractice();
			String title=driver.getTitle();
			Assert.assertEquals(title, TestUtil.PractisePgTitle);
		}
		
		@Test(priority=6)
		@Severity(SeverityLevel.NORMAL)
		@Description("Test Description: The user clicks \"Try Here\" button")
		public void tryHerePageLoadTest()
		{
			arraysPg.clickArraysInPython();
			arraysPg.clickTryHere();
			String title=driver.getTitle();
			Assert.assertEquals(title, TestUtil.dtcTryHereTitle);
		}
		
		@Test(priority=7)
		@Severity(SeverityLevel.NORMAL)
		@Description("Test Description: The user clicks \"Try Here\" button in arrays in python page, The user gives the input in text editor and clicks run to get the output")
		public void arraysInPyPgtryTest()
		{
			arraysPg.clickArraysInPython();
			arraysPg.clickTryHere();
			arraysPg.query();
			arraysPg.clickRun();
			Assert.assertEquals(arraysPg.getOutput(),TestUtil.getTryHereOutput());
			
		}
		
		@Test(priority=8)
		@Severity(SeverityLevel.NORMAL)
		@Description("Test Description: The user clicks \"Try Here\" button in arrays using List page, The user gives the input in text editor and clicks run to get the output")
		public void arraysListtryTest()
		{
			arraysPg.clickArraysList();
			arraysPg.clickTryHere();
			arraysPg.query();
			arraysPg.clickRun();
			Assert.assertEquals(arraysPg.getOutput(), TestUtil.getTryHereOutput());
			
		}
		
		@Test(priority=9)
		@Severity(SeverityLevel.NORMAL)
		@Description("Test Description: The user clicks \"Try Here\" button in basic ops in List page, The user gives the input in text editor and clicks run to get the output")
		public void arraysBasicOpstryTest()
		{
			arraysPg.clickBasicoperations();
			arraysPg.clickTryHere();
			arraysPg.query();
			arraysPg.clickRun();
			Assert.assertEquals(arraysPg.getOutput(), TestUtil.getTryHereOutput());
			
		}
		
		@Test(priority=10)
		@Severity(SeverityLevel.NORMAL)
		@Description("Test Description: The user clicks \"Try Here\" button in applications of arrays page, The user gives the input in text editor and clicks run to get the output")
		public void arraysAppstryTest()
		{
			arraysPg.clickApplications();
			arraysPg.clickTryHere();
			arraysPg.query();
			arraysPg.clickRun();
			Assert.assertEquals(arraysPg.getOutput(),TestUtil.getTryHereOutput());
			
		}

		
		//************Practise qns page options*********************************
		@Test(priority=11)
		@Severity(SeverityLevel.NORMAL)
		@Description("Test Description:The user clicks \"Search the Array\" link,"
				+ "The user should be redirected to \"Question\" page contains a question,an tryEditor with Run and Submit buttons")
		public void validatesrchArrayTest()
		{
			arraysPg.clickArraysInPython();
			arraysPg.clickPractice();
			arraysPg.clickSrchArray();
			Assert.assertTrue(arraysPg.isQnDisplayed());
			Assert.assertTrue(arraysPg.isRunDisplayed());
			Assert.assertTrue(arraysPg.isSubmitDisplayed());
			Assert.assertTrue(arraysPg.istxtAreaDisplayed());
		}
		
		@Test(priority=12)
		@Severity(SeverityLevel.NORMAL)
		@Description("Test Description: The user clicks \"Squares of a  Sorted Array\" link,"
				+ "The user should be redirected to \"Question\" page contains a question,an tryEditor with Run and Submit buttons")
		public void validatesrtdArrayTest()
		{
			arraysPg.clickArraysInPython();
			arraysPg.clickPractice();
			arraysPg.clickSortedArray();
			Assert.assertTrue(arraysPg.isQnDisplayed());
			Assert.assertTrue(arraysPg.isRunDisplayed());
			Assert.assertTrue(arraysPg.isSubmitDisplayed());
			Assert.assertTrue(arraysPg.istxtAreaDisplayed());
		}
		
		@Test(priority=13)
		@Severity(SeverityLevel.NORMAL)
		@Description("Test Description: The user clicks the \"Max Consecutive Ones\" link,"
				+ "The user should be redirected to \"Question\" page contains a question,an tryEditor with Run and Submit buttons")
		public void validateMaxConsecutivePageTest()
		{
			arraysPg.clickArraysInPython();
			arraysPg.clickPractice();
			arraysPg.clickMax();
			Assert.assertTrue(arraysPg.isQnDisplayed());
			Assert.assertTrue(arraysPg.isRunDisplayed());
			Assert.assertTrue(arraysPg.isSubmitDisplayed());
			Assert.assertTrue(arraysPg.istxtAreaDisplayed());
		}
		
		@Test(priority=14)
		@Severity(SeverityLevel.NORMAL)
		@Description("Test Description:The user clicks \"Find Numbers with Even Number of Digits\" link,"
				+ " The user should be redirected to \"Question\" page contains a question,an tryEditor with Run and Submit buttons")
		public void validateEvenPageTest()
		{
			arraysPg.clickArraysInPython();
			arraysPg.clickPractice();
			arraysPg.clickEven();
			Assert.assertTrue(arraysPg.isQnDisplayed());
			Assert.assertTrue(arraysPg.isRunDisplayed());
			Assert.assertTrue(arraysPg.isSubmitDisplayed());
			Assert.assertTrue(arraysPg.istxtAreaDisplayed());
		}
		
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}

		public String[][] getData()
		{
			String [][] data = ExcelUtil.getSheetData(TestUtil.XLPath,"SignIn_Valid");
			System.out.println("inside dataprovider");
			return data;
		}
	}


