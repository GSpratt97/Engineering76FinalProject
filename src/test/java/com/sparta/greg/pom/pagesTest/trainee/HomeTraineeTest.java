package com.sparta.greg.pom.pagesTest.trainee;

import com.sparta.greg.pom.pages.trainee.HomeTrainee;
import com.sparta.greg.pom.pages.components.Login;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class HomeTraineeTest {

    private static WebDriver webDriver;
    private static Login login;
    private static HomeTrainee homeTrainee;

    private static Properties properties = new Properties();
    private static String traineeUsername;
    private static String traineePassword;


    @BeforeEach
    void setup() {
        webDriver = new ChromeDriver();
        login = new Login(webDriver);
        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
            traineeUsername = properties.getProperty("traineeUsername");
            traineePassword = properties.getProperty("traineePassword");
        } catch (IOException e) {
            e.printStackTrace();
        }
        login.enterUsernameAddress(traineeUsername);
        login.enterPassword(traineePassword);
        login.clickSubmitButton();
        homeTrainee = new HomeTrainee(webDriver);
    }

    @Test
    @DisplayName("Go to Home Trainee Page")
    void goToHomeTraineePage() {
        Assertions.assertEquals("http://localhost:8080/trainee/home", webDriver.getCurrentUrl());
    }

    @Test
    @DisplayName("Get Trainee Full Name")
    void getTraineeFullName() {
        Assertions.assertEquals("Bill Bird", homeTrainee.getFullName());
    }

    @Test
    @DisplayName("Get Trainee Assigned Class")
    void getTraineeAssignedClass() {
        Assertions.assertEquals("Engineering 72", homeTrainee.getAssignedClass());
    }

    @Test
    @DisplayName("Go to Consultancy Skills")
    void goToConsultancySkills() {
        homeTrainee.getSideBarTrainee().selectView();
        homeTrainee.getSideBarTrainee().goToConsultancySkills();
    }

    @Test
    @DisplayName("Get Trainee Course Assigned")
    void getTraineeCourseAssigned() {
        Assertions.assertEquals("Java Development", homeTrainee.getCourseAssigned());
    }

    @Test
    @DisplayName("Get Trainee Current Week of Course")
    void getTraineeCurrentWeekOfCourse() {
        Assertions.assertEquals("12", homeTrainee.getCurrentWeekOfCourse());
    }

    @Test
    @DisplayName("Get Trainee On Time ")
    void getAverageOnTime() {
        //the expected result will probably need to change as time goes
        Assertions.assertEquals("NO ENTRY", homeTrainee.getOnTime());
    }

    @Test
    @DisplayName("Get Trainee Late")
    void getTraineeLate() {
        Assertions.assertEquals("NO ENTRY", homeTrainee.getLate());
    }

    @Test
    @DisplayName("Get Trainee Excused Absense")
    void getTraineeExcusedAbsense() {
        Assertions.assertEquals("NO ENTRY", homeTrainee.getExcusedAbsence());
    }

    @Test
    @DisplayName("Get Trainee Unexcused Absense")
    void getTraineeUnexcusedAbsense() {
        Assertions.assertEquals("NO ENTRY", homeTrainee.getUnexcusedAbsence());
    }

    @Test
    @DisplayName("Get Trainee Consultant Grade")
    void getTraineeConsultantGrade() {
        Assertions.assertEquals("C", homeTrainee.getConsultantGrade());
    }

    @Test
    @DisplayName("Get Trainee Technical Grade")
    void getTraineeTechnicalGrade() {
        Assertions.assertEquals("C", homeTrainee.getTechnicalGrade());
    }

    @Test
    @DisplayName("Get Trainee Overall Grade")
    void getTraineeOverallGrade() {
        Assertions.assertEquals("C", homeTrainee.getOverallGrade());
    }

    @Nested
    @DisplayName("Assessments Breakdown")
    class AssessmentsBreakdown {
        @Test
        @DisplayName("Get SQL Click")
        void getSqlClick() {
            homeTrainee.sqlTabExtend();
        }

        @Test
        @DisplayName("Get NonSQl Click")
        void getNonSQlClick() {
            homeTrainee.notSqlTabExtend();
        }

        @Test
        @DisplayName("Get SQL Score")
        void getSqlScore() {
            homeTrainee.sqlTabExtend();
            Assertions.assertEquals("30.9%", homeTrainee.getSqlScore());
        }

        @Test
        @DisplayName("Get SQL Duration")
        void getSqlDuration() {
            homeTrainee.sqlTabExtend();
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapseSQL > div:nth-child(2) > div.col-4")));
            Assertions.assertEquals("77 mins", homeTrainee.getSqlDuration());
        }

        @Test
        @DisplayName("Get SQL Comparative Score")
        void getSqlComparativeScore() {
            homeTrainee.sqlTabExtend();
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapseSQL > div:nth-child(3) > div.col-4")));
            Assertions.assertEquals("27%", homeTrainee.getSqlComparativeScore());
        }

        @Test
        @DisplayName("Get SQL Design Score")
        void getSqlDesignScore() {
            homeTrainee.sqlTabExtend();
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapseSQL > div:nth-child(1) > div.col-4")));
            Assertions.assertEquals("16%", homeTrainee.getSqlDesignScore());
        }

        @Test
        @DisplayName("Get SQL Language and Knowledge Score")
        void getSqlLanguageAndKnowledgeScore() {
            homeTrainee.sqlTabExtend();
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapseSQL > div:nth-child(2) > div.col-4")));
            Assertions.assertEquals("29%", homeTrainee.getSqlLanguageAndKnowledgeScore());
        }

        @Test
        @DisplayName("Get SQL Problem Solving Score")
        void getSqlProblemSolvingScore() {
            homeTrainee.sqlTabExtend();
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapseSQL > div:nth-child(3) > div.col-4")));
            Assertions.assertEquals("40%", homeTrainee.getSqlProblemSolvingScore());
        }

        @Test
        @DisplayName("Get Not SQL Score")
        void getNotSqlScore() {
            homeTrainee.notSqlTabExtend();
            Assertions.assertEquals("78.0%", homeTrainee.getNotSqlScore());
        }

        @Test
        @DisplayName("Get Not SQL Duration")
        void getNonSqlDuration() {
            homeTrainee.notSqlTabExtend();
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapseNotSQL > div:nth-child(2) > div.col-4")));
            Assertions.assertEquals("77 mins", homeTrainee.getNotSqlDuration());
        }

        @Test
        @DisplayName("Get Not SQL Design Score")
        void getNotSqlDesignScore() {
            homeTrainee.notSqlTabExtend();
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapseNotSQL > div:nth-child(1) > div.col-4")));
            Assertions.assertEquals("16%", homeTrainee.getNotSqlDesignScore());
        }

        @Test
        @DisplayName("Get Not SQL Language and Knowledge Score")
        void getNotSqlLanguageAndKnowledgeScore() {
            homeTrainee.notSqlTabExtend();
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapseNotSQL > div:nth-child(2) > div.col-4")));
            Assertions.assertEquals("29%", homeTrainee.getNotSqlLanguageAndKnowledgeScore());
        }

        @Test
        @DisplayName("Get Not SQL Problem Solving Score")
        void getNotSqlProblemSolvingScore() {
            homeTrainee.notSqlTabExtend();
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapseNotSQL > div:nth-child(3) > div.col-4")));
            Assertions.assertEquals("40%", homeTrainee.getNotSqlProblemSolvingScore());
        }

        @Test
        @DisplayName("Get SQL Comparative Score")
        void getNotSqlComparativeScore() {
            homeTrainee.notSqlTabExtend();
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#collapseNotSQL > div:nth-child(3) > div.col-4")));
            Assertions.assertEquals("27%", homeTrainee.getNotSqlComparativeScore());
        }

    }


}
