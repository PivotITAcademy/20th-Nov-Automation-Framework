package com.automationPractise.BasePackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.automationPractise.Logger.WebdriverEvents;
import com.automationPractise.Utils.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver wd;
	public static Properties prop;
	public FileInputStream file;
	public static Logger logger;
	public EventFiringWebDriver e_driver;
	public WebdriverEvents eventListner;
	public static JavascriptExecutor jse;

	public TestBase() {
		try {
			prop = new Properties();
			file = new FileInputStream(
					"F:\\Carbonite\\FrameworkConcept\\src\\main\\java\\com\\automationPractise\\config\\config.properties");
			prop.load(file);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@BeforeClass
	public void setUpLogger() {
		logger = Logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();

		logger.setLevel(Level.INFO);

	}

	public void intialsation() {
		String browserName = prop.getProperty("browser");

		switch (browserName) {
		case "chrome":

			WebDriverManager.chromedriver().setup();
			wd = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			wd = new FirefoxDriver();
			break;
		case "edge":

			WebDriverManager.edgedriver().setup();
			wd = new EdgeDriver();
			break;

		default:
			System.out.println("You are not passing the correct browser name!!!!!");
			break;
		}

		// Intialising Webdriver Event Listener
		e_driver = new EventFiringWebDriver(wd);
		eventListner = new WebdriverEvents();
		e_driver.register(eventListner);
		wd = e_driver;

		wd.manage().window().maximize();
		// wd.manage().timeouts().implicitlyWait(Utils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		wd.manage().timeouts().pageLoadTimeout(Utils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		// Load the Page
		wd.get(prop.getProperty("URL"));

	}

	public void tearDown() {
		wd.quit();
	}

	public void waitForDocumentCompleteState(int timeOutInSeconds) {
		new WebDriverWait(wd, 15).until((ExpectedCondition<Boolean>) v -> {
			logger.info("Verifying page has loaded......");
			jse = (JavascriptExecutor) wd;
			String documentIsReady = jse.executeScript("return document.readyState").toString();
			while (true) {
				if (documentIsReady.equalsIgnoreCase("complete")) {
					logger.info("Page has loaded completely......");
					return true;
				} else {
					return false;
				}
			}
		});
	}

}
