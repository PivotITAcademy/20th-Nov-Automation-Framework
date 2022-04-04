package com.automationPractise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractise.BasePackage.TestBase;
import com.automationPractise.Utils.Utils;

public class LoginPage extends TestBase {

	public LoginPage() {
		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(5);
	}

	@FindBy(id = "email")
	WebElement emailInput;

	@FindBy(id = "passwd")
	WebElement passwordInput;

	@FindBy(id = "SubmitLogin")
	WebElement signInBtn;

	@FindBy(css = "div.alert.alert-danger")
	WebElement authenticationErrorMessage;

	public void enterEmail(String email) {
		Utils.sendData(emailInput, email);
	}

	public void enterPassword(String password) {
		Utils.sendData(passwordInput, password);
	}

	public MyAccountPage clickSignInBtn() {
		Utils.clickOnElement(signInBtn);
		return new MyAccountPage();
	}

	public LoginPage configureSignIn() {
		Utils.sendData(emailInput, Utils.generateRandomEmail());
		Utils.sendData(passwordInput, Utils.generateRandomEmail());
		Utils.clickOnElement(signInBtn);
		return new LoginPage();
	}

	public String getAuthenticationErrorMessage() {
		return Utils.getTextFromWebelement(authenticationErrorMessage);
	}

}
