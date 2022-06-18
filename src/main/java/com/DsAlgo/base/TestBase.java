package com.DsAlgo.base;


import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.DsAlgo.Pages.ArraysPage;
import com.DsAlgo.Pages.GetStartedPage;
import com.DsAlgo.Pages.GraphPage;
import com.DsAlgo.Pages.HomePage;
import com.DsAlgo.Pages.LinkedListPage;
import com.DsAlgo.Pages.QueuePage;
import com.DsAlgo.Pages.RegisterPage;
import com.DsAlgo.Pages.StackPage;
import com.DsAlgo.Pages.TreePage;
import com.DsAlgo.Pages.dataStructuresPage;
import com.DsAlgo.Pages.SignInPage;
import com.DsAlgo.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static ThreadLocal<WebDriver> tdriver;
	protected static WebDriverWait wait;
	protected static Properties prop;
	
	public static GetStartedPage GetStartedPg;
	public static HomePage homePg;
	public static RegisterPage registerPg;
	public static SignInPage signInPg;
	public static dataStructuresPage dsPg;
	public static ArraysPage arraysPg;
	public static LinkedListPage LinkedListPg;
	public static StackPage StackPg;
	public static QueuePage queuePg;
	public static TreePage treePg;
	public static GraphPage graphPg;
	
	
	public TestBase()
	{
		prop = new Properties();
		tdriver = new ThreadLocal<WebDriver>();
		
		try {
			FileInputStream FIS = new FileInputStream(
					"./src/main/java/com/dsAlgo/config/config.properties");
			prop.load(FIS);
			} 
			catch (FileNotFoundException e) 
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	
	public static WebDriver initialize(String browserName)
	{
		//System.out.println(browserName);
		String url = prop.getProperty("url");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.getPageLoadTimeOut()));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.getimplicitWait()));
		driver.get(url);
		
		return getDriver();
		
	}
	
	public static synchronized WebDriver getDriver()
	{
	
		tdriver.set(driver);
		return tdriver.get();
	}

}


		
				
		
		
		
		
		
	































