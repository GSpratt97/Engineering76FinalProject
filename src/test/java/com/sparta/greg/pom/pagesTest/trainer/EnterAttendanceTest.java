package com.sparta.greg.pom.pagesTest.trainer;

import com.sparta.greg.pom.pages.Login;
import com.sparta.greg.pom.pages.trainer.HomeTrainer;
import com.sparta.greg.pom.pages.utilities.PropertyLoader;
import com.sparta.greg.pom.pages.trainer.EnterAttendance;
import com.sparta.greg.pom.webDriverFactory.WebDriverFactory;
import com.sparta.greg.pom.webDriverFactory.WebDriverType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class EnterAttendanceTest {

    WebDriver webDriver;
    EnterAttendance attendancePage;
    Properties properties = new Properties();

    public void isolated() {
        // Get properties for sign in
        PropertyLoader.loadProperties();
        properties = PropertyLoader.properties;
        //set up a webpage in isolation for testing
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors");
        webDriver = new ChromeDriver(option);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Path path = Paths.get("src/test/resources/pageTest/trainer/Attendance.html");
        webDriver.get(path.toUri().toString());
        Assertions.assertDoesNotThrow(() -> attendancePage = new EnterAttendance(webDriver),
                "Initializing /trainer/attendanceEntry page");
    }


    public void webEdition()
    {
        webDriver = WebDriverFactory.runHeadless(WebDriverType.CHROME);
        PropertyLoader.loadProperties();
        properties = PropertyLoader.properties;
        //SignIn
        Login login = new Login(webDriver);
        webDriver.get("http://localhost:8080");
        HomeTrainer trainer = login.logInAsTrainer(properties.getProperty("trainerUsername"),properties.getProperty("trainerPassword") );
        attendancePage = trainer.goToEnterAttendanceThroughDashboard();

        //Go to right page
        webDriver.get("http://localhost:8080/trainer/attendanceEntry");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        attendancePage = new EnterAttendance(webDriver);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        attendancePage.setPageConfirm();
    }

    @Test
    public void radioButtons()
    {
        isolated();
        //assertions
        //R1
        attendancePage.selectAttendanceType("On Time");
        Assertions.assertTrue(attendancePage.isCorrectAttendanceType("attendanceId1"));

        //R2
        attendancePage.selectAttendanceType("Late");
        Assertions.assertTrue(attendancePage.isCorrectAttendanceType("attendanceId2"));

        //R3
        attendancePage.selectAttendanceType("Absent (Excused)");
        Assertions.assertTrue(attendancePage.isCorrectAttendanceType("attendanceId3"));

        //R4
        attendancePage.selectAttendanceType("Absent (Unexcused)");
        Assertions.assertTrue(attendancePage.isCorrectAttendanceType("attendanceId4"));

    }

    @Test
    public void changeTrainee()
    {
        isolated();
        //assertions
        attendancePage.selectTrainee("David");
        Assertions.assertTrue(webDriver.findElement(By.name("traineeId")).getText().contains("David"));
        attendancePage.selectTrainee("Bill");
        Assertions.assertTrue(webDriver.findElement(By.name("traineeId")).getText().contains("Bill"));
    }

    @Test
    public void changeDate()
    {
        webEdition();
        Assertions.assertTrue(attendancePage.areOnAttendanceEntryPage("Set Trainee Attendance"));
        String date = "22-09-2020";
        String formattedDate = attendancePage.formatDateForDriverType(date, webDriver);
        attendancePage.selectDate(formattedDate);
        attendancePage.submit();
        Assertions.assertTrue(attendancePage.isCorrectDate(date));
    }

    @After
    public void tearDown()
    {
        webDriver.quit();
    }
}
