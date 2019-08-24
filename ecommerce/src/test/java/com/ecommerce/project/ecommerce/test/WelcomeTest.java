package com.ecommerce.project.ecommerce.test;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecommerce.project.ecommerce.globalvariables.basepage.BaseSuite;
import com.ecommerce.project.ecommerce.pages.WelcomePage;
import com.ecommerce.project.ecommerce.utils.DateAndTimeUtil;

import junit.framework.Assert;

public class WelcomeTest extends BaseSuite{
	private static Logger logger=Logger.getLogger(WelcomeTest.class);
	
	public WelcomeTest() {
		super();
	}
	
	@DataProvider(name="testdata")
	private Object[][] dataArray() {
		return new Object[][] {{"a","b"}};
	}

	@Test(dataProvider="testdata")
	public static void getTitleOfWelcomePage(String un,String pw,Method method) {
		WelcomePage welcomePage=new WelcomePage();
		logger.info(""+method.getName()+" Execution started !!!!");
		System.out.println(un);
		System.out.println(pw);
		String title=welcomePage.getTitle();
		System.out.println(title);
		DateAndTimeUtil.sleep(3000);
		welcomePage.clickonWomenTab();
		DateAndTimeUtil.sleep(3000);
		String emptyCartMessage=welcomePage.clickOnCartElement();
		Assert.assertEquals("Your shopping cart is empty.", emptyCartMessage);
		logger.info(""+method.getName()+" Execution ended !!!!");
	}
}
