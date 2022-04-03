package com.automationPractise.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationPractise.BasePackage.TestBase;
import com.automationPractise.Pages.HomePage;
import com.automationPractise.Pages.LoginPage;

public class LoginPageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		intialsation();
		homePage = new HomePage();
	}

	@Test
	public void verifyErrorMessageForInvalidLogin() {
		loginPage = homePage.clickSignInBtn();
		loginPage.configureSignIn();
		Assert.assertEquals(loginPage.getAuthenticationErrorMessage().replaceAll("\n", " "),
				prop.getProperty("authenticationErrorMessage"), "Authentication Error Message doesn't match");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

}
