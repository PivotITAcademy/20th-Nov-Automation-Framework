package com.automationPractise.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationPractise.BasePackage.TestBase;
import com.automationPractise.Pages.ContactUsPage;
import com.automationPractise.Pages.HomePage;

public class HomePageTest extends TestBase {

	HomePage homePage;

	@BeforeMethod
	public void setUp() {
		intialsation();
		homePage = new HomePage();
	}

	@Test(groups = { "Sanity" })
	public void verifyTitleOfTheHomePage() {
		Assert.assertEquals(homePage.getPageTitle(), prop.get("HomePageTitle"), "Home Page title doesn't match");
	}

	@Test
	public void verifyStoreInformationText() {
		Assert.assertEquals(homePage.getTextFromStoreInformation(), prop.get("StoreInfromationText"),
				"Text doesn't match");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
