package com.automationPractise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractise.BasePackage.TestBase;

public class HomePage extends TestBase {

	public HomePage() {

		// Page Factory is used to intialize the webelements of the class

		PageFactory.initElements(wd, this);
	}
	
	@FindBy(id = "contact-link")
	WebElement contactUsBtn;

	@FindBy(css = "div.header_user_info")
	WebElement signInBtn;

	public ContactUsPage clickContactUsBtn() {
		contactUsBtn.click();
		return new ContactUsPage();
	}

	public LoginPage clickSignInBtn() {
		signInBtn.click();
		return new LoginPage();

	}

}
