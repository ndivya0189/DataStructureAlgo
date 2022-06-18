package com.DsAlgo.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DsAlgo.base.TestBase;

public class GraphPage extends TestBase{
	
	@FindBy(linkText="Graph")
	public static WebElement graph;
	
	@FindBy(linkText="Graph Representations")
	public static WebElement graphRep;
	
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


	public GraphPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickGraph()
	{
		graph.click();
	}
	
	public void clickGraphRep()
	{
		graphRep.click();
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
