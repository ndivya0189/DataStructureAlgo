package com.DsAlgo.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.DsAlgo.base.TestBase;
import com.DsAlgo.util.TestUtil;

public class RegisterPage extends TestBase{
	
	@FindBy(xpath="//input[@id='id_username']")
	public static WebElement userName;
	
	@FindBy(xpath="//input[@id='id_password1']")
	public static WebElement password;
	
	@FindBy(xpath="//input[@id='id_password2']")
	public static WebElement pwdConfirmation;

	@FindBy(xpath="//input[@type=\"submit\"]")
	public static WebElement registerBtn;

	public RegisterPage()
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
	
	public void confirmPwd(String Password)
	{
		pwdConfirmation.sendKeys(Password);
	}
	
	public String clickEmptyRegister()
	{
		registerBtn.click();
		return userName.getAttribute("validationMessage");
	}
	
	public void clickRegister()
	{
		registerBtn.click();
	}
}