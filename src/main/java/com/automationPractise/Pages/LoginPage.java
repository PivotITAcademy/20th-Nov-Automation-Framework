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
		emailInput.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public MyAccountPage clickSignInBtn() {
		signInBtn.click();
		return new MyAccountPage();
	}

	public LoginPage configureSignIn() {
		emailInput.sendKeys(Utils.generateRandomEmail());
		passwordInput.sendKeys(Utils.generateRandomPassword());
		signInBtn.click();
		return new LoginPage();
	}

	public String getAuthenticationErrorMessage() {
		return authenticationErrorMessage.getText();
	}

}
