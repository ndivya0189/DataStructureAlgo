package com.DsAlgo.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DsAlgo.base.TestBase;

public class TreePage extends TestBase{
	
	@FindBy(xpath="//a[contains(text(),'Overview of Trees')]")
	public static WebElement overview;
	
	@FindBy(xpath="//a[contains(text(),'Terminologies')]")
	public static WebElement terminologies;
	
	@FindBy(xpath="//a[contains(text(),'Types of Trees')]")
	public static WebElement typesTrees;
	
	@FindBy(xpath="//a[contains(text(),'Tree Traversals')]")
	public static WebElement treeTraverse;
	
	@FindBy(xpath="//a[contains(text(),'Traversals-Illustration')]")
	public static WebElement traverseIllustrations;
	
	@FindBy(xpath="//a[contains(text(),'Binary Trees')]")
	public static WebElement binaryTrees;
	
	@FindBy(xpath="//a[contains(text(),'Types of Binary Trees')]")
	public static WebElement treesTypes;
	
	@FindBy(xpath="//a[contains(text(),'Implementation in Python')]")
	public static WebElement treesImplmntn;
	
	@FindBy(xpath="//a[contains(text(),'Binary Tree Traversals')]")
	public static WebElement binaryTraversals;
	
	@FindBy(xpath="//a[contains(text(),'Implementation of Binary Trees')]")
	public static WebElement binaryImplmntn;
	
	@FindBy(xpath="//a[contains(text(),'Applications of Binary trees')]")
	public static WebElement binaryApps;
	
	@FindBy(xpath="//a[contains(text(),'Binary Search Trees')]")
	public static WebElement binarySrch;
	
	@FindBy(xpath="//a[contains(text(),'Implementation Of BST')]")
	public static WebElement bstImplmntn;
	
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

	
	public TreePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickoverview()
	{
		overview.click();
	}
	
	public void clickterminologies()
	{
		terminologies.click();
		
	}
	
	public void clicktypesTrees()
	{
		typesTrees.click();
		
	}

	public void clicktreeTraverse()
	{
		treeTraverse.click();
		
	}

	public void clicktraverseIllustrations()
	{
		traverseIllustrations.click();
	}

	public void clickbinaryTrees()
	{
		binaryTrees.click();
	}

	public void clicktreesTypes()
	{
		treesTypes.click();
	}

	public void clicktreesImplmntn()
	{
		treesImplmntn.click();
	}

	public void clickbinaryTraversalsPage()
	{
		binaryTraversals.click();
	}

	public void clickbinaryImplmntnPage()
	{
		binaryImplmntn.click();
	}

	public void clickbinaryApps()
	{
		binaryApps.click();
	}

	public void clickbinarySrch()
	{
		binarySrch.click();
	}

	public void clickbstImplmntn()
	{
		bstImplmntn.click();
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