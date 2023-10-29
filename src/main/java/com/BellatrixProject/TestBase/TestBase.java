package com.BellatrixProject.TestBase;

import java.io.FileNotFoundException;
import com.BellatrixProject.Configuration.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import com.BellatrixProject.Utilities.*;

import com.BellatrixProject.Configuration.Configuration;

public class TestBase {
	public static RemoteWebDriver driver;

	public static RemoteWebDriver getDriver() {
		return driver;
	}

	@BeforeMethod // browser will open before every testcase
	public RemoteWebDriver SetUp(@Optional String browserName) throws FileNotFoundException {
		Configuration config = new Configuration();

		if (browserName == null) {
			browserName = "Chrome";
		}

		if (browserName == "Chrome") {
			driver = new ChromeDriver();
		} else if (browserName == "Firefox") {
			driver = new FirefoxDriver();
		}
		
		String url = config.getAppUrl("app.url");
		driver.get(url);
		System.out.println(url+ "this is url of bellatrix");
		return driver;
	}

	@AfterMethod // browser will close after every testcase
	public void closeBrowser() {
		driver.quit();
	}

}
