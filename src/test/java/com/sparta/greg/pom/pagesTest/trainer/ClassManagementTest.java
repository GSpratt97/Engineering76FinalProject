package com.sparta.greg.pom.pagesTest.trainer;

import com.sparta.greg.pom.pages.components.PropertyLoader;
import com.sparta.greg.pom.pages.trainer.ClassManagement;
import com.sparta.greg.pom.pages.trainer.HomeTrainer;
import com.sparta.greg.pom.pages.components.Login;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ClassManagementTest {
	static WebDriver webDriver;
	ClassManagement classManagement;
	private final boolean headless = false;
	Properties properties = new Properties();
	private String username;
	private String password;


	@BeforeEach
	void setup() {
		webDriver = WebDriverFactory.getWebDriver(WebDriverType.CHROME);
		webDriver.get("http://localhost:8080/login");
		Login login = new Login(webDriver);
		PropertyLoader.loadProperties();
		username = PropertyLoader.properties.getProperty("trainerUsername");
		password = PropertyLoader.properties.getProperty("trainerPassword");
		HomeTrainer homeTrainer = login.logInAsTrainer(username, password);
		homeTrainer.getSideBarTrainer().clickTrainerOptions();
		classManagement = homeTrainer.getSideBarTrainer().goToClassManagement();

//		PropertyLoader.loadProperties();
//		username = PropertyLoader.properties.getProperty("trainerUsername");
//		password = PropertyLoader.properties.getProperty("trainerPassword");
//
//		if (headless) {
//			ChromeOptions chromeOptions = new ChromeOptions();
//			chromeOptions.addArguments("headless");
//			webDriver = new ChromeDriver(chromeOptions);
//		} else {
//			webDriver = new ChromeDriver();
//		}
//
//		webDriver.get("http://localhost:8080/login");
//
//		Login login = new Login(webDriver);
//		HomeTrainer homeTrainer = login.logInAsTrainer(username, password);
//
//		homeTrainer.getSideBarTrainer().clickTrainerOptions();
//		classManagement = homeTrainer.getSideBarTrainer().goToClassManagement();

	}

	@AfterEach
	void close() {
		webDriver.close();
	}

	@AfterAll
	static void quit() {
		webDriver.quit();
	}

	@Test
	@DisplayName("Assigning a Trainee")
	void assigningTrainee() {
		classManagement.selectTrainee("Bill Bird");
		classManagement.selectClass("Engineering 72");

		Assertions.assertEquals("Bill Bird", classManagement.getSelectTrainee().getFirstSelectedOption().getText());
		Assertions.assertEquals("Engineering 72", classManagement.getSelectClass().getFirstSelectedOption().getText());

		classManagement.clickAssignTrainee();
		Assertions.assertNotNull(classManagement.getSuccessMessage());
	}


	@Test
	@DisplayName("Testing date entries")
	void testingDateEntries() {
		classManagement.enterStartDate("01", "03", "2021", "00", "00");
		classManagement.enterEndDate("20", "12", "2022", "16", "30");
	}

	@Test
	@DisplayName("Testing creating class")
	void testingCreatingClass() {
		webDriver.navigate().refresh();
		classManagement.enterClassName("Testing 101");
		classManagement.selectCourse("Java SDET");
		classManagement.enterStartDate("01", "03", "2021", "00", "00");
		classManagement.enterEndDate("20", "04", "2021", "00", "30");

		classManagement.clickCreateClass();
		//TESTING 101 ALREADY EXISTS => error message
		Assertions.assertNotNull(classManagement.getErrorMessage());

	}


}
