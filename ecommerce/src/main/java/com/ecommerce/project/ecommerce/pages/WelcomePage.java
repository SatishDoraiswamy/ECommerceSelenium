package com.ecommerce.project.ecommerce.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.project.ecommerce.globalvariables.basepage.BaseSuite;
import com.ecommerce.project.ecommerce.utils.DateAndTimeUtil;

public class WelcomePage extends BaseSuite {
	
private static Logger logger=Logger.getLogger(WelcomePage.class);

	public WelcomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@title='Women']") private   WebElement womenTab;
	@FindBy(xpath="//a/b[text()='Cart']")private  WebElement cartButton;
	@FindBy(xpath="//p[text()='Your shopping cart is empty.']")private  WebElement emptyCardElement;
	
	
	
	public String getTitle() {
		logger.info("Capturing the Title of the Element");
		return driver.getTitle();
	}
	
	public  void clickonWomenTab() {
		womenTab.click();
	}
	
	public  String clickOnCartElement() {
		cartButton.click();
		DateAndTimeUtil.sleep(3000);
		return emptyCardElement.getText();
	}
	
}
