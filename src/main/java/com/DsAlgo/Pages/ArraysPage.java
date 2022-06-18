package com.DsAlgo.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DsAlgo.base.TestBase;

public class ArraysPage extends TestBase{

	@FindBy(xpath="//a[contains(text(),'Arrays in Python')]")
	public static WebElement arraysInPython;
	
	@FindBy(xpath="//a[contains(text(),'Arrays Using List')]")
	public static WebElement arraysList;
	
	@FindBy(xpath="//a[contains(text(),'Basic Operations in Lists')]")
	public static WebElement basicOperations;
	
	@FindBy(xpath="//a[contains(text(),'Applications of Array')]")
	public static WebElement applications;
	
	@FindBy(xpath="//a[contains(text(),'Practice Questions')]")
	public static WebElement practice;
	
	@FindBy(xpath="//a[contains(text(),'Try here')]")
	public static WebElement tryHere;
	
	@FindBy(css="#answer_form > div > div > div:nth-child(1) > textarea")
	public static WebElement tryHereArea;
	
	@FindBy(xpath="//button[contains(text(),'Run')]")
	public static WebElement runBtn;
	
	@FindBy(xpath = "//pre[@id='output']")
	public static WebElement output;
	
	@FindBy(xpath="//strong[contains(text(),'QUESTION')]")
	public static WebElement question;
	
	@FindBy(css="#answer_form>div>div>div:nth-child(1)>textarea")
	public static WebElement txtArea;
	
	@FindBy(xpath="//button[contains(text(),'Run')]")
	public static WebElement run;
	
	@FindBy(xpath="//input[contains(@value,'Submit')]")
	public static WebElement submitBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Search the array')]")
	public static WebElement srchArray;

	@FindBy(xpath = "//a[contains(text(),'Max Consecutive Ones')]")
	public static WebElement MaxConsecutiveOnes;

	@FindBy(xpath = "//a[contains(text(),'Find Numbers with Even Number of Digits')]")
	public static WebElement findEven;
	
	@FindBy(xpath = "//a[contains(text(),'a Sorted Array')]")
	public static WebElement sortedArray;

	
	public ArraysPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickArraysInPython()
	{
		arraysInPython.click();
	}
	
	public void clickArraysList()
	{
		arraysList.click();
	}
	
	public void clickBasicoperations()
	{
		basicOperations.click();
	}
	
	public void clickApplications()
	{
		applications.click();
	}
	
	public void clickPractice()
	{
		practice.click();
	}
	
	public void clickTryHere()
	{
		tryHere.click();
	}
	
	public void clickSrchArray()
	{
		srchArray.click();
	}
	
	public void clickMax()
	{
		MaxConsecutiveOnes.click();
	}
	
	public void clickEven()
	{
		findEven.click();
	}
	
	public void clickSortedArray()
	{
		sortedArray.click();
	}

	
	public boolean isQnDisplayed()
	{
		return question.isDisplayed();
	}
	
	public boolean isRunDisplayed()
	{
		return run.isDisplayed();
	}
	
	public boolean isSubmitDisplayed()
	{
		return submitBtn.isDisplayed();
	}
	
	public boolean istxtAreaDisplayed()
	{
		return txtArea.isEnabled();
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
