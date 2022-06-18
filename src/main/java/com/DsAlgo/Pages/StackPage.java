package com.DsAlgo.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DsAlgo.base.TestBase;

public class StackPage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Operations in Stack')]")
	public static WebElement opsInStack;
	
	@FindBy(xpath="//a[contains(text(),'Implementation')]")
	public static WebElement Implementation;

	@FindBy(xpath="//a[contains(text(),'Applications')]")
	public static WebElement apps;
	
	@FindBy(xpath="//a[contains(text(),'Practice Questions')]")
	public static WebElement practice;
	
	@FindBy(xpath="//a[contains(text(),'Try here')]")
	public static WebElement tryHere;
	
	@FindBy(css="#answer_form > div > div > div:nth-child(1) > textarea")
	public static WebElement textArea;
	
	@FindBy(xpath="//button[contains(text(),'Run')]")
	public static WebElement runBtn;
	
	@FindBy(xpath = "//pre[@id='output']")
	public static WebElement output;

	
	
	public StackPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickopsInStack()
	{
		opsInStack.click();
		
	}

	public void clickImplementation()
	{
		Implementation.click();
	}
	
	public void clickApps()
	{
		apps.click();
	}
	
	public void clickPractice()
	{
		practice.click();
	}
	
	public void clickTryHere()
	{
		tryHere.click();
	}
	
	public void query()
	{
		textArea.sendKeys("print \"10\"");
	}
	
	public void clickRun()
	{
		runBtn.click();
	}
	
	public String getOutput()
	{
		return output.getText();
	}

}
