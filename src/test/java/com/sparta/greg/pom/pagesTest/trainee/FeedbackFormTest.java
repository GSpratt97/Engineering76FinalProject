package com.sparta.greg.pom.pagesTest.trainee;

import com.sparta.greg.pom.pages.components.PropertyLoader;
import com.sparta.greg.pom.pages.trainee.FeedbackForm;
import com.sparta.greg.pom.pages.components.Login;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



public class FeedbackFormTest {

    private static WebDriver webDriver;
    private static FeedbackForm feedbackForm;

    @BeforeAll
    static void setup(){
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080/trainee/report/12");

        Properties properties = PropertyLoader.properties;
        PropertyLoader.loadProperties();
        webDriver.get("http://localhost:8080/login");
        Login login = new Login(webDriver);
        login.enterUsernameAddress(properties.getProperty("traineeUsername"));
        login.enterPassword(properties.getProperty("traineePassword"));
        login.clickSubmitButton();
        feedbackForm = new FeedbackForm(webDriver);

        webDriver.get("http://localhost:8080/trainee/report/12");

    }


    @Test
    @DisplayName("Checking can access and edit the start text box")
    void checkCanAccessStart(){
        Assertions.assertTrue(feedbackForm.enterStart("Editing start", 10));
    }


    @Test
    @DisplayName("Checking start method can handle null")
    void checkStartCanHandleNull(){
        Assertions.assertFalse(feedbackForm.enterStart(null, 0));
    }

    @Test
    @DisplayName("Checking start method can handle empty values")
    void checkStartCanHandleEmpty(){
        Assertions.assertFalse(feedbackForm.enterStart(" ", 0));
    }


    @Test
    @DisplayName("Checking can access and edit the stop text box")
    void checkCanAccessStop(){
        Assertions.assertTrue(feedbackForm.enterStop("Editing stop", 12));
    }

    @Test
    @DisplayName("Checking stop method can handle empty String")
    void checkStopCanHandleEmpty(){
        Assertions.assertFalse(feedbackForm.enterStop(" ", 0));
    }

    @Test
    @DisplayName("Checking stop method can handle null values")
    void checkStopCanHandleNull(){
        Assertions.assertFalse(feedbackForm.enterStop(null, 0));
    }

    @Test
    @DisplayName("Checking can access and edit the continue text box")
    void checkCanAccessContinue(){
        Assertions.assertTrue(feedbackForm.enterContinue("Editing continue", 25));
    }

    @Test
    @DisplayName("Checking continue method can handle empty String")
    void checkContinueCanHandleEmpty(){
        Assertions.assertFalse(feedbackForm.enterContinue(" ", 0));
    }

    @Test
    @DisplayName("Checking continue method can handle null values")
    void checkContinueCanHandleNull(){
        Assertions.assertFalse(feedbackForm.enterContinue(null, 0));
    }


    @Test
    @DisplayName("Checking that the technical grade can be selected")
    void checkCanAccessTechnicalButton(){
        Assertions.assertTrue(feedbackForm.isTechnicalGradeSelected("A"));
    }


    @Test
    @DisplayName("Checking that the technical grade method can handle empty values")
    void checkTechnicalCanHandleEmpty(){
        Assertions.assertFalse(feedbackForm.isTechnicalGradeSelected(" "));
    }


    @Test
    @DisplayName("Checking that the technical grade method can handle null values")
    void checkCanHandleNull(){
        Assertions.assertFalse(feedbackForm.isTechnicalGradeSelected(null));
    }

    @Test
    @DisplayName("Checking that the consultant grade can be selected")
    void checkCanAccessConsultantButton(){
        Assertions.assertTrue(feedbackForm.isConsultantGradeSelected("D"));
    }

    @Test
    @DisplayName("Checking that the consultant grade method can handle empty values")
    void checkCanHandleEmpty(){
        Assertions.assertFalse(feedbackForm.isConsultantGradeSelected(" "));
    }

    @Test
    @DisplayName("Checking that the consultant grade method can handle null values")
    void checkConsultantCanHandleNull(){
        Assertions.assertFalse(feedbackForm.isConsultantGradeSelected(null));
    }

    @Test
    @DisplayName("Checking that a null element can be handled")
    void checkCanHandleNullElement(){
        Assertions.assertFalse(feedbackForm.checkElement(null));
    }





}
