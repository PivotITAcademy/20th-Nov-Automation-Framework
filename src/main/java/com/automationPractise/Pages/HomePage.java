package com.automationPractise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractise.BasePackage.TestBase;
import com.automationPractise.Utils.Utils;

public class HomePage extends TestBase {

	public HomePage() {

		// Page Factory is used to intialize the webelements of the class

		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(10);
	}
	
	@FindBy(id = "contact-link")
	WebElement contactUsBtn;

	@FindBy(css = "div.header_user_info")
	WebElement signInBtn;
	
	@FindBy(css="#block_contact_infos h4")
	WebElement storeInformation;

	public ContactUsPage clickContactUsBtn() {
		Utils.clickOnElement(contactUsBtn);
		return new ContactUsPage();
	}

	public LoginPage clickSignInBtn() {
		Utils.clickOnElement(signInBtn);
		return new LoginPage();

	}
	
	public String getPageTitle() {
		return wd.getTitle();
	}
	
	public String getTextFromStoreInformation() {
		Utils.moveToElement(storeInformation);
		//Utils.scrollIntoViewUsingJavascript(storeInformation);
		Utils.sleep(10000);
		return storeInformation.getText();
	}

}
