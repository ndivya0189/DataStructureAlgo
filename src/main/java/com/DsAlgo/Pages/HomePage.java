package com.DsAlgo.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DsAlgo.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Factory
	@FindBy(xpath="//a[contains(text(),'Data Structures')]")
	 public static WebElement dataStructures;
	
	@FindBy(xpath ="//a[@class=\"dropdown-item\"]")
	public static List<WebElement> dropDown;
	
	@FindBy(xpath = "//a[contains(text(),'Data Structures')]")
	public static WebElement dropDownBtn;
	
	@FindBy(xpath="//a[contains(text(),'Arrays')]")
	public static WebElement arrayDropDown;
	
	@FindBy(xpath ="//div[@class=\"col\"]") 
	public static List<WebElement> panels;
	
	@FindBy(xpath = "//a[@class='navbar-brand']")
	public static WebElement numpynja;
	
	
	@FindBy(xpath = "//a[contains(text(),\"Register\"]")
	public static WebElement register;
	
	@FindBy(xpath = "//a[contains(text(),\"Sign in\"]")
	public static WebElement signin;
	
	
	@FindBy (xpath = "//a[contains(text(),'Sign out')]")
	public static WebElement signout;
	
	@FindBy(xpath = "a[@href=\"data-structures-introduction\"]")
	public static WebElement  dsintro_getStartedBtn;
	
	@FindBy(xpath = "a[@href=\"array\"]")
	public static WebElement  array_getStartedBtn;
	
	@FindBy(xpath = "a[@href=\"linked-list\"]")
	public static WebElement LinkedList_getStartedBtn;
	
	@FindBy(xpath = "a[@href=\"stack\"]")
	public static WebElement stack_getStartedBtn;
	
	@FindBy(xpath = "a[@href=\"queue\"]")
	public static WebElement  queue_getStartedBtn;
	
	@FindBy(xpath = "a[@href=\"tree\"]")
	public static WebElement  tree_getStartedBtn;
	
	@FindBy(xpath = "a[@href=\"graph\"]")
	public static WebElement  graph_getStartedBtn;
	
	@FindBy (xpath = "//div[contains(text(),\'Logged out successfully')]")
	public static WebElement  logoutmsg;
	
	@FindBy (xpath = "//div[contains(text(),\'You are not logged in')]")
	public static WebElement  errormsg;
	
	@FindBy (xpath = "//div[contains(text(),\'You are logged in')]")
	public static WebElement  loginsuccess;
	
	@FindBy (xpath = "//div[contains(text(),\'Logged out successfully')]")
	public static WebElement  logoutSuccess;

	//Initializing the Page Objects
	public HomePage()
	{
		PageFactory.initElements(driver,this);
		
	}
	
	
	//Actions
	public String HomePageLoad()
	{
		String homeTitle= driver.getTitle();
		return homeTitle;
	}
	
	public int clickDropDown()
	{
		return dropDown.size();
	}
	
	public void selectDropDown(String item)
	{
		dropDownBtn.click();
		arrayDropDown.click();
	}
	
	public int countPanes()
	{
		return panels.size();
		
	}
	
	public void clickRegister()
	{
		register.click();
	}

	public String getSuccessMsg()
	{
		return loginsuccess.getText();
	}
	
	public boolean getloginSuccess()
	{
		return loginsuccess.isDisplayed();
	}
	
	public boolean getLogOutSuccess()
	{
		signout.click();
		return logoutSuccess.isDisplayed();
	}

	public SignInPage clickSignIn()
	{
		signin.click();
		return signInPg;
	}
	
	public ArraysPage clickArray()
	{
		array_getStartedBtn.click();
		return arraysPg;
	}
	
	public LinkedListPage clickLinkedListPage()
	{
		LinkedList_getStartedBtn.click();
		return LinkedListPg;
	}
	
	public StackPage clickStackPage()
	{
		stack_getStartedBtn.click();
		return StackPg;
	}
	
	public QueuePage clickQueuePage()
	{
		queue_getStartedBtn.click();
		return queuePg;
	}
	
	public TreePage clickTreePage()
	{
		tree_getStartedBtn.click();
		return treePg;
	}
	public GraphPage clickGraphPage()
	{
		graph_getStartedBtn.click();
		return graphPg;
	}


	public dataStructuresPage clickDataStructures() {
		// TODO Auto-generated method stub
		return dsPg;
	}


	
	
	
	
	
	
	
	

}

