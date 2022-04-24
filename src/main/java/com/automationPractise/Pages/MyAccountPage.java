package com.automationPractise.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractise.BasePackage.TestBase;
import com.automationPractise.Utils.Utils;

public class MyAccountPage extends TestBase {

	public MyAccountPage() {
		PageFactory.initElements(wd, this);
		waitForDocumentCompleteState(15);
		//I have added the below print statement
		System.out.println("To obtain the welcome message");
	}

	@FindBy(css = "#center_column p")
	WebElement welcomeMessageText;

	public String getTextFromMessage() {
		return Utils.getTextFromWebelement(welcomeMessageText);
		
	
	}
	
	

	public String getPageTitle() {
		return wd.getTitle();
		
	}

}
