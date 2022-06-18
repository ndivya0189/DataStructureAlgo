package com.DsAlgo.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DsAlgo.base.TestBase;

public class dataStructuresPage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Time Complexity')]")
	public static WebElement timeComplexity;
	
	@FindBy(xpath="//a[contains(text(),'Practice Questions')]")
	public static WebElement practiceQns;

	@FindBy(xpath="//a[contains(text(),'Try here')]")
	public static WebElement tryHere;
	
	@FindBy(css="#answer_form > div > div > div:nth-child(1) > textarea")
	public static WebElement tryHereArea;
	
	@FindBy(xpath="//button[contains(text(),'Run')]")
	public static WebElement runBtn;
	
	@FindBy(xpath = "//pre[@id='output']")
	public static WebElement output;

	
	public dataStructuresPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickTimeComplexity()
	{
		timeComplexity.click();
	}
	
	public void clickPractice()
	{
		practiceQns.click();
	}
	
	public void clickTry()
	{
		tryHere.click();
	}
	
	public void query()
	{
		tryHereArea.sendKeys("print \"hello\"");
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