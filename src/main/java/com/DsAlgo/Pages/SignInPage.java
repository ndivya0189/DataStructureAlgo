package com.DsAlgo.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DsAlgo.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignInPage extends TestBase {
	
	@FindBy(xpath="//input[@id='id_username']")
	public static WebElement userName;
	
	@FindBy(xpath="//input[@id='id_password']")
	public static WebElement password;
	
	@FindBy(xpath="//input[@type=\"submit\" and @value=\"Login\"]")
	public static WebElement loginBtn;
	
	public SignInPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String PageLoad()
	{
		return driver.getTitle();
	}
	
	public void sendUserName(String UserName)
	{
		userName.sendKeys(UserName);
	}
	
	public void sendPassword(String Password)
	{
		password.sendKeys(Password);
	}

	public void clickLogin()
	{
		loginBtn.click();
	}
}






















