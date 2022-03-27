package com.automationPractise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationPractise.BasePackage.TestBase;

public class ContactUsPage extends TestBase {

	ContactUsPage() {
		PageFactory.initElements(wd, this);
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
	
	@FindBy(id="submitMessage")
	WebElement clickSubmitBtn;

	public void sendEmailInput(String email) {
		emailInput.sendKeys(email);
	}

	public void enterOrderRef(String orderRefe) {
		orderRef.sendKeys(orderRefe);
	}

	public void enterMessage(String message) {
		messageInput.sendKeys(message);
	}

	public void selectSubjectHeading() {
		Select select = new Select(subjectHeading);
		select.selectByIndex(1);
	}

	public String getTextFromSuccessMessage() {
		return successMessage.getText();
	}
	
	public ContactUsPage clickContactBtn() {
		clickSubmitBtn.click();
		return new ContactUsPage();
	}

}
