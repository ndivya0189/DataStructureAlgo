package com.DsAlgo.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.DsAlgo.Pages.GetStartedPage;
import com.DsAlgo.base.TestBase;
import com.DsAlgo.util.ExcelUtil;
import com.DsAlgo.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class GetStartedPageTest extends TestBase{
			
	public GetStartedPageTest()
	{
		super();
	}
	
	@Parameters("browserName")
	@BeforeMethod
	//@Parameters("browserName")
    public void setUp(String browserName)
	{
		initialize(browserName);
		GetStartedPg = new GetStartedPage();
	}
	
	private void initialization() {
		// TODO Auto-generated method stub
		
	}

	@Test(priority=1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description: The user should land in DS Algo portal page")
	public void portalPageLoadTest() 
	{		
		String getStartedtitle = GetStartedPg.pageDisplay();
		Assert.assertEquals(getStartedtitle, TestUtil.getStartedPageTitle);
	}
	
	
	//@AfterMethod
	public void teardown() throws InterruptedException
	{
		driver.quit();
	}
}
	

