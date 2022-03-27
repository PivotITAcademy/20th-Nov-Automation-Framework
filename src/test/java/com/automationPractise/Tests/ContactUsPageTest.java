package com.automationPractise.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationPractise.BasePackage.TestBase;
import com.automationPractise.Pages.ContactUsPage;
import com.automationPractise.Pages.HomePage;

public class ContactUsPageTest extends TestBase {

	HomePage homePage;
	ContactUsPage contactUsPage;

	@BeforeMethod
	public void setUp() {
		intialsation();
		homePage = new HomePage();
	}

	@Test
	public void verifyUserCansubmitContactUsForm() {
		contactUsPage = homePage.clickContactUsBtn();
		contactUsPage.selectSubjectHeading();
		contactUsPage.sendEmailInput(prop.getProperty("username"));
		contactUsPage.enterOrderRef("12345");
		contactUsPage.enterMessage(prop.getProperty("inputMessage"));
		contactUsPage.clickContactBtn();

		String getTextFromSuccessMessageBanner = contactUsPage.getTextFromSuccessMessage();
		Assert.assertEquals(getTextFromSuccessMessageBanner, prop.getProperty("successMessageOnContactUsPage"),
				"Message doesn't match");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
