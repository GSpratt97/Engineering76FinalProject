package com.sparta.greg.pom.pagesTest;

import com.sparta.greg.pom.pages.ClassManagement;
import com.sparta.greg.pom.pages.HomeTrainer;
import com.sparta.greg.pom.pages.Login;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
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
	void setup(){
		try {
			properties.load(new FileReader("src/test/resources/login.properties"));
			username = properties.getProperty("trainerUsername");
			password = properties.getProperty("trainerPassword");
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(headless) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("headless");
			webDriver = new ChromeDriver(chromeOptions);
		}else {
			webDriver = new ChromeDriver();
		}
		
		Login login = new Login(webDriver);
		HomeTrainer homeTrainer= login.logInAsTrainer(username, password);
		classManagement = homeTrainer.goToClassManagement();


	}

//	@AfterEach
//	void close(){
//		webDriver.close();
//	}
//
//	@AfterAll
//	static void quit(){
//		webDriver.quit();
//	}

	@Test
	@DisplayName("Assigning a Trainee")
	void assigningTrainee() {
		classManagement.selectTrainee("Bill Bird");
		classManagement.selectClass("Engineering 65");

		Assertions.assertEquals("Bill Bird", classManagement.getSelectTrainee().getFirstSelectedOption().getText());
		Assertions.assertEquals("Engineering 65", classManagement.getSelectClass().getFirstSelectedOption().getText());

		classManagement.clickAssignTrainee();
		System.out.println(classManagement.getSuccessMessage().getText());

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
		classManagement.enterClassName("Testing 101");
		classManagement.selectCourse("Java SDET");
		classManagement.enterStartDate("01", "03", "2021", "00", "00");
		classManagement.enterEndDate("20", "04", "2021", "00", "30");

		classManagement.clickCreateClass();
		System.out.println(classManagement.getErrorMessage());

	}

}
