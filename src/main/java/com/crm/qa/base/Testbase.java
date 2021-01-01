package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.qa.util.Testutil;

public class Testbase {
	
	public static WebDriver driver;
	public static Properties prop;

	public Testbase() {
		try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\FreecrmTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(ip);
		
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() throws InterruptedException 
	{
		String browsername = prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{			
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		}
		else if(browsername.equals("FF")) 
		{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nishanth.E-SOFTSYS\\eclipse-workspace\\Freecrmtesting\\driver\\geckodriver.exe");
		driver = new ChromeDriver();
		} 
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		Thread.sleep(3000);
		driver.get(prop.getProperty("url"));

	}

}
