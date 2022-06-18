package com.DsAlgo.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.DsAlgo.Pages.GetStartedPage;
import com.DsAlgo.Pages.HomePage;
import com.DsAlgo.Pages.SignInPage;
import com.DsAlgo.Pages.TreePage;
import com.DsAlgo.base.TestBase;
import com.DsAlgo.util.ExcelUtil;
import com.DsAlgo.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class TreePageTest extends TestBase{
	
	public TreePageTest()
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
		treePg = new TreePage();
		
		GetStartedPg.clickGetStarted();
		homePg.clickSignIn();
		String[][] data = getData();
		String userName = data[0][0];
		String password = data[0][1];
		signInPg.sendUserName(userName);
		signInPg.sendPassword(password);
		signInPg.clickLogin();
		treePg = homePg.clickTreePage();
		
	}
	
	public String[][] getData()
	{
		String [][] data = ExcelUtil.getSheetData(TestUtil.XLPath,"SignIn_Valid");
		return data;
	}
	
	@Test(priority=0)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description -When The user clicks the \"Getting Started\" button in Tree Pane, The user should be directed to \"Tree\" Page")
	public void treePageLoadTest()
	{
		Assert.assertEquals(driver.getTitle(),TestUtil.treePgTitle);	
	}
	
	@Test(priority=1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description -When The user clicks \"Overview of Trees\" button, The user should be directed to \"Overview of Trees\" Page")
	public void overviewPageLoadTest()
	{
		treePg.clickoverview();
		Assert.assertEquals(driver.getTitle(),TestUtil.tree_overviewPgTitle );
	}
	
	@Test(priority=2)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description -When The user clicks \"Terminologies\" button, The user should be directed to \"Terminologies\" Page")
	public void terminologiesPageLoadTest()
	{
		treePg.clickterminologies();
		Assert.assertEquals(driver.getTitle(),TestUtil.tree_terminologiesPgTitle );
	}

	@Test(priority=3)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description -When The user clicks \"Types of Trees\" button, The user should be directed to \"Types of Trees\" Page")
	public void typesTreesPageLoadTest()
	{
		treePg.clicktypesTrees();
		Assert.assertEquals(driver.getTitle(),TestUtil.tree_typesTreesPgTitle );
	}
	
	@Test(priority=4)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description -When The user clicks \"Tree Traversals\" button, The user should be directed to \"Tree Traversals\" Page")
	public void treeTraversePageLoadTest()
	{
		treePg.clicktreeTraverse();
		Assert.assertEquals(driver.getTitle(),TestUtil.tree_treeTraversePgTitle );
	}

	@Test(priority=5)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description -When The user clicks \"Traversals-Illustration\" button, The user should be directed to \"Traversals-Illustration\" Page")
	public void traverseIllustrationsPageLoadTest()
	{
		treePg.clicktraverseIllustrations();
		Assert.assertEquals(driver.getTitle(),TestUtil.tree_traverseIllustrationsPgTitle );
	}
	
	@Test(priority=6)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description -When The user clicks \"Binary Trees\" button, The user should be directed to \"Binary Trees\" Page")
	public void binaryTreesPageLoadTest()
	{
		treePg.clickbinaryTrees();
		Assert.assertEquals(driver.getTitle(),TestUtil.tree_binaryTreesPgTitle );
	}
	
	
	@Test(priority=7)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description -When The user clicks \"Types of Binary Trees\" button, The user should be directed to \"Types of Binary Trees\" Page")
	public void treesTypesPageLoadTest()
	{
		treePg.clicktreesTypes();
		Assert.assertEquals(driver.getTitle(),TestUtil.tree_treesTypesPgTitle );
	}

	
	@Test(priority=8)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description -When The user clicks \"Implementation in Python\" button, The user should be directed to \"Implementation in Python\" Page")
	public void treesImplmntnPageLoadTest()
	{
		treePg.clicktreesImplmntn();
		Assert.assertEquals(driver.getTitle(),TestUtil.tree_treesImplmntnPgTitle);
	}
	
	
	@Test(priority=9)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description -When The user clicks \"Binary Tree Traversals\" button, The user should be directed to \"Binary Tree Traversals\" Page")
	public void binaryTraversalsPageLoadTest()
	{
		treePg.clickbinaryTraversalsPage();
		Assert.assertEquals(driver.getTitle(),TestUtil.tree_binaryTraversalsPgTitle);
	}

	
	@Test(priority=10)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description -When The user clicks \"Implementation of Binary Trees\" button, The user should be directed to \"Implementation of Binary Trees\" Page")
	public void binaryImplmntnPageLoadTest()
	{
		treePg.clickbinaryImplmntnPage();
		Assert.assertEquals(driver.getTitle(),TestUtil.tree_binaryImplmntnPgTitle);
	}
	
	@Test(priority=11)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description -When The user clicks \"Applications of Binary trees\" button, The user should be directed to \"Applications of Binary trees\" Page")
	public void binaryAppsPageLoadTest()
	{
		treePg.clickbinaryApps();
		Assert.assertEquals(driver.getTitle(),TestUtil.tree_binaryAppsPgTitle);
	}
	
	@Test(priority=12)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description -When The user clicks \"Binary Search Trees\" button, The user should be directed to \"Binary Search Trees\" Page")
	public void binarySrchPageLoadTest()
	{
		treePg.clickbinarySrch();
		Assert.assertEquals(driver.getTitle(),TestUtil.tree_binarySrchPgTitle);
	}
	
	@Test(priority=13)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description -When The user clicks \"Implementation Of BST\" button, The user should be directed to \"Implementation Of BST\" Page")
	public void bstImplmntnPageLoadTest()
	{
		treePg.clickbstImplmntn();
		Assert.assertEquals(driver.getTitle(),TestUtil.tree_bstImplmntnPgTitle);
	}
	
	@Test(priority=14)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description -When The user clicks \"Try here\" button, The user should be redirected to a page having an tryEditor with a Run button to test")
	public void bst_clickTryTest()
	{
		treePg.clickbstImplmntn();
		treePg.clickTryHere();
		treePg.query();
		treePg.clickRun();
		Assert.assertEquals(treePg.getOutput(), TestUtil.getTryHereOutput());
	}
	
	@Test(priority=15)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description -When The user clicks \"Practice Questions\" button, The user should be directed to \"Practice Questions\" Page")
	public void PractisePageLoadTest()
	{
		treePg.clickbstImplmntn();
		treePg.clickPractice();
		Assert.assertEquals(driver.getTitle(),TestUtil.PractisePgTitle);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
