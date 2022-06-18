package com.DsAlgo.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DsAlgo.base.TestBase;

public class LinkedListPage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Introduction')]")
	public static WebElement intro;
	
	@FindBy(xpath="//a[contains(text(),'Creating Linked LIst')]")
	public static WebElement create;
	
	@FindBy(xpath="//a[contains(text(),'Types of Linked List')]")
	public static WebElement types;
	
	@FindBy(xpath="//a[contains(text(),'Implement Linked List in Python')]")
	public static WebElement implement;
	
	@FindBy(xpath="//a[contains(text(),'Traversal')]")
	public static WebElement traverse;
	
	@FindBy(xpath="//a[contains(text(),'Insertion')]")
	public static WebElement insert;
	
	@FindBy(xpath="//a[contains(text(),'Deletion')]")
	public static WebElement delete;
	
	@FindBy(xpath="//a[contains(text(),'Practice Questions')]")
	public static WebElement practice;
	
	@FindBy(xpath="//a[contains(text(),'Try here>>>')]")
	public static WebElement tryHere;
	
	@FindBy(css="#answer_form > div > div > div:nth-child(1) > textarea")
	public static WebElement textArea;
	
	@FindBy(xpath="//button[contains(text(),'Run')]")
	public static WebElement runBtn;
	
	@FindBy(xpath = "//pre[@id='output']")
	public static WebElement output;
	
	
	public LinkedListPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickIntro()
	{
		intro.click();
	}
	
	public void clickCreate()
	{
		create.click();
	}
	
	public void clickTypes()
	{
		types.click();
	}
	
	public void clickImplement()
	{
		implement.click();
	}
	
	public void clickTraverse()
	{
		traverse.click();
	}
	
	public void clickInsert()
	{
		insert.click();
	}
	
	public void clickDelete()
	{
		delete.click();
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
