package com.automationPractise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractise.BasePackage.TestBase;

public class MyAccountPage extends TestBase {

	public MyAccountPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#center_column p")
	WebElement welcomeMessageText;

	public String getTextFromMessage() {
		return welcomeMessageText.getText();
	}

}
