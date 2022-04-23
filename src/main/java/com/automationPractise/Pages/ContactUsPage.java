package com.automationPractise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationPractise.BasePackage.TestBase;
import com.automationPractise.Utils.Utils;

public class ContactUsPage extends TestBase {

	ContactUsPage() {
		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(5);
	}

	@FindBy(id = "email")
	WebElement emailInput;

	@FindBy(name = "id_order")
	WebElement orderRef;

	@FindBy(id = "id_contact")
	WebElement subjectHeading;

	@FindBy(id = "message")
	WebElement messageInput;

	@FindBy(css = ".alert.alert-success")
	WebElement successMessage;

	@FindBy(id = "submitMessage")
	WebElement clickSubmitBtn;

	public void sendEmailInput(String email) {
		Utils.sendData(emailInput, email);
	}

	public void enterOrderRef(String orderRefe) {
		Utils.sendData(orderRef, orderRefe);
	}

	public void enterMessage(String message) {
		Utils.sendData(messageInput, message);
	}

	public void selectSubjectHeading() {
		Utils.selectFromDropDownUsingIndex(subjectHeading, 1);

	}

	public String getTextFromSuccessMessage() {
		return Utils.getTextFromWebelement(successMessage);
	}

	public ContactUsPage clickContactBtn() {
		Utils.clickOnElement(clickSubmitBtn);
		return new ContactUsPage();
	}

	public String getPageTitle() {
		return wd.getTitle();
	}

}
