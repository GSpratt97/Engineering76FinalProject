package com.sparta.greg.demo;

import com.sparta.greg.pom.pages.components.Login;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBed {

    // Create a trainee
    // Assign to a existing class
    // delete trainee after

    private static WebDriver webDriver;

    @BeforeEach
    void setup() {
        webDriver = new ChromeDriver();
    }

    @Test
    @DisplayName("longTest")
    void longTest() {
        webDriver.get("http://localhost:8080");
        webDriver.findElement(By.cssSelector("input[name='username'][type='email']")).sendKeys("pleaselogin@sparta.com");
        webDriver.findElement(By.cssSelector("input[name='password'][type='password']")).sendKeys("Engineering76");
        webDriver.findElement(By.cssSelector("button[type='submit']")).click();
        // Selected trainee options
        boolean isClosed = webDriver.findElement(By.cssSelector("a[data-target*='#collapsePages']")).getAttribute("class").contains("collapsed");
        if (isClosed) {
            webDriver.findElement(By.cssSelector("a[data-target*='#collapsePages']")).click();
        }
        // click trainee management
        webDriver.findElement(By.cssSelector("a[href*='/trainer/manageTrainee']")).click();
        // create a new trainee
        webDriver.findElement(By.cssSelector("input[id='email']")).sendKeys("long@sparta.com");
        webDriver.findElement(By.cssSelector("input[id='firstName']")).sendKeys("Nathan");
        webDriver.findElement(By.cssSelector("input[id='lastName']")).sendKeys("long");
        Select dropdownClass = new Select(webDriver.findElement(By.cssSelector("select[id*='groupId']")));
        dropdownClass.selectByVisibleText("Engineering 65");
//        webDriver.findElement(By.cssSelector("button[type='submit']")).click();
//        // I want to use the pom this is too long
//        // go to management class
//        webDriver.findElement(By.cssSelector("a[data-target*='#collapsePages']")).click();
//        webDriver.findElement(By.cssSelector("a[href*='/trainer/manageClass']")).click();
//        // assign trainee to class
//        Select dropdownTrainee = new Select(webDriver.findElement(By.cssSelector("select[name='traineeId']")));
//        dropdownTrainee.selectByVisibleText("Nathan Long");
//        Select dropdownTraineeClass = new Select(webDriver.findElement(By.cssSelector("select[name='groupId']")));
//        dropdownTraineeClass.selectByVisibleText("Engineering 65");
//        // Go back to trainee management
//        webDriver.findElement(By.cssSelector("a[data-target*='#collapsePages']")).click();
//        webDriver.findElement(By.cssSelector("a[href*='/trainer/manageTrainee']")).click();
//        // delete trainee
//        Select dropdownDeleteTrainee = new Select(webDriver.findElement(By.cssSelector("select[name*='trainee']")));
//        dropdownDeleteTrainee.selectByVisibleText("Nathan Long");
//        webDriver.findElement(By.cssSelector("form[action='/trainer/deleteTrainee'] button[type='submit']")).click();
    }

    @Test
    @DisplayName("withPOMTest")
    void withPomTest() {

    }

}
