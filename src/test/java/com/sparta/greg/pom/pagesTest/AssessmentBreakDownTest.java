package com.sparta.greg.pom.pagesTest;

import com.sparta.greg.pom.pages.AssessmentBreakdown;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class
AssessmentBreakDownTest {
    WebDriver webDriver;
    AssessmentBreakdown assessmentBreakdownPage;
    //add previous pages here for path with trainer name and password

    @BeforeEach
    public void setup() {
        webDriver = new ChromeDriver();
        //log in as a trainer
        //assessment page and choose a trainee
        assessmentBreakdownPage = new AssessmentBreakdown(webDriver);
    }

    @Test
    @DisplayName("Test the first click plus icon")
    void clickFirstPlusIcon() {
        assessmentBreakdownPage.goToAssessmentBreakdownPage();
        assessmentBreakdownPage.clickPlusIconFirstModule();
        //Assertions.assertEquals();
    }

    @Test
    @DisplayName("Test the second click plus icon")
    void clickSecondPlusIcon() {
        assessmentBreakdownPage.goToAssessmentBreakdownPage();
        assessmentBreakdownPage.clickPlusIconSecondModule();
        //Assertions.assertEquals();
    }

    @AfterEach
	void close(){
		webDriver.close();
	}
}
