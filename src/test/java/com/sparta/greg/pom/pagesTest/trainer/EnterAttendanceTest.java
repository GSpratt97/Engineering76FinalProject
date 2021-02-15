package com.sparta.greg.pom.pagesTest.trainer;

import com.sparta.greg.pom.pages.trainer.EnterAttendance;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class EnterAttendanceTest {

    WebDriver webDriver;
    EnterAttendance attendancePage;
    Properties properties = new Properties();

    @Before
    public void setUp()
    {
        // Get properties for sign in
        try {
            properties.load(new FileReader("src/test/resources/login.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //set up a webpage in isolation for testing
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
        webDriver = new ChromeDriver(option);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Path path = Paths.get("src/test/resources/pageTest/trainer/Attendance.html");
        webDriver.get(path.toUri().toString());
        Assertions.assertDoesNotThrow(()->attendancePage = new EnterAttendance(webDriver),
                "Initializing /trainer/attendanceEntry page");
    }


    @Test
    public void radioButtons()
    {
        //assertions
        //R1
        attendancePage.selectAttendanceType("On Time");
        Assertions.assertTrue(webDriver.findElement(By.id("attendanceId1")).isSelected());

        //R2
        attendancePage.selectAttendanceType("Late");
        Assertions.assertTrue(webDriver.findElement(By.id("attendanceId2")).isSelected());

        //R3
        attendancePage.selectAttendanceType("Absent (Excused)");
        Assertions.assertTrue(webDriver.findElement(By.id("attendanceId3")).isSelected());

        //R4
        attendancePage.selectAttendanceType("Absent (Unexcused)");
        Assertions.assertTrue(webDriver.findElement(By.id("attendanceId4")).isSelected());

    }

    @Test
    public void changeTrainee()
    {
        //assertions
        attendancePage.selectTrainee("David");
        Assertions.assertTrue(webDriver.findElement(By.name("traineeId")).getText().contains("David"));
        attendancePage.selectTrainee("Bill");
        Assertions.assertTrue(webDriver.findElement(By.name("traineeId")).getText().contains("Bill"));
    }

    @Test
    public void changeDate()
    {
        String date = "22-09-2020";
        attendancePage.selectDate(date);
        Assertions.assertTrue(attendancePage.isCorrectDate(date));
    }

    @After
    public void tearDown()
    {
        webDriver.quit();
    }
}
