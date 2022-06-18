package com.DsAlgo.Pages;



	
	import java.time.Duration;

	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import com.DsAlgo.base.TestBase;

	import io.qameta.allure.Step;

	public class GetStartedPage extends TestBase{
		
		@FindBy(xpath="//button[contains(text(),'Get Started')]") 
		public static WebElement getStarted;

		public GetStartedPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		@Step("Step: Get the page title")
		public String pageDisplay()
		{
			return driver.getTitle();
			
		}
		
		@Step("Step: Click the Get Started button")
		public HomePage clickGetStarted() 
		{
			wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(getStarted));
			getStarted.click();
			return homePg;		
		}
		
		
	}

