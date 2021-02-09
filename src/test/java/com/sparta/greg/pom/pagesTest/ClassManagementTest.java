package com.sparta.greg.pom.pagesTest;

import com.sparta.greg.pom.pages.ClassManagement;
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

		webDriver.get("http://localhost:8080/");

		//TODO : REPLACE WITH LOGIN PAGE CODE AND REDIRECTION TO CLASS MANAGEMENT
		webDriver.findElement(By.id("inputEmail")).sendKeys(username);
		webDriver.findElement(By.id("inputPassword")).sendKeys(password);
		webDriver.findElement(By.cssSelector(".btn")).click();
		webDriver.get("http://localhost:8080/trainer/manageClass");

		classManagement = new ClassManagement(webDriver);

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
	@DisplayName("Does dropdown work")
	void doesDropdownWork() {
		classManagement.selectTrainee("Bill Bird");
		classManagement.selectClass("Engineering 65");

		Assertions.assertEquals("Bill Bird", classManagement.getSelectTrainee().getFirstSelectedOption().getText());
		Assertions.assertEquals("Engineering 65", classManagement.getSelectClass().getFirstSelectedOption().getText());

		classManagement.clickAssignTrainee();

	}
}
