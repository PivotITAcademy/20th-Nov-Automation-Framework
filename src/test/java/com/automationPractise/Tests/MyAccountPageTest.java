package com.automationPractise.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationPractise.BasePackage.TestBase;
import com.automationPractise.Pages.HomePage;
import com.automationPractise.Pages.LoginPage;
import com.automationPractise.Pages.MyAccountPage;

public class MyAccountPageTest extends TestBase {

	HomePage homepage;
	LoginPage loginpage;
	MyAccountPage myAccountPage;

	@BeforeMethod
	public void setUp() {
		intialsation();
		homepage = new HomePage();

	}

	@Test
	public void verifyUserCanLogin() {
		loginpage = homepage.clickSignInBtn();

		loginpage.enterEmail(prop.getProperty("username"));
		loginpage.enterPassword(prop.getProperty("password"));
		myAccountPage = loginpage.clickSignInBtn();

		String messageActual = myAccountPage.getTextFromMessage();
		Assert.assertEquals(messageActual, prop.getProperty("successMessageOnMyAccountPage"),
				"Message doesn't match!!!");

	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
