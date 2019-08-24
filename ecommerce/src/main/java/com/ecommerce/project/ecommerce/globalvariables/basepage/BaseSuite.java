package com.ecommerce.project.ecommerce.globalvariables.basepage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseSuite {

	public static Properties properties;
	public static WebDriver driver;
	private static Logger logger=Logger.getLogger(BaseSuite.class);

	{
		PropertyConfigurator.configure("logs\\log4j.properties");
		File file=new File("C:\\seleniumLogs.log");
		if(file.exists()){
			file.delete();
		}
	}
	public  BaseSuite() {
		try {
			logger.info("Loading test data !!!");
			FileInputStream fileInputStream=new FileInputStream(new File("config.properties"));
			properties=new Properties();
			properties.load(fileInputStream);
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	@BeforeSuite
	public static void initialization() {
		if(properties.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);	
			driver.get(properties.getProperty("url"));
		}else if (properties.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver", "drivers\\gecko.exe");
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);	
			driver.get(properties.getProperty("url"));
		}

	}

	@AfterSuite
	public void tearDown() {
		driver.close();
	}

}
