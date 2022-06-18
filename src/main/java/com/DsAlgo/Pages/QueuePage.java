package com.DsAlgo.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DsAlgo.base.TestBase;

public class QueuePage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Implementation of Queue in Python')]")
	public WebElement queueImplmnt; 
	
	@FindBy(xpath="//a[contains(text(),'Implementation using collections.deque')]")
	public WebElement dequeueImplmnt;
	
	@FindBy(xpath="//a[contains(text(),'Implementation using array')]")
	public WebElement arraysImplmnt;
	
	@FindBy(xpath="//a[contains(text(),'Queue Operations')]")
	public WebElement queueOps;
	
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

	
	public QueuePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void clickQueueImplmnt()
	{
		queueImplmnt.click();
		
	}
	
	public void clickDequeueImplmnt()
	{
		dequeueImplmnt.click();
		
	}
	
	public void clickArraysImplmnt()
	{
		arraysImplmnt.click();
		
	}
	
	public void clickQueueOps()
	{
		queueOps.click();
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
		textArea.sendKeys("print \"hello\"");
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
