package com.automationPractise.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automationPractise.BasePackage.TestBase;
import com.automationPractise.Pages.HomePage;
import com.automationPractise.Pages.LoginPage;
import com.automationPractise.Pages.MyAccountPage;
import com.automationPractise.Utils.ExcelUtils;

public class MyAccountPageTest extends TestBase {

	HomePage homepage;
	LoginPage loginpage;
	MyAccountPage myAccountPage;
	SoftAssert sf;

	@BeforeMethod
	public void setUp() {
		intialsation();
		sf = new SoftAssert();
		homepage = new HomePage();

	}

	@Test(enabled = false,dataProvider ="signUpDataProvider" )
	public void verifyUserCanLoginSuccessFully(String email,String password) {
		loginpage = homepage.clickSignInBtn();

		loginpage.enterEmail(email);
		loginpage.enterPassword(password);
		myAccountPage = loginpage.clickSignInBtn();

		/*sf.assertEquals(myAccountPage.getPageTitle(), prop.get("MyAccountPageTitle"),
				"My Account Page title doesn't match");

		sf.assertEquals(true, false);*/
		String messageActual = myAccountPage.getTextFromMessage();
		sf.assertEquals(messageActual, prop.getProperty("successMessageOnMyAccountPage"), "Message doesn't match!!!");

		sf.assertAll();

	}

	@Test
	public void verifyTitleOfTheMyAccountPage() {
		loginpage = homepage.clickSignInBtn();

		loginpage.enterEmail(prop.getProperty("username"));
		loginpage.enterPassword(prop.getProperty("password"));
		myAccountPage = loginpage.clickSignInBtn();
		Assert.assertEquals(myAccountPage.getPageTitle(), prop.get("MyAccountPageTitle"),
				"My Account Page title doesn't match");
	}

	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}

	@DataProvider(name="signUpDataProvider")
	public String[][] readAndFeedLoginDataFromExcel() throws IOException {
		String filePath = "F:\\UserIds.xlsx";
		int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
		int col = ExcelUtils.getCellCount(filePath, "Sheet1", rows);
		String[][] loginData = new String[rows][col];
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < col; j++) {
				loginData[i - 1][j] = ExcelUtils.getCellData(filePath, "Sheet1", i, j);
			}
		}
		return loginData;

	}

}
